package com.huang.study.validation.util;

import com.huang.study.validation.dto.ExcelTest;

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
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdCard.ValidIdCard.class)
public @interface IdCard {
    String message() default "身份证格式不正确";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class ValidIdCard implements ConstraintValidator<IdCard, ExcelTest> {


        @Override
        public void initialize(IdCard constraintAnnotation) {

        }

        @Override
        public boolean isValid(ExcelTest excelTest, ConstraintValidatorContext constraintValidatorContext) {
            IdCardUtil idCardUtil = new IdCardUtil();
            return idCardUtil.testType(excelTest,constraintValidatorContext);
        }
    }
}
