package com.huang.study.thread.syn;

/**
 * @Auther: pc.huang
 * @Date: 2018/11/21 0021 15:39
 * @Description:
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        Sub sub = new Sub();
        sub.operateISubMethod();
    }
}
