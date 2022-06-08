package com.zy.actinium.study.multi.thread.programming.vol.deadcycle;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Neo
 */
public class RunThread extends Thread {
    volatile private boolean isRunning = true;
    private AtomicInteger atomicInteger;
    public boolean isRunning(){
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        System.out.println("come in run");
        while (isRunning == true) {

        }
        System.out.println("thread was stopped");
    }
}
