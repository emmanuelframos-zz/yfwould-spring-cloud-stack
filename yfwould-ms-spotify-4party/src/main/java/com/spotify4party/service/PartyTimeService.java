package com.spotify4party.service;

import com.spotify4party.api.dto.AuthResponseDTO;
import com.spotify4party.api.dto.PlaylistDTO;
import com.spotify4party.api.parser.AuthResponseParser;
import com.spotify4party.api.parser.PlaylistParser;
import com.spotify4party.api.validator.PlaylistSearchValidator;
import com.spotify4party.exception.BusinessException;
import com.spotify4party.integration.dto.authenticate.SpotifyAuthtResponseDTO;
import com.spotify4party.integration.dto.playlistTracks.SpotifyPlaylistDTO;
import com.spotify4party.integration.service.SpotifyAuthorizationIntegrationService;
import com.spotify4party.integration.service.SpotifyWebIntegrationService;
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