package com.zy.actinium.study.multi.thread.programming.sync.deadlock;

import com.zy.actinium.study.multi.thread.programming.sync.ThreadA;

/**
 * @author Neo
 */
public class RunApp {
    public static void main(String[] args) {
        try {
            DealThread dealThread = new DealThread();
            dealThread.setFlag("a");
            Thread thread = new Thread(dealThread);
            thread.start();
            Thread.sleep(1000);
            dealThread.setFlag("b");
            Thread thread2 = new Thread(dealThread);
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
