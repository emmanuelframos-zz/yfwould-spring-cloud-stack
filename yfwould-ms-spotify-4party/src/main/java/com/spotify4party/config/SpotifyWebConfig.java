package com.spotify4party.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpotifyWebConfig {

    @Value("${spotify.webAPI.url}")
    private String webAPI;

    @Value("${spotify.webAPI.userID}")
    private String userId;

    @Value("${spotify.webAPI.services.playlistTracks}")
    private String playlistTracksService;

    public String getWebAPI() {
        return webAPI;
    }

    public String getPlaylistTracksService() {
        return playlistTracksService;
    }

    public String getUserId() {
        return userId;
    }
}
