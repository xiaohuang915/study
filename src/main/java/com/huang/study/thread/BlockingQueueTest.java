package com.huang.study.thread;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @Auther: pc.huang
 * @Date: 2018/10/10 14:20
 * @Description:
 */
public class BlockingQueueTest {
    private static BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>(10);
    public static void main(String[] args){
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        Random random = new Random();
        service.scheduleAtFixedRate(() -> {
            int valut = random.nextInt(101);
            System.out.println(valut+"------"+new Date().toLocaleString());
            blockingQueue.offer(valut);
        },0,1,TimeUnit.MILLISECONDS);

        new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(2000);
                    System.out.println("----------");
                    System.out.println("取值");
                    List<Integer> list = new LinkedList<>();
                    blockingQueue.drainTo(list);
                    list.forEach(System.out::println);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
