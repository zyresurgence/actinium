package com.zy.actinium.study.data.structure.linkedlist;

/**
 * TODO
 *  双向链节点
 * @author Neo
 * @version 1.0.0
 * @date 2021/8/23 11:32
 */
public class DoublyLink {

    public long dData;
    public DoublyLink next;
    public DoublyLink prev;

    public DoublyLink(long d) {
        dData = d;
    }

    public void displayLink(){
        System.out.print(dData+" ");
    }
}
