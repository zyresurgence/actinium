package com.zy.actinium.study.stream;

import com.zy.actinium.study.Person;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * 集合 (collect)
 * java.util.stream.Collectors
 *
 * @author Resurgence
 */
public class Collect {

    @Test
    public void toList() {

        List<Person> exampleList = Person.getExampleList();

        // 工资大于10000的组成新集合。

        List<Person> personList = exampleList.parallelStream()
                .filter(person -> person.getSalary() > 10000)
                .collect(Collectors.toList());
        personList.forEach(System.out::println);

    }

    @Test
    public void toSet() {

        List<Person> exampleList = Person.getExampleList();

        // 工资低于9000的组成新集合。

        Set<Person> collect = exampleList.parallelStream()
                .filter(person -> person.getSalary() < 9000)
                .collect(Collectors.toSet());
        collect.forEach(System.out::println);

    }

    @Test
    public void toMap() {

        List<Person> exampleList = Person.getExampleList();

        // 按照男女分组。

        Map<String, Integer> salaryMap = exampleList.parallelStream()
                .filter(person -> person.getSalary() > 8000)
                .collect(Collectors.toConcurrentMap(Person::getName, Person::getSalary));
        System.out.println("salaryMap: " + salaryMap);
    }

    @Test
    public void operation(){

        List<Person> exampleList = Person.getExampleList();

        // count

        Long size = exampleList.parallelStream().collect(Collectors.counting());
        System.out.println(size);

        // average 求平均工资

        Double average = exampleList.parallelStream().collect(Collectors.averagingDouble(Person::getSalary));
        System.out.println(average);

        // 最高工资

        Optional<Integer> max = exampleList.parallelStream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compareTo));
        max.ifPresent(System.out::println);

        // 工资总和

        Integer collect = exampleList.parallelStream().collect(Collectors.summingInt(Person::getSalary));

        // 一次性统计所有信息

        DoubleSummaryStatistics summaryStatistics = exampleList.parallelStream().collect(Collectors.summarizingDouble(Person::getSalary));
        System.out.println(summaryStatistics);

    }


    @Test
    public void group(){

        List<Person> exampleList = Person.getExampleList();

        // 工资高于9000的分区

        Map<Boolean, List<Person>> partMap = exampleList.parallelStream()
                .collect(Collectors.partitioningBy(x -> x.getSalary() > 9000));
        System.out.println(partMap);

        // 男女分组

        Map<String, List<Person>> groupMap = exampleList.parallelStream().collect(Collectors.groupingBy(Person::getSex));
        System.out.println(groupMap);

        // 先按 性别分 再按地区分

        Map<String, Map<String, List<Person>>> complexGroup = exampleList.parallelStream()
                .collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));
        System.out.println(complexGroup);
    }

    @Test
    public void joining(){

        List<Person> exampleList = Person.getExampleList();

        String collect = exampleList.stream().map(Person::getName).collect(Collectors.joining("-=-"));
        System.out.println(collect);

    }

    @Test
    public void reducing(){



    }
}
