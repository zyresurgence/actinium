package com.zy.actinium.data.structure.linkedlist;

/**
 * TODO
 *  链表实现栈
 * @author Neo
 * @version 1.0.0
 * @date 2021/7/27 14:40
 */
public class LinkStack {
    private LinkList linkList;

    public LinkStack() {
        linkList = new LinkList();
    }

    //单链表的调用
    public void push(int j) {
        linkList.insertFirst(j);
    }

    public Link pop() {
        return linkList.deleteFirst();
    }

    public boolean isEmpty() {
        return linkList.isEmpty();
    }

    public void displayStack() {
        System.out.print("Stack (top-->bottom): ");
        linkList.displayList();
    }

}