package com.hung.blog.hungblog.controller;
import com.hung.blog.hungblog.config.jwt.JwtTokenProvider;
import com.hung.blog.hungblog.dto.SignInForm;
import com.hung.blog.hungblog.dto.UserDto;
import com.hung.blog.hungblog.entity.Users;
import com.hung.blog.hungblog.repository.RoleRepo;
import com.hung.blog.hungblog.repository.UserRepository;
import com.hung.blog.hungblog.service.CustomUserDetailService;
import com.hung.blog.hungblog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private CustomUserDetailService customUserDetailService;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepo roleRepo;

    //http://localhost:8080//api/v1/User/getAll
    @GetMapping("/getAll")
    public List<Users> getAll() {
       return userService.findAll();
    }

    @GetMapping("/Test")
    public List<UserDto> test() {
        return userService.getAllUserDto();
    }
    @GetMapping("/getAllv2")
    public List<Users> getAll1() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> find(@PathVariable int id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/cache/{id}")
    public ResponseEntity<?> findCache(@PathVariable int id) {

        return ResponseEntity.ok(userService.findByIdCache(id));

    }

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        // do something with the principal object
        return ResponseEntity.ok(principal);
    }

    @GetMapping("/hello")
    public ResponseEntity<?> hom1e() throws Exception {
        return ResponseEntity.ok("hello");
    }

    @GetMapping("/admin")
    public String hello() {
        return "Hello admin!";
    }

    @GetMapping("/user")
    public String helloEveryone() {
        return "Hello user!";
    }




}
