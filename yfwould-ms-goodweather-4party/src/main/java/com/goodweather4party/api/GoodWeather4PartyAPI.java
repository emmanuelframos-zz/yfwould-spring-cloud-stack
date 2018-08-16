package com.goodweather4party.api;

import com.goodweather4party.api.dto.PlaylistDTO;
import com.goodweather4party.api.dto.PlaylistFilter;
import com.goodweather4party.exception.BusinessException;
import com.goodweather4party.service.GoodWeather4PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GoodWeather4PartyAPI {

    @Autowired
    private GoodWeather4PartyService goodWeather4PartyService;

    @GetMapping("/playlist/city")
    public PlaylistDTO suggestPlaylistByCity(@RequestParam String cityName) throws BusinessException {
        return goodWeather4PartyService.suggestPlaylist(PlaylistFilter
                .build()
                .cityName(cityName)
        );
    }

    @GetMapping("/playlist/coordinates")
    public PlaylistDTO suggestPlaylistByCoordinates(@RequestParam Integer latitude, @RequestParam Integer longitude) throws BusinessException {
        return goodWeather4PartyService.suggestPlaylist(PlaylistFilter
                .build()
                .latitude(latitude)
                .longitude(longitude)
        );
    }
}