package com.huang.study.excel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/7/8 13:37
 */
public class BatchExecutor {
    public static <T> List<List<T>> splitBatch(List<T> data, int size) {
        List<List<T>> resultList = new ArrayList();
        int part = data.size() / size;

        for(int i = 0; i < part; ++i) {
            resultList.add(data.subList(i * size, (i + 1) * size));
        }

        if (data.size() % size > 0) {
            resultList.add(data.subList(part * size, data.size()));
        }

        return resultList;
    }
}
