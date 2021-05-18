package com.huang.study.security.service.impl;

import com.huang.study.security.dao.UserRepository;
import com.huang.study.security.dto.SysUser;
import com.huang.study.security.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: pc.huang
 * @Date: 2018/10/15 16:04
 * @Description:
 */
@Service
@Transactional
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void add(SysUser sysUser) {
        userRepository.save(sysUser);
    }

    @Override
    public void delete(long id) {
//        userRepository.delete(id);
    }

    @Override
    public void update(SysUser sysUser) {
        userRepository.save(sysUser);
    }

    @Override
    public SysUser findUserByUserName(String userName) {
       return userRepository.findByUserName(userName);
    }
}
