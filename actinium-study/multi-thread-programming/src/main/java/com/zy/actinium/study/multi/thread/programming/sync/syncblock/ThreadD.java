package com.zy.actinium.study.multi.thread.programming.sync.syncblock;

/**
 * @author Neo
 */
public class ThreadD extends Thread {
    private SyncBlockTask syncBlockTask;

    public ThreadD(SyncBlockTask syncBlockTask){
        this.syncBlockTask = syncBlockTask;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        syncBlockTask.doTask();
        long endTime = System.currentTimeMillis();
        System.out.println("ThreadD consume time ----> "+(endTime - startTime));
    }
}
