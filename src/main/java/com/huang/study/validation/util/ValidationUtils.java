package com.huang.study.validation.util;

/**
 * @Auther: pc.huang
 * @Date: 2018/9/26 16:55
 * @Description:
 */

import com.huang.study.common.exception.HouseloanException;
import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.Set;
/**
 * 接口入参数据校验工具类.<br/>
 * 使用hibernate-validator进行校验.<br/>
 *
 * @Null   被注释的元素必须为 null
 * @NotNull    被注释的元素必须不为 null(用在基本类型上)
 * @AssertTrue     被注释的元素必须为 true
 * @AssertFalse    被注释的元素必须为 false
 * @Min(value)     被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * @Max(value)     被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * @DecimalMin(value)  被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * @DecimalMax(value)  被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * @Size(max=, min=)   被注释的元素的大小必须在指定的范围内
 * @Digits (integer, fraction)     被注释的元素必须是一个数字，其值必须在可接受的范围内
 * @Past   被注释的元素必须是一个过去的日期
 * @Future     被注释的元素必须是一个将来的日期
 * @Pattern(regex=,flag=)  被注释的元素必须符合指定的正则表达式
 * Hibernate Validator 附加的 constraint
 * @NotBlank(message =)   验证字符串非null，且长度必须大于0(用在String上面)
 * @Email  被注释的元素必须是电子邮箱地址
 * @Length(min=,max=)  被注释的字符串的大小必须在指定的范围内
 * @NotEmpty   被注释的字符串的必须非空(用在集合类上面)
 * @Range(min=,max=,message=)  被注释的元素必须在合适的范围内
 *
 *
 * 在bean中引用其他bean则需要加上@Valid 注解，否则验证无效
 * 如：
 * public class Order {
 *     @NotBlank(message = "订单id不能为空")
 *     private String orderId;
 *     @Valid
 *     private User user;
 */
public class ValidationUtils {

    /**
     * 使用hibernate的注解来进行验证
     */
    private static Validator validator = Validation
            .byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();

    /**
     * 功能描述: <br>
     * 〈注解验证参数〉
     *
     * @param obj
     */
    public static <T> void validate(T obj) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
        Iterator<ConstraintViolation<T>> iter = constraintViolations.iterator();
        while (iter.hasNext()) {
            ConstraintViolation<T> error = iter.next();
            System.out.println(error.getPropertyPath().toString());
            throw new HouseloanException("-1",error.getMessage(),error.getPropertyPath().toString());
        }
    }
}

