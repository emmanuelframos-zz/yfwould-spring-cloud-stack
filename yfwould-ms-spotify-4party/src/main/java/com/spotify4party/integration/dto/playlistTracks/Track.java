
package com.partytime.integration.dto.playlistTracks;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Track implements Serializable {

    private final static long serialVersionUID = -1544634469518673535L;

    @JsonProperty("artists")
    public List<Artist> artists;

    @JsonProperty("name")
    public String name;

    @JsonProperty("external_urls")
    public ExternalUrls externalUrls;

}
