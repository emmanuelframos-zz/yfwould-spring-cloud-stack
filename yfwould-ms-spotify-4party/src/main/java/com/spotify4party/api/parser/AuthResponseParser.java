package com.partytime.api.parser;

import com.partytime.api.dto.AuthResponseDTO;
import com.partytime.integration.dto.authenticate.SpotifyAuthtResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class AuthResponseParser {

    public AuthResponseDTO toDomain(SpotifyAuthtResponseDTO spotifyAuthtResponseDTO) {
        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        authResponseDTO.accessToken = spotifyAuthtResponseDTO.accessToken;
        authResponseDTO.expiresIn = spotifyAuthtResponseDTO.expiresIn;
        authResponseDTO.scope = spotifyAuthtResponseDTO.scope;
        authResponseDTO.tokenType = spotifyAuthtResponseDTO.tokenType;
        return authResponseDTO;
    }
}
