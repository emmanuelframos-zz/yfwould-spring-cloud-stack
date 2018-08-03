package com.spotify4party.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spotify4party.api.dto.AuthResponseDTO;
import com.spotify4party.api.dto.PlaylistDTO;
import com.spotify4party.api.parser.AuthResponseParser;
import com.spotify4party.api.parser.PlaylistParser;
import com.spotify4party.api.validator.AuthenticationValidator;
import com.spotify4party.api.validator.PlaylistSearchValidator;
import com.spotify4party.exception.BusinessException;
import com.spotify4party.integration.dto.authenticate.SpotifyAuthtResponseDTO;
import com.spotify4party.integration.dto.playlistTracks.SpotifyPlaylistDTO;
import com.spotify4party.integration.service.SpotifyAuthorizationIntegrationService;
import com.spotify4party.integration.service.SpotifyWebIntegrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Spotify4PartyService {

    private static final Logger logger = LoggerFactory.getLogger(Spotify4PartyService.class);

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

    @Autowired
    private AuthenticationValidator authenticationValidator;

    @HystrixCommand(commandKey = "fallback_authenticate", fallbackMethod = "findDefaultPlaylist")
    public AuthResponseDTO authenticate() throws BusinessException {

        logger.info("Authenticate on Spotify.");

        SpotifyAuthtResponseDTO spotifyAuthtResponseDTO = spotifyAuthorizationIntegrationService.authenticate();

        logger.info("Converting authorization to domain.");

        AuthResponseDTO authResponseDTO = authResponseParser.toDomain(spotifyAuthtResponseDTO);

        authenticationValidator.validateAuthentication(authResponseDTO);

        return authResponseDTO;
    }

    @HystrixCommand(commandKey = "fallback_playlist", fallbackMethod = "findDefaultPlaylist")
    public PlaylistDTO findPlaylistById(String playlistId) throws BusinessException {

        logger.info("Validating playlist id.");

        playlistSearchValidator.validatePlaylistId(playlistId);

        AuthResponseDTO authResponseDTO = this.authenticate();

        logger.info("Searching playlist on Spotify.");

        SpotifyPlaylistDTO spotifyPlaylistDTO = spotifyWebIntegrationService.findPlaylistById(authResponseDTO.accessToken, playlistId);

        logger.info("Converting playlist to domain.");

        return playlistParser.toDomain(spotifyPlaylistDTO);
    }

    private PlaylistDTO findDefaultPlaylist(String playlistId) {

        logger.info("Getting default playlist.");

        SpotifyPlaylistDTO spotifyPlaylistDTO = spotifyWebIntegrationService.findDefaultPlaylist();

        return playlistParser.toDomain(spotifyPlaylistDTO);
    }
}