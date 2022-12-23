package com.hung.blog.hungblog.dto;

import lombok.Data;

@Data
public class ErrorResponse {

    private String message;
    public int status;

}