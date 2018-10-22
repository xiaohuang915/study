package com.huang.study.security.controller;

import com.huang.study.common.tips.SuccessTip;
import com.huang.study.common.tips.Tip;
import com.huang.study.security.dto.SysUser;
import com.huang.study.security.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: pc.huang
 * @Date: 2018/10/15 14:28
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @GetMapping("/hello")
    public Tip test(){
        return new SuccessTip("test success");
    }

    @PostMapping("/reg")
    private Tip add(@RequestBody SysUser sysUser){
        sysUser.setPassword(bCryptPasswordEncoder.encode(sysUser.getPassword()));
        userService.add(sysUser);
        return new SuccessTip("注册成功");
    }
    @PostMapping("/login")
    private Tip login(@RequestBody SysUser sysUser){
        SysUser userBySysUserName = userService.findUserByUserName(sysUser.getUserName());
        return new SuccessTip("登陆成功");
    }
}
