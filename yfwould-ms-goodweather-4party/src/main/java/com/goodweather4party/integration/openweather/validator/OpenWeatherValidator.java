package com.goodweather4party.integration.openweather.validator;

import com.goodweather4party.exception.BusinessException;
import com.goodweather4party.exception.ExceptionMessages;
import com.goodweather4party.integration.openweather.dto.ExternalWeatherDTO;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class OpenWeatherValidator {

    public void validate(ExternalWeatherDTO externalWeatherDTO) throws BusinessException {
        if (Objects.isNull(externalWeatherDTO) || Objects.isNull(externalWeatherDTO.temperature)){
            throw new BusinessException(ExceptionMessages.INVALID_WEATHER);
        }
    }
}