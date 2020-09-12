package com.huang.study.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 子初
 * @version 1.0
 * @date 2019/4/23 17:31
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext appContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appContext = applicationContext;
    }

    public static boolean containsBean(String beanName) {
        if (appContext != null) {
            return appContext.containsBean(beanName);
        }
        return false;
    }

    public static Object getBean(String beanName) {
        if (appContext != null) {
            return appContext.getBean(beanName);
        }
        return null;
    }

    public static <T> T getBean(Class<T> clazz) {
        if (appContext != null) {
            try {
                return appContext.getBean(clazz);
            } catch (BeansException e) {
                Map<String, T> map = getBeansOfType(clazz);
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    if (entry.getValue().getClass().equals(clazz)) {
                        return entry.getValue();
                    }
                }
                throw e;
            }
        }
        return null;
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> clazz) throws BeansException {
        Map<String, T> map = null;
        if (appContext != null) {
            map = appContext.getBeansOfType(clazz);
            if ((map == null || map.isEmpty()) && appContext.getParent() != null) {
                map = appContext.getParent().getBeansOfType(clazz);
            }
        }
        if (map == null) {
            map = new HashMap<>();
        }
        return map;
    }
}
