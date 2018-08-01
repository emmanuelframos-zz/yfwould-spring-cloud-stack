package com.partytime.service;

import com.partytime.api.dto.AuthResponseDTO;
import com.partytime.api.dto.PlaylistDTO;
import com.partytime.api.parser.AuthResponseParser;
import com.partytime.api.parser.PlaylistParser;
import com.partytime.api.validator.PlaylistSearchValidator;
import com.partytime.exception.BusinessException;
import com.partytime.integration.dto.authenticate.SpotifyAuthtResponseDTO;
import com.partytime.integration.dto.playlistTracks.SpotifyPlaylistDTO;
import com.partytime.integration.service.SpotifyAuthorizationIntegrationService;
import com.partytime.integration.service.SpotifyWebIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyTimeService {

    @Autowired
    private SpotifyAuthorizationIntegrationService spotifyAuthorizationIntegrationService;

    @Autowired
    private SpotifyWebIntegrationService spotifyWebIntegrationService;

    @Autowired
    private AuthResponseParser authResponseParser;

    @Autowired
    private PlaylistParser playlistParser;

    @Autowired
    private PlaylistSearchValidator playlistSearchValidator;

    public AuthResponseDTO authenticate(){
        SpotifyAuthtResponseDTO spotifyAuthtResponseDTO = spotifyAuthorizationIntegrationService.authenticate();
        return authResponseParser.toDomain(spotifyAuthtResponseDTO);
    }

    public PlaylistDTO findPlaylistById(String playlistId) throws BusinessException {

        playlistSearchValidator.validatePlaylistId(playlistId);

        AuthResponseDTO authResponseDTO = this.authenticate();

        SpotifyPlaylistDTO spotifyPlaylistDTO = spotifyWebIntegrationService.findPlaylistById(authResponseDTO.accessToken, playlistId);

        return playlistParser.toDomain(spotifyPlaylistDTO);
    }

    public PlaylistDTO findDefaultPlaylist() {
        SpotifyPlaylistDTO spotifyPlaylistDTO = spotifyWebIntegrationService.findDefaultPlaylist();
        return playlistParser.toDomain(spotifyPlaylistDTO);
    }
}