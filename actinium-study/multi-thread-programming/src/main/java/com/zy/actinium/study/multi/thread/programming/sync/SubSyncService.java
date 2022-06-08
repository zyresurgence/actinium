package com.zy.actinium.study.multi.thread.programming.sync;

/**
 * @author Neo
 */
public class SubSyncService extends SyncService {

    synchronized public void printParent() {
        printA();
    }

}
