package com.huang.study.security.filter;

import com.alibaba.fastjson.JSON;
import com.huang.study.security.dto.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * @Auther: pc.huang
 * @Date: 2018/10/15 16:30
 * @Description:
 */
public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public JWTLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        User user = null;
        try {
            user = JSON.parseObject(request.getInputStream(), User.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword(), new ArrayList<>()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String token = Jwts.builder().setSubject(authResult.getName()).setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000)).signWith(SignatureAlgorithm.ES512, "SecretBootTest").compact();
        response.addHeader("Authorization", "Bearer " + token);
    }
}
