package com.huang.study.security.dao;

import com.huang.study.security.dto.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: pc.huang
 * @Date: 2018/10/15 15:55
 * @Description:
 */
public interface UserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUserName(String userName);

//    void delete(long id);
}
