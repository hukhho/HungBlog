//package com.hung.blog.hungblog.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.redisson.Redisson;
//import org.redisson.api.RBucket;
//import org.redisson.api.RLock;
//import org.redisson.api.RedissonClient;
//import org.redisson.client.RedisConnectionException;
//import org.redisson.config.Config;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.concurrent.TimeUnit;
//
//@Configuration
//@Slf4j
//public class RedisConfig {
//
//    @Bean
//    public RedissonClient redissonClient() {
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://localhost:6379");
//        return Redisson.create(config);
//    }
//
////    @Autowired
////    private RedissonClient redisson;
//
//    //@Value("${rate.limit.max}")
//    private int maxRequests = 5;
//
//    //@Value("${rate.limit.duration}")
//    private int duration = 30;
//
//    public boolean checkRateLimit(String key) {
//        try {
//            RBucket<Integer> bucket = redissonClient().getBucket(key);
//            if (bucket.isExists()) {
//                int count = bucket.get().intValue();
//                if (count < maxRequests) {
//                    bucket.set(count + 1, duration, TimeUnit.SECONDS);
//                    return true;
//                } else {
//                    return false;
//                }
//            } else {
//                bucket.set(1, duration, TimeUnit.SECONDS);
//                return true;
//            }
//
//        } catch (RedisConnectionException e) {
//            log.error("RedisConnectionException " + e);
//            return false;
//        }
//    }
//}
