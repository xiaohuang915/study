package com.huang.study.rabbitmq;

import com.huang.study.rabbitmq.queueenum.QueueEnum;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
    @Autowired
    private RabbitmqService rabbitmqService;

    @GetMapping("/send")
    public void send(String msg) {
        System.out.println("发送消息=" + msg);
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                amqpTemplate.convertAndSend("myQueueDouble", msg + i);
            } else {
                amqpTemplate.convertAndSend("myQueue", msg + i);
            }
        }
    }

    /**
     * 插件实现延时消费
     * @param msg
     */
    @GetMapping("/time")
    public void send1(String msg) {
        System.out.println("发送消息=" + msg + "时间=" + new Date());
        rabbitmqService.send(msg);
    }

    /**
     * 死信队列实现延时消费
     * @param msg
     */
    @GetMapping("/ex")
    public void send2(String msg) {
        System.out.println("Ttl延时消息发送时间=" + new Date());
        rabbitmqService.send(QueueEnum.MESSAGE_TTL_QUEUE.getExchange(), QueueEnum.MESSAGE_TTL_QUEUE.getRouteKey(), msg, 5000);
    }

}
