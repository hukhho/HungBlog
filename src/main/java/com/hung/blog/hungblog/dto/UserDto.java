package com.hung.blog.hungblog.dto;

import lombok.Data;

@Data
public class UserDto {
    private int id;
    private String username;
    private String fullName;
    private String email;
    private String role;
}
