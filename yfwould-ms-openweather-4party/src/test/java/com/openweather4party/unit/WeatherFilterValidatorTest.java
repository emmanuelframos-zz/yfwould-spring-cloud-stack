package com.openweather4party.unit;

import com.openweather4party.api.dto.WeatherFilterDTO;
import com.openweather4party.api.validator.WeatherFilterValidator;
import com.openweather4party.exception.BusinessException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class WeatherFilterValidatorTest {

    @Spy
    private WeatherFilterValidator weatherFilterValidator;

    @Test
    public void testCityNameOK() throws BusinessException {
        WeatherFilterDTO weatherFilterDTO = new WeatherFilterDTO();
        weatherFilterDTO.cityName = "Curitiba";
        weatherFilterValidator.validate(weatherFilterDTO);
    }

    @Test
    public void testLatLongOK() throws BusinessException {
        WeatherFilterDTO weatherFilterDTO = new WeatherFilterDTO();
        weatherFilterDTO.latitude = 40;
        weatherFilterDTO.longitude = 40;
        weatherFilterValidator.validate(weatherFilterDTO);
    }

    @Test(expected = BusinessException.class)
    public void testNoParamsFail() throws BusinessException {
        WeatherFilterDTO weatherFilterDTO = new WeatherFilterDTO();
        weatherFilterValidator.validate(weatherFilterDTO);
    }

    @Test(expected = BusinessException.class)
    public void testAllParamsFail() throws BusinessException {
        WeatherFilterDTO weatherFilterDTO = new WeatherFilterDTO();
        weatherFilterDTO.latitude = 40;
        weatherFilterDTO.longitude = 40;
        weatherFilterDTO.cityName = "Curitiba";
        weatherFilterValidator.validate(weatherFilterDTO);
    }

    @Test(expected = BusinessException.class)
    public void testCityNameAndLatFail() throws BusinessException {
        WeatherFilterDTO weatherFilterDTO = new WeatherFilterDTO();
        weatherFilterDTO.latitude = 40;
        weatherFilterDTO.cityName = "Curitiba";
        weatherFilterValidator.validate(weatherFilterDTO);
    }

    @Test(expected = BusinessException.class)
    public void testCityNameAndLongFail() throws BusinessException {
        WeatherFilterDTO weatherFilterDTO = new WeatherFilterDTO();
        weatherFilterDTO.longitude = 40;
        weatherFilterDTO.cityName = "Curitiba";
        weatherFilterValidator.validate(weatherFilterDTO);
    }

    @Test(expected = BusinessException.class)
    public void testLatitudeNoLongitudeFail() throws BusinessException {
        WeatherFilterDTO weatherFilterDTO = new WeatherFilterDTO();
        weatherFilterDTO.latitude = 40;
        weatherFilterDTO.cityName = "Curitiba";
        weatherFilterValidator.validate(weatherFilterDTO);
    }

    @Test(expected = BusinessException.class)
    public void testLongitudeNoLatitudeFail() throws BusinessException {
        WeatherFilterDTO weatherFilterDTO = new WeatherFilterDTO();
        weatherFilterDTO.longitude = 40;
        weatherFilterDTO.cityName = "Curitiba";
        weatherFilterValidator.validate(weatherFilterDTO);

    }
}