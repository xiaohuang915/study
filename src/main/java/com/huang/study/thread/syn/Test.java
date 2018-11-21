package com.huang.study.thread.syn;

/**
 * @Auther: pc.huang
 * @Date: 2018/11/21 0021 15:40
 * @Description: 可重入锁测试（父子类继承）
 */
public class Test {
    public static void main(String[] args){
     MyThread thread = new MyThread();
     thread.start();
    }
}
