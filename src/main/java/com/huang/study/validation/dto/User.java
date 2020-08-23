package com.huang.study.validation.dto;


import com.huang.study.common.annotation.BankCard;
import com.huang.study.common.annotation.IdCard;
import com.huang.study.common.constant.ValidatorConstant;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * @Auther: pc.huang
 * @Date: 2018/9/26 17:24
 * @Description:
 */
public class User {
    @NotBlank(message = "{user.id.notNull}")
    private String userId;
    @NotBlank(message = "{user.name.notNull}")
    private String userName;
    @Email
    private String email;
    @BankCard(message = "{bank.card.error}")
    private String bankCard;
    @Pattern(regexp = ValidatorConstant.REGEX_MOBILE, message = "{phone.error}")
    private String phone;
    @IdCard
    private String idCard;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
