package com.zy.actinium.study.multi.thread.programming.sync.syncblock.syncthisobject;

/**
 * @author Neo
 */
public class ThreadD extends Thread {
    private MyOneList list;

    public ThreadD(MyOneList list) {
        this.list = list;
    }

    @Override
    public void run() {
        MyService service = new MyService();
        service.addServiceMethod(list, "B");
    }
}
