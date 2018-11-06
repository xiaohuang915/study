package com.huang.study.common.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: pc.huang
 * @Date: 2018/11/6 15:39
 * @Description:
 */
@Configuration
public class RabbitmqConfig {
    //超时交换机
    public static final String TIMEOUT_EXCHANGE_NAME = "timeout.exchange";
    //超时队列
    public static final String TIMEOUT_QUEUE = "timeout_queue";

    @Bean
    public Queue timeoutQueue(){
        return new Queue(RabbitmqConfig.TIMEOUT_QUEUE,true);
    }

    @Bean
    public CustomExchange timeoutExchange(){
        Map<String,Object> args = new HashMap<>();
        args.put("x-delayed-type","direct");
        return new CustomExchange(RabbitmqConfig.TIMEOUT_EXCHANGE_NAME,"x-delayed-message",true, false,args);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(timeoutQueue()).to(timeoutExchange()).with(RabbitmqConfig.TIMEOUT_QUEUE).noargs();
    }
}
