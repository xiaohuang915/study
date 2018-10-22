package com.huang.study.security.service.impl;

import com.huang.study.security.dao.UserRepository;
import com.huang.study.security.dto.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @Auther: pc.huang
 * @Date: 2018/10/18 10:47
 * @Description:
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SysUser sysUser = userRepository.findByUserName(userName);

        return new User(sysUser.getUserName(), sysUser.getPassword(),Collections.emptyList());
    }
}
