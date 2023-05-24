package com.upbCanteen.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter extends BasicAuthenticationFilter {
    private UserPrincipalService userPrincipalService;

    public AuthorizationFilter(AuthenticationManager authenticationManager,UserPrincipalService userPrincipalService) {
        super(authenticationManager);
        this.userPrincipalService = userPrincipalService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(JwtProperties.HEADER_STRING);
        if (header == null || !header.startsWith(JwtProperties.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
        }

        UsernamePasswordAuthenticationToken token = getAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(token);

        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(JwtProperties.HEADER_STRING);

        if (token != null) {
            token = token.replace(JwtProperties.TOKEN_PREFIX, "");
            String email = JwtTokenFactory.decode(token).getSubject();

            if (email != null) {
                UserPrincipal userPrincipal = (UserPrincipal) userPrincipalService.loadUserByUsername(email);
                return new UsernamePasswordAuthenticationToken(email, null, userPrincipal.getAuthorities());
            }

            return null;
        }

        return null;
    }
}
