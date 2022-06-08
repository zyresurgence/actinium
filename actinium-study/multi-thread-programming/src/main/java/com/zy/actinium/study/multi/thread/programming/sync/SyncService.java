package com.zy.actinium.study.multi.thread.programming.sync;

/**
 * @author Neo
 */
public class SyncService {

    synchronized public void printA(){
        try {
            System.out.println(Thread.currentThread().getName()+": AAA");
            printB();
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void printB(){
        try {
            System.out.println(Thread.currentThread().getName()+": BBB");
            printC();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void printC(){
        try {
            System.out.println(Thread.currentThread().getName()+": CCC");
            printD();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printD(){
        try {
            System.out.println(Thread.currentThread().getName()+": DDD");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
