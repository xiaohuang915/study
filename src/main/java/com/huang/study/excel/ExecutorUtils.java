package com.huang.study.excel;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author 挥之以墨
 */
public class ExecutorUtils {

    private static ExecutorService executorService;

    static {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("unionCompare-export-pool-%d").build();
        executorService = new ThreadPoolExecutor(1, 100,
                60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1), threadFactory, new ThreadPoolExecutor.AbortPolicy());
    }

    public static <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return executorService.invokeAll(tasks);
    }

}
