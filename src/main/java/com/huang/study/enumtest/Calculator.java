package com.huang.study.enumtest;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2019-02-28 15:19
 */
public enum Calculator {

    // 加法运算
    ADD("+") {

        @Override
        public int exec(int a, int b) {
            return a + b;
        }

    },

    //减法
    SUB("-"){

        @Override
        public int exec(int a, int b) {
            return a-b;
        }

    },

    sum(""){
        @Override
        public int exec(int a, int b) {
            return 0;
        }
    }

    ;
    String value;

    private Calculator(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public abstract int exec(int a, int b);


    public static void main(String[] args) {
        System.out.println(Calculator.ADD.exec(1, 2));
    }


}
