package com.zy.actinium.study.multi.thread.programming.sync.syncblock;

/**
 * @author Neo
 */
public class RunApp {
    public static void main(String[] args) {

        // synchronized 同步方法的弊端  耗时
//        SyncMethodkTask syncMethodkTask = new SyncMethodkTask();
//        ThreadA threadA = new ThreadA(syncMethodkTask);
//        threadA.start();
//        ThreadB threadB = new ThreadB(syncMethodkTask);
//        threadB.start();

        // synchronized 同步代码块 减少耗时
//        SyncBlockTask syncBlockTask = new SyncBlockTask();
//        ThreadC threadC = new ThreadC(syncBlockTask);
//        threadC.start();
//        ThreadD threadD = new ThreadD(syncBlockTask);
//        threadD.start();

        // 验证 同步代码快 在代码块中的就是同步执行 不在的就是异步执行
//        SyncBlockTask syncBlockTask = new SyncBlockTask();
//        ThreadE threadE = new ThreadE(syncBlockTask);
//        threadE.start();
//        ThreadF threadF = new ThreadF(syncBlockTask);
//        threadF.start();

        // 验证 synchronized(this) 会造成整个对象下的所有synchronized(this)代码块阻塞
//        SyncBlockTask syncBlockTask = new SyncBlockTask();
//        ThreadG threadG = new ThreadG(syncBlockTask);
//        threadG.start();
//        ThreadH threadH = new ThreadH(syncBlockTask);
//        threadH.start();

        // synchronized(非this) 必须是同一个对象 不然的话就是异步调用了
        SyncBlockTaskWithoutThis syncBlockTaskWithoutThis = new SyncBlockTaskWithoutThis();
        ThreadI threadI = new ThreadI(syncBlockTaskWithoutThis);
        threadI.start();
        ThreadJ threadJ = new ThreadJ(syncBlockTaskWithoutThis);
        threadJ.start();

    }
}
