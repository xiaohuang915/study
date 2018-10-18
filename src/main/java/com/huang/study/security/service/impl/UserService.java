package com.huang.study.security.service.impl;

import com.huang.study.security.dao.UserRepository;
import com.huang.study.security.dto.User;
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
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public void del(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public User findUserByUserName(String userName) {
       return userRepository.findByUserName(userName);
    }
}
