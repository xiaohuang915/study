package com.huang.study.mysql;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020-08-27 23:05
 */
public class Test {


    public static void main(String[] args) throws InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println("----");
        CountDownLatch ct = new CountDownLatch(2);
        ForkJoinPool fk = new ForkJoinPool(20);
        new Thread(() -> {
            fk.submit(() -> {
                        try {
                            test1();
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            ct.countDown();
                        }
                    }
            );

        }).start();
        ForkJoinPool fk1 = new ForkJoinPool(20);
        new Thread(() -> {
            fk1.submit(() -> {
                        try {
                            test2();
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            ct.countDown();
                        }
                    }
            );

        }).start();
        ct.await();
    }

    private static void test1() throws Exception {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add(i + "");
        }
        AtomicInteger count = new AtomicInteger();
        list.parallelStream().forEach(a -> {
            if (count.incrementAndGet() % 1000 == 0) {
                System.out.println(Thread.currentThread().getName() + "test1-" + count.get());
            }
        });
    }

    private static void test2() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add(i + "");
        }
        AtomicInteger count = new AtomicInteger();
        list.parallelStream().forEach(a -> {
            if (count.incrementAndGet() % 1000 == 0) {
                System.out.println(Thread.currentThread().getName() + "test2-" + count.get());
            }
        });
    }
}
