package com.spotify4party.integration;

import com.spotify4party.Application;
import com.spotify4party.api.Spotify4PartyAPI;
import com.spotify4party.api.dto.AuthResponseDTO;
import com.spotify4party.api.dto.PlaylistDTO;
import com.spotify4party.exception.BusinessException;
import com.spotify4party.service.Spotify4PartyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class Spotify4PartyAPITest {

    @Autowired
    private Spotify4PartyAPI spotify4PartyAPI;

    @Autowired
    private Spotify4PartyService spotify4PartyService;

    @Test
    public void testAuthenticateOk() throws BusinessException {

        AuthResponseDTO authResponseDTO = spotify4PartyAPI.authenticate();

        assertThat(authResponseDTO.accessToken, is(notNullValue()));

        assertThat(authResponseDTO.accessToken, not(isEmptyString()));

    }

    @Test
    public void testPlaylistOk() throws BusinessException {

        PlaylistDTO playlistDTO = spotify4PartyService.findPlaylistById("5hSEnhVI5wA7d2rSpHl32v");

        assertThat(playlistDTO, is(notNullValue()));

    }
}