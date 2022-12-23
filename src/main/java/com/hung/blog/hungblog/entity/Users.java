package com.hung.blog.hungblog.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "username", nullable = true, length = 255)
    private String username;
    @Basic
    @Column(name = "password", nullable = true, length = 255)
    private String password;
    @Basic
    @Column(name = "full_name", nullable = true, length = 255)
    private String fullName;
    @Basic
    @Column(name = "email", nullable = true, length = 255)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();
    @OneToMany(mappedBy = "usersByAuthorId")
    private Collection<Articles> articlesById;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<Comments> commentsById;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<Likes> likesById;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<OauthAccessTokens> oauthAccessTokensById;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<OauthClients> oauthClientsById;
    @OneToMany(mappedBy = "usersByUserId")
    private Collection<RefreshTokens> refreshTokensById;


}
