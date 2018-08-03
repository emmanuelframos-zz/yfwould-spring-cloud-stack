package com.openweather4party.api.validator;

import com.openweather4party.api.dto.WeatherFilterDTO;
import com.openweather4party.exception.BusinessException;
import com.openweather4party.exception.ExceptionMessages;
import org.springframework.stereotype.Component;

@Component
public class WeatherFilterValidator {

    public void validate(WeatherFilterDTO filter) throws BusinessException {

        if (filter.hasNoParams())
            throw new BusinessException(ExceptionMessages.INVALID_PARAMS);

        if (filter.hasCityName() && filter.hasLatitudeAndLogitude())
            throw new BusinessException(ExceptionMessages.INVALID_PARAMS);

        if (filter.hasCityName() && (filter.hasLongitude() || filter.hasLatitude()))
            throw new BusinessException(ExceptionMessages.ONLY_CITY_NAME);

        if (filter.hasLatitude() && !filter.hasLongitude())
            throw new BusinessException(ExceptionMessages.MISS_LONGITUDE);

        if (filter.hasLongitude() && !filter.hasLatitude())
            throw new BusinessException(ExceptionMessages.MISS_LATITUDE);
    }
}