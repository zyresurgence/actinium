package com.zy.actinium.study.multi.thread.programming.sync;

/**
 * @author Neo
 */
public class ThreadB extends Thread{
    private SubSyncService subSyncService;

    public ThreadB(SubSyncService subSyncService) {
        this.subSyncService = subSyncService;
    }

    @Override
    public void run() {
        subSyncService.printParent();
    }
}
