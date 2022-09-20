package com.zy.actinium.study;

import java.util.Arrays;
import java.util.List;

public class Person {

    /**
     * 姓名
     */
    private String name;

    /**
     * 薪资
     */
    private int salary;

    /**
     * 年龄
     */
    private int age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 地区
     */
    private String area;

    public Person(){}

    public Person(String name, int salary, int age, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }

    public static List<Person> getExampleList() {

        return Arrays.asList(
                new Person("Resurgence", 11600, 30, "male", "HuBei"),
                new Person("Dream", 8000, 20, "male", "HuBei"),
                new Person("Doom", 8000, 20, "male", "HuNan"),
                new Person("Victor", 10000, 25, "male", "ShanXi"),
                new Person("Cyber", 10000, 22, "male", "HuNan"),
                new Person("Witcher", 12000, 25, "male", "HuBei"),
                new Person("Lie", 8000, 22, "female", "GuangDong"),
                new Person("Dva", 8000, 23, "female", "ChongQing"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
