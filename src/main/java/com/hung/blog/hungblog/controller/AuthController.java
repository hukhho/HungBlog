package com.hung.blog.hungblog.controller;

import com.google.common.cache.Cache;
import com.google.common.util.concurrent.RateLimiter;
import com.hung.blog.hungblog.config.jwt.JwtTokenProvider;
import com.hung.blog.hungblog.dto.AuthResponse;
import com.hung.blog.hungblog.dto.ResponseObject;
import com.hung.blog.hungblog.dto.SignInForm;
import com.hung.blog.hungblog.service.AuthService;
import com.hung.blog.hungblog.service.CustomUserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/v1/auth")
@Slf4j
public class AuthController {


    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> token(@RequestBody SignInForm signInForm) {
        return authService.login(signInForm);
    }

    @RequestMapping("/rate/{id}")
    public String rateLimited(@PathVariable Integer id) {
        return "Success";
    }
}
