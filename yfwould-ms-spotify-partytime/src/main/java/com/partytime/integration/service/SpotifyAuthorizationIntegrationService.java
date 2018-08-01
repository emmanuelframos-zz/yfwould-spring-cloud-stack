package com.partytime.integration.service;

import com.partytime.config.SpotifyAuthorizationConfig;
import com.partytime.integration.dto.authenticate.SpotifyAuthtResponseDTO;
import com.partytime.rest.UnderratedRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;

@Service
public class SpotifyAuthorizationIntegrationService {

    @Autowired
    private SpotifyAuthorizationConfig spotifyConfig;

    public SpotifyAuthtResponseDTO authenticate(){
        ResponseEntity<SpotifyAuthtResponseDTO> response = UnderratedRestClient.build()
                .addInterceptor(new BasicAuthorizationInterceptor(spotifyConfig.getClientID(), spotifyConfig.getClientSecret()))
                .addMessageConverter(new FormHttpMessageConverter())
                .addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED.toString())
                .baseUrl(spotifyConfig.getAuthorizationAPI())
                .resource(spotifyConfig.getAuthenticateService())
                .method(HttpMethod.POST)
                .payload(new LinkedMultiValueMap<String,String>(){{
                    add(spotifyConfig.getGrantTypeKey(), spotifyConfig.getGrantTypeValue());
                    add(spotifyConfig.getScopeKey(), spotifyConfig.getScopeValue());
                }})
                .execute(SpotifyAuthtResponseDTO.class);

        return response.getBody();
    }
}