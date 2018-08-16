package com.goodweather4party.unit;

import com.goodweather4party.api.dto.PlaylistFilter;
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
        playlistFilterValidator.validate(PlaylistFilter
                .build()
                .cityName("Curitiba")
        );
    }

    @Test
    public void testPlaylistLatAndLongOK() throws BusinessException {
        playlistFilterValidator.validate(PlaylistFilter
                .build()
                .latitude(1)
                .longitude(1)
        );
    }

    @Test(expected = BusinessException.class)
    public void testPlaylistNullFail() throws BusinessException {
        playlistFilterValidator.validate(null);
    }

    @Test(expected = BusinessException.class)
    public void testNoParamsFail() throws BusinessException {
        playlistFilterValidator.validate(PlaylistFilter
                .build()
        );
    }

    @Test(expected = BusinessException.class)
    public void testAllFiltersFail() throws BusinessException {
        playlistFilterValidator.validate(PlaylistFilter
                .build()
                .cityName("Curitiba")
                .longitude(1)
                .latitude(1)
        );
    }

    @Test(expected = BusinessException.class)
    public void testPlaylistHasCityNameAndLatFail() throws BusinessException {
        playlistFilterValidator.validate(PlaylistFilter
                .build()
                .cityName("Curitiba")
                .latitude(1)
        );
    }

    @Test(expected = BusinessException.class)
    public void testPlaylistHasCityNameAndLongFail() throws BusinessException {
        playlistFilterValidator.validate(PlaylistFilter
                .build()
                .cityName("Curitiba")
                .longitude(1)
        );
    }

    @Test(expected = BusinessException.class)
    public void testPLaylistHasLatitudeNoLongitude() throws BusinessException {
        playlistFilterValidator.validate(PlaylistFilter.
                build()
                .latitude(1)
        );
    }

    @Test(expected = BusinessException.class)
    public void testPLaylistHasLongitudeNoLatitude() throws BusinessException {
        playlistFilterValidator.validate(PlaylistFilter.
                build()
                .longitude(1)
        );
    }
}