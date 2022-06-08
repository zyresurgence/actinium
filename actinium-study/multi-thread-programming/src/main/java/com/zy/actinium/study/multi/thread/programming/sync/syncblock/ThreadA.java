package com.zy.actinium.study.multi.thread.programming.sync.syncblock;

/**
 * @author Neo
 */
public class ThreadA extends Thread {
    private SyncMethodkTask syncMethodkTask;

    public ThreadA(SyncMethodkTask syncMethodkTask){
        this.syncMethodkTask = syncMethodkTask;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        syncMethodkTask.doTask();
        long endTime = System.currentTimeMillis();
        System.out.println("ThreadA consume time ----> "+(endTime - startTime));
    }
}
