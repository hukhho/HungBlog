//package com.hung.blog.hungblog;
//
//import com.google.common.cache.Cache;
//import com.hung.blog.hungblog.config.jwt.JwtTokenProvider;
//import com.hung.blog.hungblog.dto.AuthResponse;
//import com.hung.blog.hungblog.dto.ResponseObject;
//import com.hung.blog.hungblog.dto.SignInForm;
//import com.hung.blog.hungblog.service.AuthImpl;
//import com.hung.blog.hungblog.service.CustomUserDetailService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.time.LocalDateTime;
//import java.util.concurrent.atomic.AtomicInteger;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class AuthImplTest {
//
//    @Mock
//    private AuthenticationManager authenticationManager;
//
//    @Mock
//    private JwtTokenProvider jwtTokenProvider;
//
//    @Mock
//    private CustomUserDetailService customUserDetailService;
//
//
//
//    private AuthImpl authImpl;
//
//    @Before
//    public void setUp() {
//        authImpl = new AuthImpl();
//    }
//
//    @Test
//    public void testLogin_success() {
//        // Arrange
//        SignInForm signInForm = new SignInForm("hukhho@gmail.com", "1234");
//        String token = "test-token";
//        UserDetails user = Mockito.mock(UserDetails.class);
//        when(user.getUsername()).thenReturn(signInForm.getEmail());
//        when(customUserDetailService.loadUserByUsername(signInForm.getEmail())).thenReturn(user);
//        when(jwtTokenProvider.createToken(user.getUsername())).thenReturn(token);
//        when(authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(signInForm.getEmail(), signInForm.getPassword())
//        )).thenReturn(null);
//
//        // Act
//        ResponseEntity<ResponseObject> result = authImpl.login(signInForm);
//
//        // Assert
//        assertEquals(HttpStatus.OK, result.getStatusCode());
//        assertEquals("200 OK", result.getBody().getStatus());
//        assertEquals("Get token successfully", result.getBody().getMessage());
//        AuthResponse authResponse = (AuthResponse) result.getBody().getData();
//        assertEquals(token, authResponse.getToken());
//
//    }
//}
