package com.huang.study.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @Description: 多线程配置
 * @Author : pc.huang
 * @Date : 2019-02-14 11:38
 */
@Configuration
public class ScheduleConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(10);
        scheduledTaskRegistrar.setScheduler(executorService);
    }
}
