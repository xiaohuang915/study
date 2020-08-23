package com.huang.study.validation.dto;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * @Auther: pc.huang
 * @Date: 2018/9/26 17:25
 * @Description:
 */
@Getter
@Setter
public class Order {

    @NotBlank(message = "订单id不能为空",groups = {Group1.class})
    private String orderId;

    @NotBlank(message = "用户名不能为空",groups = {Group2.class})
    @Pattern(regexp = "[\\u4e00-\\u9fa5]+",message = "必须为中文")
    private String name;

//    @Pattern(regexp = "^1(?:3\\d|4[4-9]|5[0-35-9]|6[67]|7[0-8]|8\\d|9\\d)\\d{8}$",message = "手机号格式不正确")
    @Pattern(regexp = "^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$",message = "手机号格式不正确")
    private String phone;

    //@Pattern(regexp = "^([1-9]|[0-9]\\d{1,3})\\.?([1-9]{1})?",message = "数字必须为正数")
//    @Pattern(regexp = "(^[1-9]\\d{0,3})(\\.[0-9])?|^[0]\\.[1-9]",message = "整数 或者小数（小数点前4位，小数点后1位）")
    @Pattern(regexp = "^[1-9]\\d{0,3}",message = "整数 或者小数（小数点前4位，小数点后1位）")
    private String amount;

//    @Valid
//    private User user;
}
