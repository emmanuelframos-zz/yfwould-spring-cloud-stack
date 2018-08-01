package com.goodweather4party.integration.spotify.service;

import com.goodweather4party.integration.spotify.dto.ExternalPlaylistDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="ms-spotify-4party")
public interface Spotify4PartyClient {

    @GetMapping("/api/v1/playlist/{playlistId}")
    ExternalPlaylistDTO findPlaylistById(@PathVariable("playlistId") String playlistId);

    @GetMapping("/api/v1/playlist/default")
    ExternalPlaylistDTO findDefaultPlaylist();

}
