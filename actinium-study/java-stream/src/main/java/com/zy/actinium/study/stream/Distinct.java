package com.zy.actinium.study.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * 组合。
 *
 * @author Resurgence
 */
public class Distinct {

    public static List<Integer> integers = Arrays.asList(1, 3, 3, 5, 6, 20, 15, 12, 10, 11, 13, 4, 2, 8, 6, 5);

    public static List<Integer> otherIntegers = Arrays.asList(3, 4, 8, 10, 15, 18, 19, 23);

    @Test
    public void contact() {

        // 拼接集合

        List<Integer> collect = Stream.concat(integers.stream(), otherIntegers.stream()).distinct().collect(Collectors.toList());
        System.out.println(collect);

        // 迭代 限制次数

        List<Integer> collect1 = Stream.iterate(1, x -> x * 2).limit(10).collect(Collectors.toList());
        System.out.println(collect1);

        // 迭代 skip 跳过 limit 限制次数

        List<Integer> collect2= Stream.iterate(1, x -> x * 2).skip(2).limit(10).collect(Collectors.toList());
        System.out.println(collect2);

    }

}
