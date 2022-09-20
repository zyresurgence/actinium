package com.zy.actinium.study.stream;

import com.zy.actinium.study.Person;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * 排序。
 *
 * @author Resurgence
 */
public class Sorted {


    @Test
    public void sorted() {

        List<Person> exampleList = Person.getExampleList();

        // 按照工资 从高到低

        List<String> collect = exampleList.stream()
                .sorted(Comparator.comparing(Person::getSalary))
                .map(Person::getName).collect(Collectors.toList());
        System.out.println(collect);

        // 按照工资 从低到高

        List<String> collect2 = exampleList.stream()
                .sorted(Comparator.comparing(Person::getSalary).reversed())
                .map(Person::getName).collect(Collectors.toList());
        System.out.println(collect2);

        // 先按工资降序，再按年龄升序

        List<String> collect3 = exampleList.stream()
                .sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge).reversed())
                .map(Person::getName).collect(Collectors.toList());
        System.out.println(collect3);

        // 自定义排序 工资升序 然后工资相同时按照年龄降序

        List<String> collect4 = exampleList.stream().sorted((p1, p2) -> {
            if (p1 == p2) {
                return p2.getAge() - p1.getAge();
            } else {
                return p2.getSalary() - p1.getSalary();
            }
        }).map(Person::getName).collect(Collectors.toList());
        System.out.println(collect4);

    }
}
