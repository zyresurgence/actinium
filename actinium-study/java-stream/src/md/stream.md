# 概述

    1. Stream可以由集合或数组创建，对流的操作主要分为两种:
        1. 中间操作，即每次返回一个新的流，可以有多个;
        2. 终端操作，即每个流只能进行一个终端操作，终端操作结束后无法再次使用。终端操作会产生一个新的集合或者值;
    
    2. Stream特性:
        1. stream不存储数据，而是按照特定的规则对数据进行计算，一般会输出结果。
        2. stream不会改变数据源，通常情况下会产生一个新的集合或一个值。
        3. stream具有延迟执行特性，只有调用终端操作时，中间操作才会执行。

# Stream 的创建

1. 通过集合Collection创建

```java
List<Integer> integers = Arrays.asList(1, 2, 3, 7, 7, 8, 9, 3);

// 创建一个顺序流。

Stream<Integer> stream = integers.stream();

// 创建一个并行流。

Stream<Integer> parallelStream = integers.parallelStream();
```

2. 通过数组 Arrays创建

```java
int[] integers = {1, 2, 3, 4, 6, 7, 8, 12, 213, 3, 4, 51, 3, 10};

// 创建一个顺序流。

IntStream stream = Arrays.stream(integers);
```

3. Stream 静态方法创建

```java
// 创建一个顺序流。

Stream<Integer> integerStream = Stream.of(9, 3, 5, 12, 213, 3, 51, 3, 10);

// 通过迭代器创建顺序流。 seed: 起始节点 x 元素 以及对应元素的规则  limit: 迭代次数

Stream<Integer> stream = Stream.iterate(1, (x) -> x + 6).limit(5);
stream.forEach(System.out::println);

Stream<Double> doubleStream = Stream.generate(Math::random).limit(6);
doubleStream.forEach(System.out::println);
```

**stream 和 parallelStream的区别**

stream是顺序流，由主线程按顺序对流执行操作；

parallelStream是并行流，内部以多线程并行的方式对流进行操作，常用于对数据没有顺序要求的场景比如筛选;

```java
// 可以通过 parallel()方法将顺序流转换成并行流

Stream<Integer> stream= Stream.of( 3, 9, 3, 6, 213, 3, 51, 3, 10);

Stream<Integer> parallelStream = stream.parallel();
```

# stream的使用

## 遍历/匹配(foreach/find/match)

集合的遍历和匹配元素

## 筛选(filter)

按照一定的规则校验流中的元素，将符合条件的元素提取到新的流中

## 聚合(max/min/count)

对集合、数组的数据统计

## 映射（map/faltMap）

可以将一个流的元素按照一定的映射规则映射到另一个流中

### map faltMap

map: 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。

faltMap: 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。

## 归约(reduce)

把一个流缩减成一个值，实现对集合求和，求积，求最值等操作。

## 收集(collect)

把一个流收集起来，最终可以是收集成一个值也可以收集成一个新的集合。

### 归集(toList/toSet/toMap)

流不存储数据，那么在流中的数据完成处理后，需要将流中的数据重新归集到新的集合

### 统计(count/averaging)

计数：count
平均值：averagingInt、averagingLong、averagingDouble
最值：maxBy、minBy
求和：summingInt、summingLong、summingDouble
统计以上所有：summarizingInt、summarizingLong、summarizingDouble

### 分组(partitionBy/groupingBy)

分区：将`stream`按条件分为两个`Map`，比如员工按薪资为两部分。

分组：将集合分为多个Map，比如员工按性别分组。有单级分组和多级分组。

### 接和(joining)

`joining`可以将stream中的元素用特定的连接符（没有的话，则直接连接）连接成一个字符串。

### 归约(reducing)

`Collectors`类提供的`reducing`方法，相比于`stream`本身的`reduce`方法，增加了对自定义归约的支持

## 排序(sort)

## 提取/组合（distinct/skip/limit）