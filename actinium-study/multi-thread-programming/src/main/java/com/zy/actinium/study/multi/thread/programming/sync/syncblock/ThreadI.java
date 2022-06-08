package com.zy.actinium.study.multi.thread.programming.sync.syncblock;

/**
 * @author Neo
 */
public class ThreadI extends Thread{
    private SyncBlockTaskWithoutThis syncBlockTaskWithoutThis;

    public ThreadI(SyncBlockTaskWithoutThis syncBlockTaskWithoutThis) {
        this.syncBlockTaskWithoutThis = syncBlockTaskWithoutThis;
    }

    @Override
    public void run() {
        super.run();
        syncBlockTaskWithoutThis.setValue("II","III");
    }
}
