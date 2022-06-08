package com.zy.actinium.study.multi.thread.programming.sync.syncblock.syncthisobject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Neo
 */
public class MyList {
    private List list = new ArrayList();

    synchronized public void add(String username) {
        System.out.println(Thread.currentThread().getName() + " come in add!");
        list.add(username);
        System.out.println(Thread.currentThread().getName() + " come out add!");
    }

    synchronized public int getSize(){
        System.out.println(Thread.currentThread().getName() + " come in getSize!");
        int size = list.size();
        System.out.println(Thread.currentThread().getName() + " come out getSize!");

        return size;

    }
}
