package com.huang.study.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: pc.huang
 * @Date: 2018/11/5 17:04
 * @Description:
 */
@RestController()
@RequestMapping("/mq")
public class RabbitmqController {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @GetMapping("/send")
    public void send(String msg){
        System.out.println("发送消息="+msg);
        amqpTemplate.convertAndSend("myQueue",msg);
    }
}
