package com.spotify4party.api.validator;

import com.spotify4party.exception.BusinessException;
import com.spotify4party.exception.ExceptionMessages;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class PlaylistSearchValidator {

    public void validatePlaylistId(String playlistId) throws BusinessException {
        if (StringUtils.isEmpty(playlistId))
            throw new BusinessException(ExceptionMessages.INVALID_PLAYLIST_ID);
    }
}