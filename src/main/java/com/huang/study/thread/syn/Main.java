package com.huang.study.thread.syn;

/**
 * @Auther: pc.huang
 * @Date: 2018/11/21 0021 15:29
 * @Description:
 */
public class Main {
    public int i = 10;

    synchronized public void operateIMainMethod() {
        try {
            i--;
            System.out.println("main print i=" + i);
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
