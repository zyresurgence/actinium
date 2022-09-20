package com.zy.actinium.study.stream;

import com.zy.actinium.study.Person;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * 过滤。
 *
 * @author Resurgence
 */
public class Filter {

    @Test
    public void filter() {

        List<Person> personList = Person.getExampleList();

        // 筛选工资高于9000的。

        List<String> collect = personList.parallelStream().filter(person -> person.getSalary() > 9000)
                .map(Person::getName).collect(Collectors.toList());
        System.out.println("collect: " + collect);

        // 统计 工资高于9000的有多少人。

        long count = personList.parallelStream().filter(person -> person.getSalary() > 9000).count();
        System.out.println("count: " + count);

    }


}
