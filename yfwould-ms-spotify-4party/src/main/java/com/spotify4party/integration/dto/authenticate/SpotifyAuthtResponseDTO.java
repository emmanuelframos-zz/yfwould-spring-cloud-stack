package com.spotify4party.integration.dto.authenticate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpotifyAuthtResponseDTO implements Serializable {

   @JsonProperty("access_token")
   public String accessToken;

   @JsonProperty("token_type")
   public String tokenType;

   @JsonProperty("expires_in")
   public String expiresIn;

   @JsonProperty("scope")
   public String scope;

}