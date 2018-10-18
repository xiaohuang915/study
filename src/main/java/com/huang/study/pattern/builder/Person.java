package com.huang.study.pattern.builder;

/**
 * @Auther: pc.huang
 * @Date: 2018/8/27 10:23
 * @Description: 建造者模式
 */
public class Person {
    private String head;
    private String body;
    private String foot;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }
}
