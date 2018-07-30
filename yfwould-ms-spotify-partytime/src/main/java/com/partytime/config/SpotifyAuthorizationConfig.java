package com.partytime.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpotifyAuthorizationConfig {

    @Value("${spotify.authorizationAPI.url}")
    private String authorizationAPI;

    @Value("${spotify.authorizationAPI.clientID}")
    private String clientID;

    @Value("${spotify.authorizationAPI.clientSecret}")
    private String clientSecret;

    @Value("${spotify.authorizationAPI.scopeKey}")
    private String scopeKey;

    @Value("${spotify.authorizationAPI.scopeValue}")
    private String scopeValue;

    @Value("${spotify.authorizationAPI.grantTypeKey}")
    private String grantTypeKey;

    @Value("${spotify.authorizationAPI.grantTypeValue}")
    private String grantTypeValue;

    @Value("${spotify.authorizationAPI.services.authenticate}")
    private String authenticateService;

    public String getAuthorizationAPI() {
        return authorizationAPI;
    }

    public String getClientID() {
        return clientID;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getScopeKey() {
        return scopeKey;
    }

    public String getScopeValue() {
        return scopeValue;
    }

    public String getGrantTypeKey() {
        return grantTypeKey;
    }

    public String getGrantTypeValue() {
        return grantTypeValue;
    }

    public String getAuthenticateService() {
        return authenticateService;
    }
}