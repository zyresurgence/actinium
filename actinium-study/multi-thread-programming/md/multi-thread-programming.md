# Tips

## 在main方法和在@Test下开启多线程的区别

 main方法中开启多线程会在子线程全部执行结束之后再关闭主线程，
 @Test则是@Test线程走完就直接关闭线程，不会管子线程是否执行完，
 需要使主线程停住来保证子线程的正常执行。

```java
 Thread.sleep();

 System.in.read();
```

# 基础

## synchronized

### 简介

锁的是整个对象，一旦有线程进入同一个对象中synchronized修饰的方法，整个对象下的所有synchronized都会被锁住无法进入，在执行完之前其余的线程都要等待，但是没有被synchronized修饰的方法可以异步调用。

### synchronized 锁重入


