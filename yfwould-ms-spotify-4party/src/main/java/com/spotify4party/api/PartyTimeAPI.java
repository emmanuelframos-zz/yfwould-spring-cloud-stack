package com.spotify4party.api;

import com.spotify4party.api.dto.AuthResponseDTO;
import com.spotify4party.api.dto.PlaylistDTO;
import com.spotify4party.exception.BusinessException;
import com.spotify4party.service.spotify4partyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PartyTimeAPI {

    @Autowired
    private PartyTimeService partyTimeService;

    @GetMapping("/authenticate")
    public AuthResponseDTO authenticate(){
        return partyTimeService.authenticate();
    }

    @GetMapping("/playlist/{id}")
    public PlaylistDTO findPlaylistById(@PathVariable("id") String playlistId) throws BusinessException {
        return partyTimeService.findPlaylistById(playlistId);
    }

    @GetMapping("/playlist/default")
    public PlaylistDTO findTracksByPlaylistDefault(){
        return partyTimeService.findDefaultPlaylist();
    }
}