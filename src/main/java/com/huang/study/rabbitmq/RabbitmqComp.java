package com.huang.study.rabbitmq;

import com.huang.study.common.config.RabbitmqConfig;
import com.huang.study.security.dto.SysUser;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Auther: pc.huang
 * @Date: 2018/11/7 11:13
 * @Description:
 */
@Component
public class RabbitmqComp {
    /**
     * 可以通过注解自动配置交换机和队列
     * 配置消费者监听myQueue队列
     * @param msg
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void receive(String msg) {
        System.out.println("队列1接收消息=" + msg);
    }

    /**
     * 配置消费者监听myQueue队列
     * @param msg
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void receive1(String msg) {
        System.out.println("队列2接收消息=" + msg);
    }

    /**
     * 配置消费者监听myQueueDouble队列
     * @param msg
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueueDouble"),
            exchange = @Exchange("myExchange")
    ))
    public void receive2(String msg) {
        System.out.println("double接收消息=" + msg);
    }

    /**
     * 插件实现延时消费的消费者
     * @param msg
     */
    @RabbitListener(queues = {RabbitmqConfig.TIMEOUT_QUEUE})
    public void receive3(String msg) {
        System.out.println("延时接收消息=" + msg + "接收时间=" + new Date());
    }

    /**
     * 如果死信队列里的消息被消费就不会转发出去
     * @param msg
     */
    @RabbitListener(queues = "message.center.create.ttl")
    public void receive5(SysUser msg) {
        System.out.println("死信队列接收消息=" + msg + "接收时间=" + new Date());
    }

    /**
     * 死信队列消息没有被消费会转发到此处
     * @param msg
     */
    @RabbitListener(queues = "message.center.create")
    public void receive4(SysUser msg) {
        System.out.println("Ttl延时接收消息=" + msg + "接收时间=" + new Date());
    }
}
