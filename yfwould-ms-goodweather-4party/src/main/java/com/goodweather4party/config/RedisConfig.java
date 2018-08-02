package com.goodweather4party.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

@Configuration
public class RedisConfig {

    @Value("${redis.host}")
    private String redisHost;

    @Value("${redis.port}")
    private Integer redisPort;

    @Value("${redis.password}")
    private String redisPassword;

    @Value("${redis.timeout}")
    private Integer timeout;

    @Value("${redis.maxTotal}")
    private Integer maxTotal;

    @Value("${redis.maxIdle}")
    private Integer maxIdle;

    @Value("${redis.minIdle}")
    private Integer minIdle;

    @Value("${redis.minEvictable}")
    private Integer minEvictable;

    @Value("${redis.timeBetween}")
    private Integer timeBetween;

    @Value("${redis.numTests}")
    private Integer numTests;

    @Value("${redis.playlistKey}")
    private String playlistKey;

    private JedisPoolConfig buildPoolConfig() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);
        poolConfig.setMinEvictableIdleTimeMillis(Duration.ofSeconds(minEvictable).toMillis());
        poolConfig.setTimeBetweenEvictionRunsMillis(Duration.ofSeconds(timeBetween).toMillis());
        poolConfig.setNumTestsPerEvictionRun(numTests);
        poolConfig.setBlockWhenExhausted(true);
        return poolConfig;
    }

    @Bean
    public JedisPool jedisPool() {
        return new JedisPool(buildPoolConfig(), redisHost, redisPort, timeout, StringUtils.isEmpty(redisPassword) ? null : redisPassword);
    }

    public String getPlaylistKey() {
        return playlistKey;
    }
}