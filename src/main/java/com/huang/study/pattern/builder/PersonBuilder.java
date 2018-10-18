package com.huang.study.pattern.builder;

/**
 * @Auther: pc.huang
 * @Date: 2018/8/27 10:26
 * @Description:
 */
public interface PersonBuilder {
    void buildHead();

    void buildBody();

    void buildFoot();

    Person buildPerson();
}
