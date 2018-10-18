package com.huang.study.pattern.builder;

/**
 * @Auther: pc.huang
 * @Date: 2018/8/27 10:30
 * @Description:
 */
public class PersonDirector {
    public Person constructPerson(PersonBuilder personBuilder) {
        personBuilder.buildBody();
        personBuilder.buildFoot();
        personBuilder.buildHead();
        return personBuilder.buildPerson();
    }
}
