package com.goodweather4party.builder;

import com.goodweather4party.api.dto.PlaylistDTO;
import com.goodweather4party.api.dto.TrackDTO;

import java.util.stream.Collectors;
import java.util.stream.Stream;


public final class PlaylistBuilder {

    private PlaylistBuilder(){}

    public static PlaylistDTO buildPlaylist(){

        /** Tracks **/
        TrackDTO trackOne = getTrack("Backstreet Boys", "Everybody (Backstreet's Back) - Extended Version");
        TrackDTO trackTwo = getTrack("Backstreet Boys", "Shape of My Heart");
        TrackDTO trackThree = getTrack("*NSYNC", "Bye Bye Bye");
        TrackDTO trackFour = getTrack("*NSYNC", "This I Promise You");
        TrackDTO trackFive = getTrack("Five", "Keep On Movin'");
        TrackDTO trackSix = getTrack("Five", "Everybody Get Up - Radio Edit");

        PlaylistDTO playlistDTO = new PlaylistDTO();
        playlistDTO.tracks = Stream.of(trackOne, trackTwo, trackThree, trackFour, trackFive, trackSix).collect(Collectors.toList());

        return playlistDTO;
    }

    private static TrackDTO getTrack(String artist, String name){
        TrackDTO track = new TrackDTO();
        track.artist = artist;
        track.name = name;
        return track;
    }
}