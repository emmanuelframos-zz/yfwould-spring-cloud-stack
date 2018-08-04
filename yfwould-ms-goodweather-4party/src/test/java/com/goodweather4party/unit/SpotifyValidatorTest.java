package com.goodweather4party.unit;

import com.goodweather4party.exception.BusinessException;
import com.goodweather4party.integration.spotify.dto.ExternalPlaylistDTO;
import com.goodweather4party.integration.spotify.dto.ExternalTrackDTO;
import com.goodweather4party.integration.spotify.validator.SpotifyValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(SpringRunner.class)
public class SpotifyValidatorTest {

    @Spy
    private SpotifyValidator spotifyValidator;

    @Test
    public void testPlaylistOK() throws BusinessException {
        ExternalTrackDTO externalTrackDTO = new ExternalTrackDTO();
        externalTrackDTO.artist = "Dummy Band";
        externalTrackDTO.name = "Dummy Song";
        ExternalPlaylistDTO externalPlaylistDTO = new ExternalPlaylistDTO();
        externalPlaylistDTO.tracks = Arrays.asList(externalTrackDTO);

        spotifyValidator.validatePlaylist(externalPlaylistDTO);
    }

    @Test(expected = BusinessException.class)
    public void testPlaylistNullFail() throws BusinessException {
        spotifyValidator.validatePlaylist(null);
    }

    @Test(expected = BusinessException.class)
    public void testTracksNullFail() throws BusinessException {
        ExternalPlaylistDTO externalPlaylistDTO = new ExternalPlaylistDTO();
        externalPlaylistDTO.tracks = null;

        spotifyValidator.validatePlaylist(externalPlaylistDTO);
    }

    @Test(expected = BusinessException.class)
    public void testTracksEmptyFail() throws BusinessException {
        ExternalPlaylistDTO externalPlaylistDTO = new ExternalPlaylistDTO();
        externalPlaylistDTO.tracks = new ArrayList<>();

        spotifyValidator.validatePlaylist(externalPlaylistDTO);
    }

    @Test(expected = BusinessException.class)
    public void testTrackArtistNullFail() throws BusinessException {
        ExternalTrackDTO externalTrackDTO = new ExternalTrackDTO();
        externalTrackDTO.artist = null;
        externalTrackDTO.name = "Dummy Song";
        ExternalPlaylistDTO externalPlaylistDTO = new ExternalPlaylistDTO();
        externalPlaylistDTO.tracks = Arrays.asList(externalTrackDTO);

        spotifyValidator.validatePlaylist(externalPlaylistDTO);
    }

    @Test(expected = BusinessException.class)
    public void testTrackArtistEmptyFail() throws BusinessException {
        ExternalTrackDTO externalTrackDTO = new ExternalTrackDTO();
        externalTrackDTO.artist = "";
        externalTrackDTO.name = "Dummy Song";
        ExternalPlaylistDTO externalPlaylistDTO = new ExternalPlaylistDTO();
        externalPlaylistDTO.tracks = Arrays.asList(externalTrackDTO);

        spotifyValidator.validatePlaylist(externalPlaylistDTO);
    }

    @Test(expected = BusinessException.class)
    public void testTrackNameNullFail() throws BusinessException {
        ExternalTrackDTO externalTrackDTO = new ExternalTrackDTO();
        externalTrackDTO.artist = "Dummy Band";
        externalTrackDTO.name = null;
        ExternalPlaylistDTO externalPlaylistDTO = new ExternalPlaylistDTO();
        externalPlaylistDTO.tracks = Arrays.asList(externalTrackDTO);

        spotifyValidator.validatePlaylist(externalPlaylistDTO);
    }

    @Test(expected = BusinessException.class)
    public void testTrackNameEmptyFail() throws BusinessException {
        ExternalTrackDTO externalTrackDTO = new ExternalTrackDTO();
        externalTrackDTO.artist = "Dummy Band";
        externalTrackDTO.name = "";
        ExternalPlaylistDTO externalPlaylistDTO = new ExternalPlaylistDTO();
        externalPlaylistDTO.tracks = Arrays.asList(externalTrackDTO);

        spotifyValidator.validatePlaylist(externalPlaylistDTO);
    }




}
