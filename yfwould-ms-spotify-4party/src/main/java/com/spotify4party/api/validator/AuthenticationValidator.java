package com.spotify4party.api.validator;

import com.spotify4party.api.dto.AuthResponseDTO;
import com.spotify4party.exception.BusinessException;
import com.spotify4party.exception.ExceptionMessages;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationValidator {

    public void validateAuthentication(AuthResponseDTO authResponseDTO) throws BusinessException {
        if (StringUtils.isEmpty(authResponseDTO.accessToken))
            throw new BusinessException(ExceptionMessages.ACCESS_TOKEN_EMPTY);
    }
}