/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.hung.blog.hungblog.config.jwt;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {
    @Value("${jwt.secret.key}")
    private String secretKey;

    @Value("${jwt.expried.time}")
    private long validityInMilliseconds; // 1h

    public String createToken(String username) {
        log.info("jwt.secret.key {}", secretKey);
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) throws SignatureException, MalformedJwtException, UnsupportedJwtException, ExpiredJwtException, IllegalArgumentException{
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        }catch (SignatureException e){
            log.error("Invalid JWT signature: {}", e.getMessage());
        }catch (MalformedJwtException e2){
            log.error("Invalid JWT token format: {}", e2.getMessage());
        }catch (UnsupportedJwtException e3){
            log.error("Unsupported JWT: {}", e3.getMessage());
        }catch (ExpiredJwtException e4){
            log.error("Expired Jwt token: {}", e4.getMessage());

        }catch (IllegalArgumentException e5){
            log.error("Jwt claims string is empty: {}", e5.getMessage());
        }
        return false;
    }

    public void validateTokenThrowException(String token) throws Exception{
        Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
    }

}