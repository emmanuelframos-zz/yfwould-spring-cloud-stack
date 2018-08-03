
package com.spotify4party.integration.dto.playlistTracks;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item implements Serializable {

    private final static long serialVersionUID = 2588920502050926268L;

    @JsonProperty("track")
    public Track track;

}
