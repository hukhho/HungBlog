    package com.hung.blog.hungblog.dto;

    import com.hung.blog.hungblog.entity.Users;
    import lombok.Builder;
    import lombok.Data;
    import lombok.Getter;
    import lombok.Setter;
    import org.springframework.security.core.GrantedAuthority;
    import org.springframework.security.core.authority.SimpleGrantedAuthority;
    import org.springframework.security.core.userdetails.UserDetails;

    import java.util.ArrayList;
    import java.util.Collection;
    import java.util.List;
    import java.util.UUID;
    import java.util.stream.Collectors;

    public class UserPrincipal implements UserDetails {
        private int id;
        private String username;
        private String password;
        private String fullName;
        private String email;
        private Collection<? extends GrantedAuthority> authorities;

        public UserPrincipal(int id, String username, String password, String fullName, String email, Collection<? extends GrantedAuthority> authorities) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.fullName = fullName;
            this.email = email;
            this.authorities = authorities;
        }

        public UserPrincipal() {

        }

        public static UserPrincipal create(Users user) {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
            return new UserPrincipal(user.getId(), user.getUsername(), user.getPassword(), user.getFullName(), user.getEmail(), authorities);
        }

        public int getId() {
            return id;
        }

        public String getFullName() {
            return fullName;
        }

        public String getEmail() {
            return email;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorities;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return username;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
