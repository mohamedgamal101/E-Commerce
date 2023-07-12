package com.example.ecommerce.security.utils;

import com.example.ecommerce.entities.User;
import com.example.ecommerce.security.config.JwtConfigurationProperties;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class JwtTokenUtil {

//    private static final long EXPIRE_DURATION = 60 * 60 * 1000;
//    private static final long EXPIRE_DURATION_REFRESH = 3 * 60 * 60 * 1000;
//    // 1 hour
//    @Value("${app.jwt.secret}")
//    private String SECRET_KEY;
    @Autowired
    JwtConfigurationProperties jwtConfigurationProperties;



    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);


    public String generateAccessToken(User user) {
        return Jwts.builder()
                .setSubject(String.format("%s,%s", user.getId(), user.getEmail()))
                .setIssuer("CodeJava")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + Integer.parseInt(jwtConfigurationProperties.getToken_expiration())))
                .signWith(SignatureAlgorithm.HS512, jwtConfigurationProperties.getSecret())
                .compact();

    }
    public String generateRefreshToken(User user) {
        return Jwts.builder()
                .setSubject(String.format("%s,%s", user.getId(), user.getEmail()))
                .setIssuer("CodeJava")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + Integer.parseInt(jwtConfigurationProperties.getRefresh_token_expiration())))
                .signWith(SignatureAlgorithm.HS512, jwtConfigurationProperties.getSecret())
                .compact();

    }



    public boolean validateAccessToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtConfigurationProperties.getSecret()).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex) {
            LOGGER.error("JWT expired", ex.getMessage());
        } catch (IllegalArgumentException ex) {
            LOGGER.error("Token is null, empty or only whitespace", ex.getMessage());
        } catch (MalformedJwtException ex) {
            LOGGER.error("JWT is invalid", ex);
        } catch (UnsupportedJwtException ex) {
            LOGGER.error("JWT is not supported", ex);
        } catch (SignatureException ex) {
            LOGGER.error("Signature validation failed");
        }

        return false;
    }

    public String getSubject(String token) {
        return parseClaims(token).getSubject();
    }

    private Claims parseClaims(String token) {
        return Jwts.parser()
                .setSigningKey(jwtConfigurationProperties.getSecret())
                .parseClaimsJws(token)
                .getBody();
    }
}