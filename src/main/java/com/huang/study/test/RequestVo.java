package com.huang.study.test;

import com.huang.study.test.entity.UuidUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2019-03-11 09:53
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestVo {


    private EnvelopeBean envelope;
    private String signature;


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EnvelopeBean {

        private HeadBean head;
        private BodyBean body;


        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class HeadBean {

            private String sysId;
            private String charset;
            private String timestamp;
            private String serialValue;
            private String version;
            private String orgcode;


        }

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class BodyBean {

            private String serviceCode;
            private ParametersBean parameters;


            @Getter
            @Setter
            @NoArgsConstructor
            @AllArgsConstructor
            public static class ParametersBean {

                private String ZHLX;
                private String ZCLY;
                private String SJHM;
                private String SHBH;
                private String SHHYID;


            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Runnable taskTemp = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    // 发起请求
                    System.out.println(UuidUtil.getTxsn());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        RequestVo latchTest = new RequestVo();
        latchTest.startTaskAllInOnce(5, taskTemp);
    }

    public long startTaskAllInOnce(int threadNums, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(threadNums);
        for (int i = 0; i < threadNums; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        // 使线程在此等待，当开始门打开时，一起涌入门中
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            // 将结束门减1，减到0时，就可以开启结束门了
                            endGate.countDown();
                        }
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            };
            t.start();
        }
        long startTime = System.nanoTime();
        System.out.println(startTime + " [" + Thread.currentThread() + "] All thread is ready, concurrent going...");
        // 因开启门只需一个开关，所以立马就开启开始门
        startGate.countDown();
        // 等等结束门开启
        endGate.await();
        long endTime = System.nanoTime();
        System.out.println(endTime + " [" + Thread.currentThread() + "] All thread is completed.");
        return endTime - startTime;
    }

}
