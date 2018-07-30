package com.goodweatherpartytime.integration.partytime.service;

import com.goodweatherpartytime.integration.partytime.dto.ExternalPlaylistDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="spotify-partytime")
public interface PartyTimeClient {

    @GetMapping("/api/v1/playlist/{playlistId}")
    ExternalPlaylistDTO findPlaylistById(@PathVariable("playlistId") String playlistId);

    @GetMapping("/api/v1/playlist/default")
    ExternalPlaylistDTO findDefaultPlaylist();

}
