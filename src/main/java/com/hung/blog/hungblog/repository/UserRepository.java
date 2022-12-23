package com.hung.blog.hungblog.repository;

import com.hung.blog.hungblog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByEmail(String email);
    Users findByUsername(String username);
    Users findByUsernameOrEmail(String username, String email);
}

