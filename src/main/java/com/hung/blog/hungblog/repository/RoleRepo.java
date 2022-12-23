package com.hung.blog.hungblog.repository;

import com.hung.blog.hungblog.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
