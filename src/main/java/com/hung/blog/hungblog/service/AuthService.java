package com.hung.blog.hungblog.service;

import com.hung.blog.hungblog.dto.ResponseObject;
import com.hung.blog.hungblog.dto.SignInForm;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<ResponseObject> login(SignInForm signInForm);
}
