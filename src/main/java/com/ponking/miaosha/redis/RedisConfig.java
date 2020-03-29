package com.ponking.miaosha.redis;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Ponking
 * @ClassName RedisConfig
 * @date 2020/3/28--13:14
 **/
@Data
@Component
public class RedisConfig {
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private int port;
    @Value("${redis.timeout}")
    private int timeout;
    @Value("${redis.password}")
    private String password;
    @Value("${redis.poolMaxTotal}")
    private int poolMaxTotal;
    @Value("${redis.poolMaxIdle}")
    private int poolMaxIdle;
    @Value("${redis.poolMaxWait}")
    private int poolMaxWait;
}
