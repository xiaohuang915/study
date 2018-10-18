package com.huang.study.pattern.builder;

/**
 * @Auther: pc.huang
 * @Date: 2018/8/27 10:27
 * @Description:
 */
public class ManBuilder implements PersonBuilder {
    Person person;

    public ManBuilder() {
        person = new Person();
    }

    @Override
    public void buildHead() {
        person.setHead("建造头部");
    }

    @Override
    public void buildBody() {
        person.setBody("建造身体");
    }

    @Override
    public void buildFoot() {
        person.setFoot("建造四肢");
    }

    @Override
    public Person buildPerson() {
        return person;
    }
}
