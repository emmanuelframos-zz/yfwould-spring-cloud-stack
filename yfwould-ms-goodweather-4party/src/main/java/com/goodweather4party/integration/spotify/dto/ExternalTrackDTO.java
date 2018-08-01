package com.goodweather4party.integration.spotify.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExternalTrackDTO implements Serializable {

    public String artist;
    public String name;
    public String url;

}
