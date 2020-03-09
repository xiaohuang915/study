package com.huang.study.test;

import lombok.*;

import java.util.Optional;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2019-02-28 16:08
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class D {

    private String id;
    private String name;
    private String phone;

    public static void main(String[] args) {
        D d = new D();
        String s = Optional.ofNullable(d)
                .map(D::getId)
                .orElse("");

    }
}
