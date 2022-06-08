package com.zy.actinium.study.multi.thread.programming.sync.syncblock.syncthisobject;

/**
 * @author Neo
 */
public class ThreadA extends Thread {
    private MyList list;

    public ThreadA(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            list.add("threadA "+ (i+1));
        }
    }
}
