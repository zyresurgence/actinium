package com.zy.actinium.study.multi.thread.programming.sync.syncblock;

/**
 * @author Neo
 */
public class SyncBlockTask {

    private String text1;
    private String text2;

    public void doTask(){
        try {
            System.out.println("starts task!");
            Thread.sleep(3000);
            String returnText1 = "return value 1 ------> " + Thread.currentThread().getName();
            String returnText2 = "return value 2 ------> " + Thread.currentThread().getName();

            synchronized (this){
                text1 = returnText1;
                text2 = returnText2;
            }
            System.out.println(text1);
            System.out.println(text2);
            System.out.println("end task!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doReduceNumber(){
        for (int i = 0; i < 50; i++) {
            System.out.println("no synchronized block -- "+Thread.currentThread().getName()+" -- "+(i+1));
        }

        synchronized (this){
            for (int i = 0; i < 50; i++) {
                System.out.println("synchronized block -- "+Thread.currentThread().getName()+" -- "+(i+1));
            }
        }

    }

    public void doPrintA(){
        synchronized (this){
            try {
                long startTime = System.currentTimeMillis();
                System.out.println("start printA ---> "+ startTime);
                Thread.sleep(3000);
                long endTime = System.currentTimeMillis();
                System.out.println("end printA ---> "+ endTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void doPrintB(){
        synchronized (this){
            try {
                long startTime = System.currentTimeMillis();
                System.out.println("start printB ---> "+ startTime);
                Thread.sleep(3000);
                long endTime = System.currentTimeMillis();
                System.out.println("end printB ---> "+ endTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
