package com.zy.actinium.study.stream;

import com.zy.actinium.study.Person;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * 映射 (map/flatMap)
 *
 * @author Resurgence
 */
public class Map {

    @Test
    public void map() {

        // 所有员工工资加2000。

        List<Person> exampleList = Person.getExampleList();

        List<Person> personList = exampleList.parallelStream()
                .map(person -> {
                    person.setSalary(person.getSalary() + 2000);
                    return person;
                }).collect(Collectors.toList());
        System.out.println("personList: " + personList);


    }


    @Test
    public void peek() {

        // 所有员工工资加2000。

        List<Person> exampleList = Person.getExampleList();

        List<Person> personList = exampleList.parallelStream()
                .peek(person -> person.setSalary(person.getSalary() + 2000))
                .collect(Collectors.toList());

        System.out.println("personList: " + personList);

    }


    @Test
    public void operation() {

        List<Person> exampleList = Person.getExampleList();

        // 所有员工工资总和

        int sum = exampleList.parallelStream().mapToInt(Person::getSalary).sum();
        System.out.println(sum);

        // 平均工资。

        OptionalDouble average = exampleList.parallelStream().mapToDouble(Person::getSalary).average();
        average.ifPresent(System.out::println);

        // 最高工资。

        OptionalInt max = exampleList.parallelStream().mapToInt(Person::getSalary).max();
        max.ifPresent(System.out::println);

    }

}
