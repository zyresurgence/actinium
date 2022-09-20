package com.zy.actinium.study.stream;

import com.zy.actinium.study.Person;
import java.util.List;
import java.util.Optional;
import org.junit.Test;

/**
 * 聚合 (max/min/sum)
 *
 * @author Resurgence
 */
public class Reduce {


    @Test
    public void reduce(){

        List<Person> exampleList = Person.getExampleList();

        // 最高工资。

        Optional<Integer> max = exampleList.parallelStream().map(Person::getSalary).reduce(Integer::max);
        max.ifPresent(System.out::println);

        Optional<Integer> max2 = exampleList.parallelStream().map(Person::getSalary).reduce((x, y) -> x > y ? x : y);
        max2.ifPresent(System.out::println);

        // 最低工资。

        Optional<Integer> min = exampleList.parallelStream().map(Person::getSalary).reduce(Integer::min);
        min.ifPresent(System.out::println);

        // 所有员工工资总和

        Optional<Integer> sum = exampleList.parallelStream().map(Person::getSalary).reduce(Integer::sum);
        sum.ifPresent(System.out::println);

    }
}
