package com.huang.study.validation;

import com.huang.study.validation.dto.Order;
import com.huang.study.validation.dto.User;
import com.huang.study.validation.util.ValidationUtils;

/**
 * @Auther: pc.huang
 * @Date: 2018/9/26 17:33
 * @Description:
 */
public class Test {
    public static void main(String[] args){
     Order order = new Order();
     order.setOrderId("123");
     User user = new User();
     user.setUserId("456");
     user.setUserName("张三");
     user.setEmail("123@11.com");
     order.setUser(user);
     ValidationUtils.validate(order);
    }
}
