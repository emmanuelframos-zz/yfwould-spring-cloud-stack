package com.goodweather4party.unit;

import com.goodweather4party.api.dto.PlaylistFilterDTO;
import com.goodweather4party.api.validator.PlaylistFilterValidator;
import com.goodweather4party.exception.BusinessException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PlaylistFilterValidatorTest {

    @Spy
    private PlaylistFilterValidator playlistFilterValidator;

    @Test
    public void testPlaylistCityNameOK() throws BusinessException {
        PlaylistFilterDTO playlistFilterDTO = new PlaylistFilterDTO();
        playlistFilterDTO.cityName = "Curitiba";
        playlistFilterValidator.validate(playlistFilterDTO);
    }

    @Test
    public void testPlaylistLatAndLongOK() throws BusinessException {
        PlaylistFilterDTO playlistFilterDTO = new PlaylistFilterDTO();
        playlistFilterDTO.latitude = 1;
        playlistFilterDTO.longitude = 1;
        playlistFilterValidator.validate(playlistFilterDTO);
    }

    @Test(expected = BusinessException.class)
    public void testPlaylistNullFail() throws BusinessException {
        playlistFilterValidator.validate(null);
    }

    @Test(expected = BusinessException.class)
    public void testNoParamsFail() throws BusinessException {
        PlaylistFilterDTO playlistFilterDTO = new PlaylistFilterDTO();
        playlistFilterValidator.validate(playlistFilterDTO);
    }

    @Test(expected = BusinessException.class)
    public void testAllFiltersFail() throws BusinessException {
        PlaylistFilterDTO playlistFilterDTO = new PlaylistFilterDTO();
        playlistFilterDTO.cityName = "Curitiba";
        playlistFilterDTO.latitude = 1;
        playlistFilterDTO.longitude = 1;
        playlistFilterValidator.validate(playlistFilterDTO);
    }

    @Test(expected = BusinessException.class)
    public void testPlaylistHasCityNameAndLatFail() throws BusinessException {
        PlaylistFilterDTO playlistFilterDTO = new PlaylistFilterDTO();
        playlistFilterDTO.cityName = "Curitiba";
        playlistFilterDTO.latitude = 1;
        playlistFilterValidator.validate(playlistFilterDTO);
    }

    @Test(expected = BusinessException.class)
    public void testPlaylistHasCityNameAndLongFail() throws BusinessException {
        PlaylistFilterDTO playlistFilterDTO = new PlaylistFilterDTO();
        playlistFilterDTO.cityName = "Curitiba";
        playlistFilterDTO.longitude = 1;
        playlistFilterValidator.validate(playlistFilterDTO);
    }

    @Test(expected = BusinessException.class)
    public void testPLaylistHasLatitudeNoLongitude() throws BusinessException {
        PlaylistFilterDTO playlistFilterDTO = new PlaylistFilterDTO();
        playlistFilterDTO.latitude = 1;
        playlistFilterValidator.validate(playlistFilterDTO);
    }

    @Test(expected = BusinessException.class)
    public void testPLaylistHasLongitudeNoLatitude() throws BusinessException {
        PlaylistFilterDTO playlistFilterDTO = new PlaylistFilterDTO();
        playlistFilterDTO.longitude = 1;
        playlistFilterValidator.validate(playlistFilterDTO);
    }
}