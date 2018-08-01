package com.partytime.integration.service;

import com.partytime.config.SpotifyWebConfig;
import com.partytime.integration.builder.DefaultPlaylistBuilder;
import com.partytime.integration.dto.playlistTracks.SpotifyPlaylistDTO;
import com.partytime.integration.handler.ResponseHandler;
import com.yfwould.rest.UnderratedRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SpotifyWebIntegrationService {

    @Autowired
    private SpotifyWebConfig spotifyConfig;

    @Autowired
    private ResponseHandler responseHandler;

    public SpotifyPlaylistDTO findPlaylistById(String token, String playlistId){
        ResponseEntity<SpotifyPlaylistDTO> response = UnderratedRestClient.build()
                .addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString())
                .addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .baseUrl(spotifyConfig.getWebAPI())
                .resource(spotifyConfig.getPlaylistTracksService()
                        .replace("{user_id}", spotifyConfig.getUserId())
                        .replace("{playlist_id}", playlistId))
                .method(HttpMethod.GET)
                .execute(SpotifyPlaylistDTO.class);


        return responseHandler.handleResponse(response);
    }

    public SpotifyPlaylistDTO findDefaultPlaylist() {
        return DefaultPlaylistBuilder.buildPlaylist();
    }
}