package com.spotify4party.integration.builder;

import com.spotify4party.integration.dto.playlistTracks.Artist;
import com.spotify4party.integration.dto.playlistTracks.ExternalUrls;
import com.spotify4party.integration.dto.playlistTracks.Item;
import com.spotify4party.integration.dto.playlistTracks.SpotifyPlaylistDTO;
import com.spotify4party.integration.dto.playlistTracks.Track;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** It's not my fault **/
public final class DefaultPlaylistBuilder {

    private DefaultPlaylistBuilder(){}

    public static SpotifyPlaylistDTO buildPlaylist(){

        /** Artists **/
        Artist ironMaiden = getArtist("Iron Maiden");
        Artist metallica = getArtist("Metallica");
        Artist megadeth = getArtist("Megadeth");

        /** Tracks **/
        Track trackOne = getTrack(ironMaiden, "The Trooper - 1998 Remastered Version");
        trackOne.externalUrls = getExternalUrls("https://open.spotify.com/track/2pxAohyJptQWTQ5ZRWYijN");

        Track trackTwo = getTrack(ironMaiden, "Fear Of The Dark - 1998 Remastered Version");
        trackTwo.externalUrls = getExternalUrls("https://open.spotify.com/track/0P4JuEXYJmu2Q7BTtQW5nR");

        Track trackThree = getTrack(metallica, "Enter Sandman");
        trackThree.externalUrls = getExternalUrls("https://open.spotify.com/track/5sICkBXVmaCQk5aISGR3x1");

        Track trackFour = getTrack(metallica, "Master Of Puppets");
        trackFour.externalUrls = getExternalUrls("https://open.spotify.com/track/2MuWTIM3b0YEAskbeeFE1i");

        Track trackFive = getTrack(megadeth, "Symphony Of Destruction - 2004 Digital Remaster");
        trackFive.externalUrls = getExternalUrls("https://open.spotify.com/track/51TG9W3y9qyO8BY5RXKgnZ");

        Track trackSix = getTrack(megadeth, "Tornado Of Souls - 2004 Digital Remaster");
        trackSix.externalUrls = getExternalUrls("https://open.spotify.com/track/4E5xVW505akJX0wcKj8Mpd");

        /** Items **/
        Item itemOne = new Item();
        itemOne.track = trackOne;

        Item itemTwo = new Item();
        itemTwo.track = trackTwo;

        Item itemThree = new Item();
        itemThree.track = trackThree;

        Item itemFour = new Item();
        itemFour.track = trackFour;

        Item itemFive = new Item();
        itemFive.track = trackFive;

        Item itemSix = new Item();
        itemSix.track = trackSix;

        /** Playlist **/
        SpotifyPlaylistDTO spotifyPlaylistDTO = new SpotifyPlaylistDTO();
        spotifyPlaylistDTO.items = Stream
                .of(itemOne, itemTwo, itemThree, itemFour, itemFive, itemSix)
                .collect(Collectors.toList());

        return spotifyPlaylistDTO;
    }

    private static Artist getArtist(String name){
        Artist artist = new Artist();
        artist.name = name;
        return artist;
    }

    private static Track getTrack(Artist artist, String name){
        Track track = new Track();
        track.artists = Arrays.asList(artist);
        track.name = name;
        return track;
    }

    private static ExternalUrls getExternalUrls(String url){
        ExternalUrls trooperExternalUrls = new ExternalUrls();
        trooperExternalUrls.spotify = url;
        return trooperExternalUrls;
    }
}