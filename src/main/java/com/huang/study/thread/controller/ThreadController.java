package com.huang.study.thread.controller;

import com.huang.study.thread.model.Order;
import com.huang.study.thread.model.OrderSearchModel;
import com.huang.study.thread.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: pc.huang
 * @Date: 2018/11/19 0019 20:15
 * @Description:
 */
@RestController
@RequestMapping("/order")
public class ThreadController {
//    @Autowired
//    private AmqpTemplate amqpTemplate;
    @Autowired
    private IOrderService orderService;
    @PostMapping("/create")
    public void create(@RequestBody  Order order){
        orderService.create(order);
//        amqpTemplate.convertAndSend("threadQueue", order);
    }
    @PostMapping("/update")
    public void update(@RequestBody  Order order){
        orderService.update(order);
    }

    @PostMapping("/select")
    public List<Order> select(@RequestBody OrderSearchModel orderSearchModel){
         return orderService.select(orderSearchModel);
    }
}
