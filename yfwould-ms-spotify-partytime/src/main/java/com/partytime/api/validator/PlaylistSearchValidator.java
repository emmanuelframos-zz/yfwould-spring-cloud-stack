package com.partytime.api.validator;

import com.partytime.exception.BusinessException;
import com.partytime.exception.ExceptionMessages;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class PlaylistSearchValidator {

    public void validatePlaylistId(String playlistId) throws BusinessException {
        if (StringUtils.isEmpty(playlistId))
            throw new BusinessException(ExceptionMessages.INVALID_PLAYLIST_ID);
    }
}