package com.spotify4party.unit;

import com.spotify4party.api.dto.AuthResponseDTO;
import com.spotify4party.api.validator.AuthenticationValidator;
import com.spotify4party.exception.BusinessException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class AuthenticationValidatorTest {

    @Spy
    private AuthenticationValidator authenticationValidator;

    @Test
    public void validateAuthenticationOK() throws BusinessException {
        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        authResponseDTO.accessToken = "accessToken";
        authenticationValidator.validateAuthentication(authResponseDTO);
    }

    @Test(expected = BusinessException.class)
    public void validateAuthenticationFail() throws BusinessException {
        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        authResponseDTO.accessToken = "";
        authenticationValidator.validateAuthentication(authResponseDTO);
    }
}
