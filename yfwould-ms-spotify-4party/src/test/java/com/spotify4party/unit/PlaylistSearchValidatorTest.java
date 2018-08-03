package com.spotify4party.unit;


import com.spotify4party.api.validator.PlaylistSearchValidator;
import com.spotify4party.exception.BusinessException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class PlaylistSearchValidatorTest {

    @Spy
    private PlaylistSearchValidator playlistSearchValidator;

    @Test
    public void validatePlaylistIdOK() throws BusinessException {
        playlistSearchValidator.validatePlaylistId("id");
    }

    @Test(expected = BusinessException.class)
    public void validatePlaylistIdFail() throws BusinessException {
        playlistSearchValidator.validatePlaylistId("");
    }

}
