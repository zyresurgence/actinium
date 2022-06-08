package com.zy.actinium.study.multi.thread.programming.vol.deadcycle;

/**
 * @author Neo
 */
public class RunApp {
    public static void main(String[] args) {
        try {
            RunThread runThread = new RunThread();
            runThread.start();
            Thread.sleep(6000);
            runThread.setRunning(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
