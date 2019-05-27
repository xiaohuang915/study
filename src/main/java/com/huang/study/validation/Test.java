package com.huang.study.validation;

import com.huang.study.validation.dto.Order;
import com.huang.study.validation.dto.User;
import com.huang.study.validation.util.ValidationUtils;

import javax.validation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Auther: pc.huang
 * @Date: 2018/9/26 17:33
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        List<Order> list = new ArrayList<>();
        Order order = new Order();
//        order.setName("测_试");
        order.setPhone("111");
        order.setAmount("01");
        list.add(order);
//        Order order1 = new Order();
//        order1.setOrderId("111");
//        list.add(order1);
//     order.setOrderId("123");
        User user = new User();
        user.setUserId("456");
        user.setUserName("张三");
        user.setEmail("123@11.com");
//     order.setUser(user);
        ValidationUtils.validate(order);
        Validator validator = createValidator();
        Set<ConstraintViolation<Order>> validate1 = validator.validate(order);
        System.out.println(Test.error(validate1));
//        StringBuffer stringBuffer = new StringBuffer();
//        for (int i = 0; i < list.size(); i++) {
//            Set<ConstraintViolation<Order>> validate = validator.validate(list.get(i));
//            String error = Test.error(validate);
//            stringBuffer.append("第" + (i + 3) + "行出错消息：").append(error).append("\n");
//        }
//        System.out.println(stringBuffer.toString());
//        Order order = new Order();
//        order.setOrderId("");
////        order.setName("@测试");
//        Set<ConstraintViolation<Order>> validate = validator.validate(order);
//        Test.error(validate);
    }

    public static Validator createValidator() {
        Configuration<?> config = Validation.byDefaultProvider().configure();
        ValidatorFactory factory = config.buildValidatorFactory();
        Validator validator = factory.getValidator();
        factory.close();
        return validator;
    }

    private static void printError(ConstraintViolation<?> violation) {
        System.out.println(violation.getPropertyPath()
                + " " + violation.getMessage());
    }

    private static <T> String error(Set<ConstraintViolation<T>> list) {
        StringBuffer stringBuffer = new StringBuffer();
        list.forEach(a -> {
            stringBuffer.append(a.getMessage()).append(",");
        });
        return stringBuffer.toString();
    }
}
