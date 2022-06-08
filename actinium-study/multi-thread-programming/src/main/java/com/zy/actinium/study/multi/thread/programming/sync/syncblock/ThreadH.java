package com.zy.actinium.study.multi.thread.programming.sync.syncblock;

/**
 * @author Neo
 */
public class ThreadH extends Thread {
    private SyncBlockTask syncBlockTask;

    public ThreadH(SyncBlockTask syncBlockTask){
        this.syncBlockTask = syncBlockTask;
    }

    @Override
    public void run() {
        syncBlockTask.doPrintB();
    }
}
