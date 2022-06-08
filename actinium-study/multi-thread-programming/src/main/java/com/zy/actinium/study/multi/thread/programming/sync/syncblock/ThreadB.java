package com.zy.actinium.study.multi.thread.programming.sync.syncblock;

/**
 * @author Neo
 */
public class ThreadB extends Thread {
    private SyncMethodkTask syncMethodkTask;

    public ThreadB(SyncMethodkTask syncMethodkTask){
        this.syncMethodkTask = syncMethodkTask;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        syncMethodkTask.doTask();
        long endTime = System.currentTimeMillis();
        System.out.println("ThreadB consume time ----> "+(endTime - startTime));
    }
}
