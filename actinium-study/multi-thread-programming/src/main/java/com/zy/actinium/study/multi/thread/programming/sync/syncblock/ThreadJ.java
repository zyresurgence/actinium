package com.zy.actinium.study.multi.thread.programming.sync.syncblock;

/**
 * @author Neo
 */
public class ThreadJ extends Thread{
    private SyncBlockTaskWithoutThis syncBlockTaskWithoutThis;

    public ThreadJ(SyncBlockTaskWithoutThis syncBlockTaskWithoutThis) {
        this.syncBlockTaskWithoutThis = syncBlockTaskWithoutThis;
    }

    @Override
    public void run() {
        super.run();
        syncBlockTaskWithoutThis.setValue("JJ","JJJ");
    }
}
