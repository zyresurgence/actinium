package com.zy.actinium.study.multi.thread.programming.basic.parttwo;

/**
 * @author Neo
 */
public class RunApp {
    public static void main(String[] args) {
        try {
            DaemonThread daemonThread = new DaemonThread();
            daemonThread.setDaemon(true);
            daemonThread.start();
            Thread.sleep(5000);
            System.out.println("done!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
