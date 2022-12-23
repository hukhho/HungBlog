package com.hung.blog.hungblog.service;

import com.google.common.cache.Cache;
import com.hung.blog.hungblog.config.jwt.JwtTokenProvider;
import com.hung.blog.hungblog.dto.AuthResponse;
import com.hung.blog.hungblog.dto.ResponseObject;
import com.hung.blog.hungblog.dto.SignInForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class AuthImpl implements AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private CustomUserDetailService customUserDetailService;
    @Autowired
    private Cache<String, AtomicInteger> authCache;

    private final int RATE_LIMIT = 10; // MAX 10 requests per identification DURATION 30 SECOND

    @Override
    public ResponseEntity<ResponseObject> login(SignInForm signInForm) {
        //CHECK RATE_LIMIT
        String key = String.valueOf(signInForm.getEmail());
        AtomicInteger counter = authCache.getIfPresent(key);
        if (counter == null) {
            counter = new AtomicInteger();
            authCache.put(key, counter);
        }
        int requests = counter.incrementAndGet();
        if (requests > RATE_LIMIT) {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(new ResponseObject("429 TOO_MANY_REQUESTS", "Error: rate limit exceeded", null));
        }

        //AUTHENTICATION
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(signInForm.getEmail(), signInForm.getPassword())
            );
            final UserDetails user = customUserDetailService.loadUserByUsername(signInForm.getEmail());
            String token = jwtTokenProvider.createToken(user.getUsername());
            AuthResponse authResponse = new AuthResponse(token, LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("200 OK", "Get token successfully", authResponse));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseObject("401 UNAUTHORIZED", e.getMessage(), null));
        }
    }
}
