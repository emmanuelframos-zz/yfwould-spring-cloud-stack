package com.goodweather4party.service;

import com.goodweather4party.domain.TrackStyles;
import org.springframework.stereotype.Service;

@Service
public class TrackStyleSelector {

    public TrackStyles selectPlaylist(Integer temperature) {
        if (temperature > 30){
            return TrackStyles.SUGGEST;
        }else if (temperature >= 15 && temperature <= 30){
            return TrackStyles.POP;
        }else if (temperature >= 10 && temperature < 15){
            return TrackStyles.ROCK;
        }
        return TrackStyles.CLASSICAL;
    }
}