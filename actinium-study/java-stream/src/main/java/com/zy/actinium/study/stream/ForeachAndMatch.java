package com.zy.actinium.study.stream;

import com.zy.actinium.study.Person;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.Test;

/**
 * 遍历和匹配 foreach find match。
 *
 * @author Resurgence
 */
public class ForeachAndMatch {

    public static List<Integer> integers = Arrays.asList(1, 3, 3, 5, 6, 20, 15, 12, 10, 11, 13, 4, 2, 8, 6, 5);

    public static List<Integer> sameIntegers = Arrays.asList(3, 3, 3, 3, 3, 3, 3, 3, 3, 3);

    @Test
    public void foreach(){

        integers.forEach(System.out::println);

    }

    @Test
    public void find(){

        // 找到第一个大于10的。

        Optional<Integer> first = integers.stream().filter(x -> x > 10).findFirst();
        first.ifPresent(System.out::println);

        // 是否存在大于20的。

        Optional<Integer> any = integers.parallelStream().filter(x -> x > 20).findAny();
        System.out.println(any.isPresent());

    }


    @Test
    public void match(){

        // 是否存在大于20的数。

        boolean match = integers.parallelStream().anyMatch(x -> x > 20);
        System.out.println("match: " + match);

        // 是否所有的数字都是3。

        boolean allMatch = sameIntegers.parallelStream().allMatch(x -> x == 3);
        System.out.println("allMatch: " + allMatch);

    }

}
