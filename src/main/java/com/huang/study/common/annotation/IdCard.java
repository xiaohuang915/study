package com.huang.study.common.annotation;

import com.huang.study.validation.util.IdCardUtil;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: pc.huang
 * @Date: 2018/9/27 12:56
 * @Description: 自定义校验身份证
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdCard.ValidIdCard.class)
public @interface IdCard {
    String message() default "身份证格式不正确";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class ValidIdCard implements ConstraintValidator<IdCard, String> {

        @Override
        public void initialize(IdCard constraintAnnotation) {

        }

        @Override
        public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
            return IdCardUtil.isIdcard(s);
        }
    }
}
