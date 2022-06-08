package com.zy.actinium.study.multi.thread.programming.sync.syncblock.syncthisobject;

/**
 * @author Neo
 */
public class MyService {
    public MyOneList addServiceMethod(MyOneList list, String data) {
        try {
            // 需要同步返回 不然的会出现脏读
            synchronized (list) {
                if (list.getSize() < 1) {
                    Thread.sleep(2000);
                    list.add(data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }
}
