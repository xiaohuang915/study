package com.huang.study.base.lambda;

/**
 * @Auther: pc.huang
 * @Date: 2018/8/31 17:19
 * @Description:
 */
public class Student {
    private String guid;
    private String name;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
