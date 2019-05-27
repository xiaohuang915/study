package com.huang.study.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description: 定时任务
 * @Author : pc.huang
 * @Date : 2019-02-14 10:44
 */
@Component
public class ScheduledTask {
    private Logger logger = LoggerFactory.getLogger(ScheduledTask.class);

    private int cron1Count = 1;

    private int cron5Count = 1;

//    @Scheduled(cron = "0/1 * * * * ?")
//    public void test1Cron() {
//        logger.info("===测试1秒执行一次: 第{}次执行方法", cron1Count++);
//    }
//
//    @Scheduled(cron = "0/5 * * * * ?")
//    public void test5Cron() {
//        logger.info("===测试5秒执行一次: 第{}次执行方法", cron5Count++);
//    }
}
