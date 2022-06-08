package com.zy.actinium.study.multi.thread.programming.sync;

/**
 * @author Neo
 */
public class RunApp {
    public static void main(String[] args) {
        // synchronized 可重入锁测试
        SyncService syncService = new SyncService();
        SubSyncService subSyncService = new SubSyncService();
        ThreadA threadA = new ThreadA(syncService);
        threadA.start();
        ThreadB threadB = new ThreadB(subSyncService);
        threadB.start();
    }
}
