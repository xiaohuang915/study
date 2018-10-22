package com.huang.study.security.service;

import com.huang.study.security.dto.SysUser;

/**
 * @Auther: pc.huang
 * @Date: 2018/10/15 16:03
 * @Description:
 */
public interface IUserService {
    void add(SysUser sysUser);
    void del(long id);
    void update(SysUser sysUser);
    SysUser findUserByUserName(String userName);
}
