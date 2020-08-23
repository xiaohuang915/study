package com.huang.study.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/3/23 15:48
 */
@Component
public class SpringTest implements ApplicationContextAware, InitializingBean {
    private  ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, CalService> beansOfType = applicationContext.getBeansOfType(CalService.class);
        System.out.println("111");
    }
}
