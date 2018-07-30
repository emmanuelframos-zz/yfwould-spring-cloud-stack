package com.goodweatherpartytime.api;

import com.goodweatherpartytime.api.dto.PlaylistDTO;
import com.goodweatherpartytime.api.dto.PlaylistFilterDTO;
import com.goodweatherpartytime.service.GoodWeatherPartyTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GoodWeatherPartyTimeAPI {

    @Autowired
    private GoodWeatherPartyTimeService goodWeatherPartyTimeService;

    @GetMapping("/playlist")
    public PlaylistDTO suggestPlaylist(PlaylistFilterDTO playlistFilterDTO){
        return goodWeatherPartyTimeService.suggestPlaylist(playlistFilterDTO);
    }
}