package com.upbCanteen.backend.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upbCanteen.backend.dto.UserLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UserLoginDTO credentials = new ObjectMapper()
                    .readValue(request.getInputStream(), UserLoginDTO.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            credentials.getEmail(),
                            credentials.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        UserPrincipal userPrincipal = (UserPrincipal) authResult.getPrincipal();

        String token = JwtTokenFactory.create(userPrincipal.getUsername());

        response.addHeader(JwtProperties.HEADER_STRING,JwtProperties.TOKEN_PREFIX + token);

        if(userPrincipal.getAuthorities().size() == 1){
            response.getWriter().write("{\"role\": \"" + userPrincipal.getAuthorities().toArray()[0].toString() + "\"}");
            response.getWriter().flush();
            response.getWriter().close();
        }else {
            response.getWriter().write("{\"role\": \"" + userPrincipal.getAuthorities().toArray()[0].toString() +
                    "\",\"cafeteria\": \""+ userPrincipal.getAuthorities().toArray()[1].toString() + "\"}");
            response.getWriter().flush();
            response.getWriter().close();

        }

    }
}
