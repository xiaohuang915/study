package com.huang.study.common.config;

import com.huang.study.rabbitmq.queueenum.QueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: pc.huang
 * @Date: 2018/11/6 15:39
 * @Description:
 */
@Configuration
public class RabbitmqConfig {
//    /**
//     * 插件实现延迟任务配置 需要安装插件和开起插件
//     */
//    //超时交换机名称
//    public static final String TIMEOUT_EXCHANGE_NAME = "timeout.exchange";
//    //超时队列名称
//    public static final String TIMEOUT_QUEUE = "timeout_queue";
//
//    /**
//     * 队列注册
//     *
//     * @return
//     */
//    @Bean
//    public Queue timeoutQueue() {
//        return new Queue(RabbitmqConfig.TIMEOUT_QUEUE, true);
//    }
//
//    /**
//     * 交换机注册
//     *
//     * @return
//     */
//    @Bean
//    public CustomExchange timeoutExchange() {
//        Map<String, Object> args = new HashMap<>();
//        args.put("x-delayed-type", "direct");
//        return new CustomExchange(RabbitmqConfig.TIMEOUT_EXCHANGE_NAME, "x-delayed-message", true, false, args);
//    }
//
//    /**
//     * 交换机和队列绑定
//     *
//     * @return
//     */
//    @Bean
//    public Binding binding() {
//        return BindingBuilder.bind(timeoutQueue()).to(timeoutExchange()).with(RabbitmqConfig.TIMEOUT_QUEUE).noargs();
//    }

    ///////////////////////////////////////////////////////

    /**
     * 死信队列实现延迟任务配置
     */

    /**
     * 消息过期后转发交换机
     *
     * @return
     */
    @Bean
    DirectExchange messageDirect() {
        return (DirectExchange) ExchangeBuilder.directExchange(QueueEnum.MESSAGE_QUEUE.getExchange()).durable(true).build();
    }

    /**
     * 死信交换机
     *
     * @return
     */
    @Bean
    DirectExchange messageTtlDirect() {
        return (DirectExchange) ExchangeBuilder.directExchange(QueueEnum.MESSAGE_TTL_QUEUE.getExchange()).durable(true).build();
    }

    /**
     * 消息过期后转发队列
     *
     * @return
     */
    @Bean
    public Queue messageQueue() {
        return new Queue(QueueEnum.MESSAGE_QUEUE.getName());
    }

    /**
     * 死信队列
     *
     * @return
     */
    @Bean
    public Queue messageTtlQueue() {
        return QueueBuilder.durable(QueueEnum.MESSAGE_TTL_QUEUE.getName())
                //设置转发交换机
                .withArgument("x-dead-letter-exchange", QueueEnum.MESSAGE_QUEUE.getExchange())
                //设置转发路由键
                .withArgument("x-dead-letter-routing-key", QueueEnum.MESSAGE_QUEUE.getRouteKey())
                .build();
    }

    /**
     * 交换机和队列绑定
     *
     * @param messageDirect
     * @param messageQueue
     * @return
     */
    @Bean
    public Binding messageBinding(DirectExchange messageDirect, Queue messageQueue) {
        return BindingBuilder.bind(messageQueue).to(messageDirect).with(QueueEnum.MESSAGE_QUEUE.getRouteKey());
    }

    /**
     * 交换机和队列绑定
     *
     * @param messageTtlDirect
     * @param messageTtlQueue
     * @return
     */
    @Bean
    public Binding messageTtlBinding(DirectExchange messageTtlDirect, Queue messageTtlQueue) {
        return BindingBuilder.bind(messageTtlQueue).to(messageTtlDirect).with(QueueEnum.MESSAGE_TTL_QUEUE.getRouteKey());
    }
}
