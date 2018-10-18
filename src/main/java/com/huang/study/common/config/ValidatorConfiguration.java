package com.huang.study.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

/**
 * @Auther: pc.huang
 * @Date: 2018/9/27 14:51
 * @Description: 国际化配置
 */
@Configuration
public class ValidatorConfiguration {
    public ResourceBundleMessageSource getMessageSource() throws Exception {
        ResourceBundleMessageSource rbms = new ResourceBundleMessageSource();
        rbms.setDefaultEncoding("UTF-8");
        rbms.setBasenames("i18n/message");
        return rbms;
    }

    @Bean
    public Validator getValidator() throws Exception {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(getMessageSource());
        return validator;
    }
}
