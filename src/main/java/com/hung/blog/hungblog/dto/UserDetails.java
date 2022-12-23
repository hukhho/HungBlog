package com.hung.blog.hungblog.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface UserDetails extends org.springframework.security.core.userdetails.UserDetails {

    @Override
    Collection<? extends GrantedAuthority> getAuthorities();

    @Override
    String getPassword();

    @Override
    String getUsername();

    @Override
    boolean isAccountNonExpired();

    @Override
    boolean isAccountNonLocked();

    @Override
    boolean isCredentialsNonExpired();

    @Override
    boolean isEnabled();
}
