package com.goodweatherpartytime.api.parser;

import com.goodweatherpartytime.api.dto.PlaylistDTO;
import com.goodweatherpartytime.api.dto.TrackDTO;
import com.goodweatherpartytime.integration.partytime.dto.ExternalPlaylistDTO;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PlaylistParser {

    public PlaylistDTO toDomain(ExternalPlaylistDTO externalPlaylistDTO) {
        PlaylistDTO playlistDTO = new PlaylistDTO();

        playlistDTO.tracks = externalPlaylistDTO.tracks
                .stream()
                .map(t -> {
                    TrackDTO trackDTO = new TrackDTO();
                    trackDTO.artist = t.artist;
                    trackDTO.name = t.name;
                    trackDTO.url = t.url;
                    return trackDTO;
                })
                .collect(Collectors.toList());

        return playlistDTO;
    }
}