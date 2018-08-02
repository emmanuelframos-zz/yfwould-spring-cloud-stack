package com.goodweather4party.api;

import com.goodweather4party.api.dto.PlaylistDTO;
import com.goodweather4party.api.dto.PlaylistFilterDTO;
import com.goodweather4party.exception.BusinessException;
import com.goodweather4party.service.GoodWeather4PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GoodWeather4PartyAPI {

    @Autowired
    private GoodWeather4PartyService goodWeather4PartyService;

    @GetMapping("/playlist")
    public PlaylistDTO suggestPlaylist(PlaylistFilterDTO playlistFilterDTO) throws BusinessException {
        return goodWeather4PartyService.suggestPlaylist(playlistFilterDTO);
    }
}