package com.zy.actinium.study.multi.thread.programming.sync.syncblock;

/**
 * @author Neo
 */
public class ThreadC extends Thread {
    private SyncBlockTask syncBlockTask;

    public ThreadC(SyncBlockTask syncBlockTask){
        this.syncBlockTask = syncBlockTask;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        syncBlockTask.doTask();
        long endTime = System.currentTimeMillis();
        System.out.println("ThreadC consume time ----> "+(endTime - startTime));
    }
}
