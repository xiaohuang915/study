package com.huang.study.security.filter;


import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Auther: pc.huang
 * @Date: 2018/10/15 16:52
 * @Description:
 */
public class JWTAuthenticationFilter extends BasicAuthenticationFilter{
    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");
        if (null==header||!header.startsWith("Bearer ")){
            chain.doFilter(request,response);
            return;
        }
        UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(header);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request,response);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(String header) {
      String user = Jwts.parser().setSigningKey("SecretBootTest").parseClaimsJws(header.replace("Bearer ","")).getBody().getSubject();
      if (user!=null){
          return new UsernamePasswordAuthenticationToken(user,null,new ArrayList<>());
      }
      return null;
    }
}
