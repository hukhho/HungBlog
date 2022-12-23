//package com.hung.blog.hungblog.config;
//
//import com.google.common.cache.Cache;
//import com.google.common.cache.CacheBuilder;
//import com.google.common.util.concurrent.RateLimiter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.atomic.AtomicInteger;
//
//@Configuration
//public class GuavaGoogleConfig {
//    @Bean
//    public Cache<String, AtomicInteger> cache() {
//        return CacheBuilder.newBuilder()
//                .expireAfterWrite(30, TimeUnit.SECONDS)
//                .maximumSize(1000)
//                .build();
//    }
//    @Bean
//    public RateLimiter rateLimiter() {
//        return RateLimiter.create(5.0);
//    }
//
//}
