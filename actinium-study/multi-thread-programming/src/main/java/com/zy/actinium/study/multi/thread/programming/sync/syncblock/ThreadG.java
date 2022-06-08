package com.zy.actinium.study.multi.thread.programming.sync.syncblock;

/**
 * @author Neo
 */
public class ThreadG extends Thread {
    private SyncBlockTask syncBlockTask;

    public ThreadG(SyncBlockTask syncBlockTask){
        this.syncBlockTask = syncBlockTask;
    }

    @Override
    public void run() {
        syncBlockTask.doPrintA();
    }
}
