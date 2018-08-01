package com.partytime.api;

import com.partytime.api.dto.AuthResponseDTO;
import com.partytime.api.dto.PlaylistDTO;
import com.partytime.exception.BusinessException;
import com.partytime.service.PartyTimeService;
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