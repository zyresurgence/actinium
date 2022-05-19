package com.zy.actinium.data.structure.linkedlist;

/**
 * TODO
 *  链表实现队列
 * @author Neo
 * @version 1.0.0
 * @date 2021/7/27 14:40
 */
public class LinkQueue {
    private FirstLastList firstLastList;

    public LinkQueue() {
        firstLastList = new FirstLastList();
    }

    public boolean isEmpty() {
        return firstLastList.isEmpty();
    }

    public void insert(long j) {
        firstLastList.insertLast(j);
    }

    public long remove() {
        return firstLastList.deleteFirst();
    }

    public void displayQueue() {
        System.out.print("Queue (front-->rear): ");
        firstLastList.displayList();
    }
}
