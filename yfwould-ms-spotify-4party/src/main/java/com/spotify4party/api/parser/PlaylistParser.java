package com.spotify4party.api.parser;

import com.spotify4party.api.dto.PlaylistDTO;
import com.spotify4party.api.dto.TrackDTO;
import com.spotify4party.integration.dto.playlistTracks.SpotifyPlaylistDTO;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PlaylistParser {

    public PlaylistDTO toDomain(SpotifyPlaylistDTO spotifyPlaylistDTO){
        PlaylistDTO playlistDTO = new PlaylistDTO();

        playlistDTO.tracks = spotifyPlaylistDTO.items
                .stream()
                .map(item -> {
                    TrackDTO trackDTO = new TrackDTO();
                    trackDTO.name = item.track.name;
                    trackDTO.url = item.track.externalUrls.spotify;
                    trackDTO.artist = item.track.artists
                            .stream()
                            .findFirst()
                            .get()
                            .name;
                    return trackDTO;
                })
                .collect(Collectors.toList());

        return playlistDTO;
    }
}