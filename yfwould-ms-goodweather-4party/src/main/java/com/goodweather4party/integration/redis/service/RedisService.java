package com.goodweather4party.integration.redis.service;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {

    private JedisPool jedisPool;

    public RedisService(JedisPool jedisPool){
        this.jedisPool = jedisPool;
    }

    public String get(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            if (!jedis.isConnected()) {
                jedis.connect();
            }
            return jedis.get(key);
        }
    }

    public void put(String key, String value) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set(key, value);
        }
    }
}
