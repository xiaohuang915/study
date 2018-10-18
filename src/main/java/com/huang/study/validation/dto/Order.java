package com.huang.study.validation.dto;


import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @Auther: pc.huang
 * @Date: 2018/9/26 17:25
 * @Description:
 */
public class Order {
    @NotBlank(message = "{order.id.notNull}")
    private String orderId;
    @Valid
    private User user;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
