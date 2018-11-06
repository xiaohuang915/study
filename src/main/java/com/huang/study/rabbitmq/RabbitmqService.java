package com.huang.study.rabbitmq;

import com.huang.study.common.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Auther: pc.huang
 * @Date: 2018/11/5 17:23
 * @Description:
 */
@Service
public class RabbitmqService {
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void receive(String msg) {
        System.out.println("1接收消息=" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void receive1(String msg) {
        System.out.println("2接收消息=" + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueueDouble"),
            exchange = @Exchange("myExchange")
    ))
    public void receive2(String msg) {
        System.out.println("double接收消息=" + msg);
    }

    @RabbitListener(queues = {RabbitmqConfig.TIMEOUT_QUEUE})
    public void receive3(String msg) {
        System.out.println("延时接收消息=" + msg + "接收时间=" + new Date());
    }

    public void send(String msg) {
        rabbitTemplate.convertAndSend(RabbitmqConfig.TIMEOUT_EXCHANGE_NAME, RabbitmqConfig.TIMEOUT_QUEUE, msg, message -> {
            message.getMessageProperties().setDelay(5000);
            return message;
        });
    }
}
