package com.zy.actinium.study.multi.thread.programming.basic.partone;

/**
 * 创建方式之一: 继承 Thread
 */
public class ExtendsThread extends Thread {

    @Override
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName() + "--->" + ExtendsThread.class.getSimpleName());
    }
}
