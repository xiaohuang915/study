package com.huang.study.test;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2019-02-28 15:51
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class A {

    @JSONField(name = "ID")
    private String id = "父类id11";

    private Long amount;

    private String error;

    public void print() {
        System.out.println("this =" + this);
    }

    public static A.ABuilder builder() {
        return new A.ABuilder();
    }

    public static class ABuilder {
        private String id;
        private Long amount;
        private String error;

        private ABuilder() {

        }

        public A.ABuilder id(final String id) {
            this.id = id;
            return this;
        }

        public A.ABuilder amount(final Long amount) {
            this.amount = amount;
            return this;
        }

        public A.ABuilder error(final String error) {
            this.error = error;
            return this;
        }

        public A build() {
            return new A(this.id, this.amount, this.error);
        }

        @Override
        public String toString() {
            return "ABuilder{" +
                    "id='" + id + '\'' +
                    ", amount=" + amount +
                    ", error='" + error + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "A{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", error='" + error + '\'' +
                '}';
    }

    public static void main(String[] args) {
        A.builder().error("123").build();


    }

}
