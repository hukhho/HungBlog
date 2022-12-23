package com.hung.blog.hungblog.config.jwt;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class JWTExceptionHandler extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public JWTExceptionHandler(String token, String message) {
        super(String.format("Failed for [%s]: %s", token, message));
    }
}
