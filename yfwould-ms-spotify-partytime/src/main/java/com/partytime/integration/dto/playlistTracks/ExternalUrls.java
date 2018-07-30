
package com.partytime.integration.dto.playlistTracks;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExternalUrls implements Serializable {

    private final static long serialVersionUID = -547201467836960014L;

    @JsonProperty("spotify")
    public String spotify;

}
