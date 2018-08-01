package com.partytime.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PlaylistDTO implements Serializable {

    public List<TrackDTO> tracks;

}