package com.zy.actinium.study.multi.thread.programming.basic.partone;

/**
 * 创建方式之二: 实现 Runnable
 */
public class ImplementsRunnable implements Runnable {


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--->" + ImplementsRunnable.class.getSimpleName());
    }
}
