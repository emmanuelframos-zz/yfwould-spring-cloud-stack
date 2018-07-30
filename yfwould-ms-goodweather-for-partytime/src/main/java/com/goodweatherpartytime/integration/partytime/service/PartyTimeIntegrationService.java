package com.goodweatherpartytime.integration.partytime.service;

import com.goodweatherpartytime.integration.partytime.dto.ExternalPlaylistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyTimeIntegrationService {

    @Autowired
    private PartyTimeClient partyTimeClient;

    public ExternalPlaylistDTO findPlaylistById(String playlistId){
        return partyTimeClient.findPlaylistById(playlistId);
    }

    public ExternalPlaylistDTO findDefaultPlaylist(){
        return null;
    }
}