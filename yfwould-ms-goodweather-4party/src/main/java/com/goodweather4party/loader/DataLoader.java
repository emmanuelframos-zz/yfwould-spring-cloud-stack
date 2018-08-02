package com.goodweather4party.loader;

import com.goodweather4party.domain.TrackStyles;
import com.goodweather4party.integration.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RedisService redisService;

    @Override
    public void run(String... args) throws Exception {
        redisService.put(TrackStyles.ROCK.name(), "5hSEnhVI5wA7d2rSpHl32v");
        redisService.put(TrackStyles.POP.name(), "0Q8xDw7ChfWZMYEDs1Trul");
        redisService.put(TrackStyles.CLASSICAL.name(), "75xCstiSIcVdmbsxLoC92t");
        redisService.put(TrackStyles.SUGGEST.name(), "6qPntjhYnXwEo899ydrMZl");
    }
}