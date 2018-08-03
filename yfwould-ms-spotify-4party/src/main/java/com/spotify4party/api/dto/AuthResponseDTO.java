package com.spotify4party.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthResponseDTO implements Serializable {

    public String accessToken;
    public String tokenType;
    public String expiresIn;
    public String scope;

}
