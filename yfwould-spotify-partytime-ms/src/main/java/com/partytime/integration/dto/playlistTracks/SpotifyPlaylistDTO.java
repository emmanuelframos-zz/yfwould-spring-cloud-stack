
package com.partytime.integration.dto.playlistTracks;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpotifyPlaylistDTO implements Serializable {

    private final static long serialVersionUID = 3593160139066417931L;

    @JsonProperty("items")
    public List<Item> items;

}
