package com.upbCanteen.backend.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtTokenFactory {
    static DecodedJWT decode(String JWtoken){
        return JWT.require(Algorithm.HMAC512(JwtProperties.SECRET.getBytes()))
                .build().verify(JWtoken);
    }

    static String create(String subject){
        return JWT.create().withSubject(subject).withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(JwtProperties.SECRET.getBytes()));
    }
}
