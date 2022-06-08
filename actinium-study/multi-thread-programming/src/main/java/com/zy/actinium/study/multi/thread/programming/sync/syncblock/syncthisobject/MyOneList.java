package com.zy.actinium.study.multi.thread.programming.sync.syncblock.syncthisobject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Neo
 */
public class MyOneList {
    private List list = new ArrayList();

    synchronized public void add(String data) {
        list.add(data);
    }

    synchronized public int getSize() {
        return list.size();
    }
}
