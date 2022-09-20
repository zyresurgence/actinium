package com.zy.actinium.study.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * 创建流。
 *
 * @author Resurgence
 */
public class CreateStream {


    @Test
    public void byCollection() {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 3, 5, 6, 7, 8, 12, 213, 3, 4, 51, 3, 10);

        // 创建一个顺序流。

        Stream<Integer> stream = integers.stream();

        // 创建一个并行流。

        Stream<Integer> parallelStream = integers.parallelStream();


    }

    @Test
    public void byArrays() {

        int[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 3, 5, 6, 7, 8, 12, 213, 3, 4, 51, 3, 10};

        // 创建一个顺序流。

        IntStream stream = Arrays.stream(integers);

    }

    @Test
    public void byStream(){

        // 创建一个顺序流。

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 3, 5, 6, 7, 8, 12, 213, 3, 4, 51, 3, 10);

        // 通过迭代器创建顺序流。 seed: 起始节点 x 元素 以及对应元素的规则  limit: 迭代次数

        Stream<Integer> stream = Stream.iterate(1, (x) -> x + 6).limit(5);
        stream.forEach(System.out::println);

        Stream<Double> doubleStream = Stream.generate(Math::random).limit(6);
        doubleStream.forEach(System.out::println);

    }

    @Test
    public void transferStreamToParallelStream(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 3, 5, 6, 7, 8, 12, 213, 3, 4, 51, 3, 10);

        Stream<Integer> parallelStream = stream.parallel();
    }

}
