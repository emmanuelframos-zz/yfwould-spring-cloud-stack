package com.goodweather4party.unit;

import com.goodweather4party.exception.BusinessException;
import com.goodweather4party.integration.openweather.dto.ExternalWeatherDTO;
import com.goodweather4party.integration.openweather.validator.OpenWeatherValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class OpenWeatherValidatorTest {

    @Spy
    private OpenWeatherValidator openWeatherValidator;

    @Test
    public void testValidationOK() throws BusinessException {
        ExternalWeatherDTO externalWeatherDTO = new ExternalWeatherDTO();
        externalWeatherDTO.temperature = 10;
        openWeatherValidator.validate(externalWeatherDTO);
    }

    @Test(expected = BusinessException.class)
    public void testValidationNullFail() throws BusinessException {
        openWeatherValidator.validate(null);
    }

    @Test(expected = BusinessException.class)
    public void testValidationTemperatureFail() throws BusinessException {
        openWeatherValidator.validate(new ExternalWeatherDTO());
    }


}
