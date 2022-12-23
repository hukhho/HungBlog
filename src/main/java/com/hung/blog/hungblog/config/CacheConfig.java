package com.hung.blog.hungblog.config;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
@EnableCaching
@Slf4j
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("users");
    }

    @Bean
    public Cache<String, AtomicInteger> authCache() {
        return CacheBuilder.newBuilder()
                    .expireAfterWrite(30, TimeUnit.SECONDS)
                    .maximumSize(1000)
                    .build();
    }


    @Scheduled(fixedRate = 600_000) //10 mins clear cache once
    @CacheEvict(cacheNames = {"users"}, allEntries = true)
    public void cacheEvict() {
        log.info("Cache clear");
        cacheManager().getCacheNames().parallelStream().forEach(name -> Objects.requireNonNull(cacheManager().getCache(name)).clear());
    }


}