
package com.spotify4party.integration.dto.playlistTracks;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Artist implements Serializable {

    private final static long serialVersionUID = 1472719221813710345L;

    @JsonProperty("name")
    public String name;

}
