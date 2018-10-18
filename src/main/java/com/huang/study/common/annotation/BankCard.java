package com.huang.study.common.annotation;

import com.huang.study.validation.util.CheckBankCard;

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
 * @Description: 自定义校验银行卡
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BankCard.ValidBankCard.class)
public @interface BankCard {
    String message() default "银行卡格式不正确";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class ValidBankCard implements ConstraintValidator<BankCard, String> {

        @Override
        public void initialize(BankCard constraintAnnotation) {

        }

        @Override
        public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
            return CheckBankCard.checkBankCard(s);
        }
    }
}
