package com.zy.actinium.study.stream;

import com.zy.actinium.study.Person;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.junit.Test;

/**
 * 聚合 max/min/count.
 *
 * @author Resurgence
 */
public class Aggregate {

    @Test
    public void max() {

        // 获取工资最高的。

        List<Person> personList = Person.getExampleList();

        Optional<Person> max = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        max.ifPresent(System.out::println);

    }

    @Test
    public void min() {

        // 获取工资最低的。

        List<Person> personList = Person.getExampleList();

        Optional<Person> min = personList.stream().min(Comparator.comparingInt(Person::getSalary));
        min.ifPresent(System.out::println);

    }

    @Test
    public void count() {

        // 工资高于9000的人数。

        List<Person> personList = Person.getExampleList();

        long count = personList.stream().filter(x -> x.getSalary() > 9000).count();
        System.out.println("count: "+count);

    }

}
