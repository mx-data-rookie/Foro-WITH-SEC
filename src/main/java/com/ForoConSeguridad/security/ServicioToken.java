package com.ForoConSeguridad.security;

import com.ForoConSeguridad.user.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class ServicioToken {
    @Value("${api.security.secret}")
    private String hiddenSecret;

    public String generarToken(Usuario usuario){
        try{
            Algorithm algorithm = Algorithm.HMAC256(hiddenSecret);
            return JWT.create()
                    .withIssuer("edaprendemx")
                    .withSubject(usuario.getEmail())
                    .withClaim("id", usuario.getIdUsuario())
                    .withExpiresAt(fechaCaducidad())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }

    public String getSubject(String token) {
        if (token == null) {
            throw new RuntimeException();
        }

        DecodedJWT verifier = null;

        try {
            Algorithm algorithm = Algorithm.HMAC256(hiddenSecret);
            verifier = JWT.require(algorithm)
                    .withIssuer("edaprendemx")
                    .build()
                    .verify(token);
            verifier.getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException();
        }

        return verifier.getSubject();
    }

    private Instant fechaCaducidad(){
        return LocalDateTime.now().plusHours(6).toInstant(ZoneOffset.of("-06:00"));
    }
}
