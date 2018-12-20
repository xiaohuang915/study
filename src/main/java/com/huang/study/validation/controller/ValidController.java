package com.huang.study.validation.controller;

import com.huang.study.validation.dto.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Auther: pc.huang
 * @Date: 2018/9/27 09:22
 * @Description:
 */
@RestController
@RequestMapping("/test/")
public class ValidController {
    @PostMapping(value = "valid")
    public Order valid(@RequestBody @Valid Order order){
        return order;
    }

    @PostMapping(value = "test")
    public Order test(@RequestBody @Valid Order order){
        return order;
    }
}
