package com.goodweather4party.integration.partytime.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExternalPlaylistDTO implements Serializable {

    public List<ExternalTrackDTO> tracks;

}