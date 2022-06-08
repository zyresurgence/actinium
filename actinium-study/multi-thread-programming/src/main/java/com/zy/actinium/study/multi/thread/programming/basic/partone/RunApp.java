package com.zy.actinium.study.multi.thread.programming.basic.partone;

/**
 * @author Neo
 */
public class RunApp {
    public static void main(String[] args) {
        Thread thread = new Thread(new ExtendsThread(), "extendsThread");
        thread.start();

        Thread thread1 = new Thread(new ImplementsRunnable(), "implementsRunnable");
        thread1.start();
    }
}
