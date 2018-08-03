package com.spotify4party.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrackDTO implements Serializable {

    public String artist;
    public String name;
    public String url;

}