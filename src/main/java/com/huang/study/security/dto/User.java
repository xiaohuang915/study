package com.huang.study.security.dto;

import javax.persistence.*;

/**
 * @Auther: pc.huang
 * @Date: 2018/10/15 15:23
 * @Description:
 */
@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "user_name")
    private String userName;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
