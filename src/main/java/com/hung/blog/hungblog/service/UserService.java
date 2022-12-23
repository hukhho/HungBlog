package com.hung.blog.hungblog.service;

import com.hung.blog.hungblog.dto.UserDto;
import com.hung.blog.hungblog.entity.Users;

import java.util.List;

public interface UserService {
    public List<UserDto> getAllUserDto();

    List<Users> findAll();

    <S extends Users> void save(S entity);

    Users findById(Integer integer);
    Users findByIdCache(Integer integer);

    void deleteById(Integer integer);
}
