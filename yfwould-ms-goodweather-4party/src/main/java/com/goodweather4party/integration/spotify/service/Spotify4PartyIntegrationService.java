package com.goodweather4party.integration.spotify.service;

import com.goodweather4party.integration.spotify.dto.ExternalPlaylistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Spotify4PartyIntegrationService {

    @Autowired
    private Spotify4PartyClient partyTimeClient;

    public ExternalPlaylistDTO findPlaylistById(String playlistId){
        return partyTimeClient.findPlaylistById(playlistId);
    }

    public ExternalPlaylistDTO findDefaultPlaylist(){
        return null;
    }
}