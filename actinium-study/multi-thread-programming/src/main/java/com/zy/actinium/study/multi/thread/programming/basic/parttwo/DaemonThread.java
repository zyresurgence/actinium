package com.zy.actinium.study.multi.thread.programming.basic.parttwo;

/**
 * @author Neo
 */
public class DaemonThread extends Thread {
    private int i = 20;

    @Override
    public void run() {
        while (i > 0) {
            try {
                i--;
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"----> "+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
