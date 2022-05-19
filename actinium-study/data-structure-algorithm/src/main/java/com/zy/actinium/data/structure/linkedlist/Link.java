package com.zy.actinium.data.structure.linkedlist;

/**
 * TODO
 *  链节点
 * @author Neo
 * @version 1.0.0
 * @date 2021/7/26 17:45
 */
public class Link {
    public long dData;
    public Link next;

    public Link(long dd) {
        dData = dd;
    }

    public void displayLink() {
        System.out.print("{" + dData + "}");
    }
}
