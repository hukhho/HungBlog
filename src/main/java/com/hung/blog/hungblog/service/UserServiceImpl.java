package com.hung.blog.hungblog.service;

import com.hung.blog.hungblog.dto.UserDto;
import com.hung.blog.hungblog.entity.Users;
import com.hung.blog.hungblog.exception.GlobalExceptionHandler;
import com.hung.blog.hungblog.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository theUserRepository, ModelMapper mapper) {
        userRepository = theUserRepository;
        this.mapper = mapper;
    }

    @Override
    public List<UserDto> getAllUserDto() {
        List<Users> users = userRepository.findAll();
        List<UserDto> userDTOs = new ArrayList<>();
        for (Users user : users) {
            UserDto userDto = new UserDto();
            mapper.map(user, userDto);
            userDTOs.add(userDto);
        }
        return userDTOs;
    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public <S extends Users> void save(S entity) {
        userRepository.save(entity);
    }

    @Override
    public Users findById(Integer integer) {
        return userRepository.findById(integer)
                .orElseThrow(() -> new GlobalExceptionHandler.UserNotFoundException("Cannot found user with id " + integer));
    }

    @Override
    @Cacheable(value="users")
    public Users findByIdCache(Integer integer) {
        return userRepository.findById(integer)
                .orElseThrow(() -> new GlobalExceptionHandler.UserNotFoundException("Cannot found user with id " + integer));
    }

    @Override
    public void deleteById(Integer integer) {
        userRepository.deleteById(integer);
    }
}
