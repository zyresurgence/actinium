package com.zy.actinium.study.multi.thread.programming.sync.syncblock;

/**
 * @author Neo
 */
public class ThreadF extends Thread {
    private SyncBlockTask syncBlockTask;

    public ThreadF(SyncBlockTask syncBlockTask){
        this.syncBlockTask = syncBlockTask;
    }

    @Override
    public void run() {
        syncBlockTask.doReduceNumber();
    }
}
