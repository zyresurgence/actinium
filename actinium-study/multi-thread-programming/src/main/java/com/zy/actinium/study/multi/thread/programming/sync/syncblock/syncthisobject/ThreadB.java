package com.zy.actinium.study.multi.thread.programming.sync.syncblock.syncthisobject;

/**
 * @author Neo
 */
public class ThreadB extends Thread {
    private MyList list;

    public ThreadB(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            list.add("threadB "+ (i+1));
        }
    }
}
