package com.zy.actinium.study.multi.thread.programming.sync.syncblock.syncthisobject;

import java.util.ArrayList;

/**
 * @author Neo
 */
public class RunApp {

    public static void main(String[] args) {

//        MyList list = new MyList();
//
//        ThreadA threadA = new ThreadA(list);
//        threadA.setName("A");
//        threadA.start();
//        ThreadB threadB = new ThreadB(list);
//        threadB.setName("B");
//        threadB.start();

        // 验证 脏读
        try {
            MyOneList oneList = new MyOneList();
            ThreadC threadC = new ThreadC(oneList);
            threadC.setName("C");
            threadC.start();
            ThreadD threadD = new ThreadD(oneList);
            threadD.setName("D");
            threadD.start();
            Thread.sleep(6000);
            System.out.println("size: "+oneList.getSize());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
