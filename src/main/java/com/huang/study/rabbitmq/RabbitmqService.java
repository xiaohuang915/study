package com.huang.study.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: pc.huang
 * @Date: 2018/11/5 17:23
 * @Description:
 */
@Service
public class RabbitmqService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

//    /**
//     * 插件实现延迟消息
//     * @param msg
//     */
//    public void send(String msg) {
//        rabbitTemplate.convertAndSend(RabbitmqConfig.TIMEOUT_EXCHANGE_NAME, RabbitmqConfig.TIMEOUT_QUEUE, msg, message -> {
//            message.getMessageProperties().setDelay(500000);
//            return message;
//        });
//    }

    /**
     *  发送延时消息到死信交换机
     * @param exchange
     * @param routerKey
     * @param messageContent
     * @param expTime
     */
    public void send(String exchange,String routerKey,Object messageContent,final long expTime){
          rabbitTemplate.convertAndSend(exchange,routerKey,messageContent,message -> {
                message.getMessageProperties().setExpiration(String.valueOf(expTime));
                return message;
          });
    }
}
