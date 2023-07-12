package com.example.ecommerce.security.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app.jwt")
public class JwtConfigurationProperties {

    String secret;
    String token_expiration;
    String refresh_token_expiration;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getToken_expiration() {
        return token_expiration;
    }

    public void setToken_expiration(String token_expiration) {
        this.token_expiration = token_expiration;
    }

    public String getRefresh_token_expiration() {
        return refresh_token_expiration;
    }

    public void setRefresh_token_expiration(String refresh_token_expiration) {
        this.refresh_token_expiration = refresh_token_expiration;
    }

    @Override
    public String toString() {
        return "JwtConfigurationProperties{" +
                "secret='" + secret + '\'' +
                ", token_expiration='" + token_expiration + '\'' +
                ", refresh_token_expiration='" + refresh_token_expiration + '\'' +
                '}';
    }
}
