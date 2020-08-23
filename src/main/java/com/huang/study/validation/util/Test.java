package com.huang.study.validation.util;

import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/4/28 10:48
 */
public class Test {

    private static Validator validator = Validation
            .byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();
    @NotBlank(message = "id is null", groups = Bos.class)
    private String id;

    @NotBlank(message = "name is null")
    private String name;


    public static void main(String[] args) throws ClassNotFoundException {
        String bank = "bos";
        Test test = new Test();

        Set<ConstraintViolation<Test>> constraintViolations = validator.validate(test,BankEnum.getBank(bank).getAClass());
        constraintViolations.forEach(a->{
            System.out.println(a.getMessage());
        });
    }
}
