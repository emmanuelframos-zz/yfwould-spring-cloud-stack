package com.goodweather4party.integration.spotify.validator;

import com.goodweather4party.exception.BusinessException;
import com.goodweather4party.exception.ExceptionMessages;
import com.goodweather4party.integration.spotify.dto.ExternalPlaylistDTO;
import com.goodweather4party.integration.spotify.dto.ExternalTrackDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Objects;

@Component
public class SpotifyValidator {

    public void validatePlaylist(ExternalPlaylistDTO externalPlaylistDTO) throws BusinessException {
        if (Objects.isNull(externalPlaylistDTO))
            throw new BusinessException(ExceptionMessages.INVALID_PLAYLIST);

        if (CollectionUtils.isEmpty(externalPlaylistDTO.tracks))
            throw new BusinessException(ExceptionMessages.INVALID_TRACKS);

        for (ExternalTrackDTO track : externalPlaylistDTO.tracks){
            if (StringUtils.isEmpty(track.artist))
                throw new BusinessException(ExceptionMessages.INVALID_ARTIST);

            if (StringUtils.isEmpty(track.name))
                throw new BusinessException(ExceptionMessages.INVALID_TRACK_NAME);
        }
    }
}
