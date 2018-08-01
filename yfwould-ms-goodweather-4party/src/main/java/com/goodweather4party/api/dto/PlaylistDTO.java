package com.goodweather4party.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlaylistDTO implements Serializable {

    public List<TrackDTO> tracks;

}