package com.zy.actinium.study.multi.thread.programming.sync.syncblock;

/**
 * @author Neo
 */
public class SyncMethodkTask {

    private String text1;
    private String text2;

    synchronized public void doTask(){
        try {
            System.out.println("starts task!");
            Thread.sleep(3000);
            text1 = "return value 1 ------> " + Thread.currentThread().getName();
            text2 = "return value 2 ------> " + Thread.currentThread().getName();
            System.out.println(text1);
            System.out.println(text2);
            System.out.println("end task!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
