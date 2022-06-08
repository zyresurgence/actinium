package com.zy.actinium.study.multi.thread.programming.sync;

/**
 * @author Neo
 */
public class ThreadA extends Thread {

    private SyncService syncService;

    public ThreadA(SyncService syncService) {
        this.syncService = syncService;
    }

    @Override
    public void run() {
        syncService.printA();
    }
}
