package com.huang.study.thread.syn;

/**
 * @Auther: pc.huang
 * @Date: 2018/11/21 0021 15:33
 * @Description:
 */
public class Sub extends Main {
    synchronized public void operateISubMethod() {
        try {
            while (i > 0) {
                i--;
                System.out.println("sub print i=" + i);
                Thread.sleep(100);
                this.operateIMainMethod();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
