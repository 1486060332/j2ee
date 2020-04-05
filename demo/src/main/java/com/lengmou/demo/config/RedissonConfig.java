package com.lengmou.demo.config;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 分布式锁工具 redisson
 * @Author 冷眸
 */
@Configuration
public class RedissonConfig {
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private Integer port;
    @Value("${spring.redis.database}")
    private Integer database;
    @Value("${spring.redis.password}")
    private String password;
    @Bean
    public Redisson redisson(){
        StringBuffer buffer = new StringBuffer("redis://");
        buffer.append(host).append(":").append(port);
        Config config = new Config();
        config.useSingleServer().setAddress(buffer.toString()).setDatabase(database).setPassword(password);
        return (Redisson) Redisson.create(config);
    }
}
