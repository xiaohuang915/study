package com.huang.study.security.service;

import com.huang.study.security.dto.User;

/**
 * @Auther: pc.huang
 * @Date: 2018/10/15 16:03
 * @Description:
 */
public interface IUserService {
    void add(User user);
    void del(long id);
    void update(User user);
    User findUserByUserName(String userName);
}
