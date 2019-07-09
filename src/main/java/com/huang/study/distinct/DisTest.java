package com.huang.study.distinct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2019/7/9 14:32
 */
public class DisTest {
    public static void main(String[] args) {
        String[] arr1 = {"a", "b", "c"};
        String[] arr2 = {"a", "b", "c", "d"};

        List<String> list1 = new ArrayList<>(Arrays.asList(arr1));
        List<String> list2 = new ArrayList<>(Arrays.asList(arr2));


        List<String> collect = Stream.of(list1, list2)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);

        Test test = new Test();
        test.setId("123");
        Test test1 = new Test();
        test1.setId("456");
        List<Test> list3 = new ArrayList<>();
        list3.add(test);
        list3.add(test1);
        List<Test> list4 = new ArrayList<>();
        list4.add(test);
        list4.add(test1);

        List<Test> collect1 = Stream.of(list3, list4)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect1);
    }
}
