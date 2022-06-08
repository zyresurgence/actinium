package com.zy.actinium.study.multi.thread.programming.sync.syncblock;

/**
 * @author Neo
 */
public class ThreadE extends Thread {
    private SyncBlockTask syncBlockTask;

    public ThreadE(SyncBlockTask syncBlockTask){
        this.syncBlockTask = syncBlockTask;
    }

    @Override
    public void run() {
        syncBlockTask.doReduceNumber();
    }
}
