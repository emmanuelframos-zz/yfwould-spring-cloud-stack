package com.goodweather4party.integration;

import com.goodweather4party.Application;
import com.goodweather4party.api.GoodWeather4PartyAPI;
import com.goodweather4party.api.dto.PlaylistFilterDTO;
import com.goodweather4party.domain.TrackStyles;
import com.goodweather4party.exception.BusinessException;
import com.goodweather4party.integration.openweather.dto.ExternalWeatherDTO;
import com.goodweather4party.integration.openweather.service.OpenWeather4PartyIntegrationService;
import com.goodweather4party.integration.redis.service.RedisService;
import com.goodweather4party.integration.spotify.dto.ExternalPlaylistDTO;
import com.goodweather4party.integration.spotify.dto.ExternalTrackDTO;
import com.goodweather4party.integration.spotify.service.Spotify4PartyIntegrationService;
import com.goodweather4party.loader.DataLoader;
import com.goodweather4party.service.TrackStyleSelector;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class GoodWeather4PartyAPITest {

    @Autowired
    private GoodWeather4PartyAPI goodWeather4PartyAPI;

    @MockBean
    private OpenWeather4PartyIntegrationService openWeather4PartyIntegrationService;

    @MockBean
    private Spotify4PartyIntegrationService spotify4PartyIntegrationService;

    @MockBean
    private TrackStyleSelector trackStyleSelector;

    @MockBean
    private RedisService redisService;

    @MockBean
    private DataLoader dataLoader;

    @Test
    public void testSuggestPlaylist() throws BusinessException {
        PlaylistFilterDTO playlistFilterDTO = new PlaylistFilterDTO();
        playlistFilterDTO.cityName = "Curitiba";

        ExternalWeatherDTO externalWeatherDTO = new ExternalWeatherDTO();
        externalWeatherDTO.temperature = 10;
        when(openWeather4PartyIntegrationService.findWeather(any())).thenReturn(externalWeatherDTO);

        when(trackStyleSelector.selectPlaylist(any())).thenReturn(TrackStyles.CLASSICAL);

        when(redisService.get(any())).thenReturn("DUMMY");

        ExternalTrackDTO externalTrackDTO = new ExternalTrackDTO();
        externalTrackDTO.artist = "Dummy Band";
        externalTrackDTO.name = "Dummy Song";
        ExternalPlaylistDTO externalPlaylistDTO = new ExternalPlaylistDTO();
        externalPlaylistDTO.tracks = Arrays.asList(externalTrackDTO);
        when(spotify4PartyIntegrationService.findPlaylistById(any())).thenReturn(externalPlaylistDTO);

        goodWeather4PartyAPI.suggestPlaylist(playlistFilterDTO);
    }
}
