package com.goodweather4party.api.validator;

import com.goodweather4party.api.dto.WeatherFilterDTO;
import com.goodweather4party.exception.BusinessException;
import com.goodweather4party.exception.ExceptionMessages;
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