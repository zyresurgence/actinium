# Tips

## 在main方法和在@Test下开启多线程的区别

 main方法中开启多线程会在子线程全部执行结束之后再关闭主线程，
 @Test则是@Test线程走完就直接关闭线程，不会管子线程是否执行完，
 需要使主线程停住来保证子线程的正常执行。

```java
 Thread.sleep();

 System.in.read();
```

# synchronized

## synchronized 同步方法

1. 对其他synchronized同步方法或者synchronized(this)同步代码块调用呈阻塞状态；

2. 同一时间只有一个线程可以执行synchronized同步方法中的代码；

锁的是整个对象，一旦有线程进入同一个对象中synchronized修饰的方法，整个对象下的所有synchronized都会被锁住无法进入，在执行完之前其余的线程都要等待，但是没有被synchronized修饰的方法可以异步调用。

### synchronized 锁重入

当一个线程得到一个对象锁后，在此请求次对象锁时是可以在此得到该对象的锁，在一个 synchronized 方法/块的内部调用本地其它synchronized方法/块时，是永远可以得到锁的。

### 当一个线程中出现异常，锁会自动释放

### synchronized 不具有继承性

子类不会继承父类方法中的synchronized 需要子类手动添加。

### 弊端

耗时，所有线程都得等方法使用完才能进入；

## synchronized 同步代码块

### synchronized(this)

1. 对其他synchronized同步方法或者synchronized(this)同步代码块调用呈阻塞状态；

2. 同一时间只有一个线程可以执行synchronized(this)同步方法中的代码；

### synchronized(非 this对象x)

将x对象本身作为"对象监视器"

1. 当多个线程同时执行synchronized(x){}同步代码块时呈同步效果；

2. 当其他线程执行x对象中synchronized同步方法时呈同步效果；

3. 当其他线程执行x对象方法里面的synchronized(this)代码块时也呈现同步效果；

### 静态同步synchronized方法与synchronized(class)代码块

对当前的*.java文件对应的class类进行持锁,所有的对象持有*.java 对象持有同一把锁;

### 死锁

```java
1. 进入jdk bin目录
2. 输入 jps
3. 找到RunApp并输入 jstack -l id
```

# volatile

使变量在多个线程间可见

## volatile解决死循环

原因：私有堆栈中的值和公共堆栈中的值不同步。
