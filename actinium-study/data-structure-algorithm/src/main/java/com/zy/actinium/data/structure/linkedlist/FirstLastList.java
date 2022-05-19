package com.zy.actinium.data.structure.linkedlist;

/**
 * TODO
 *  链表-双端链表
 * @author Neo
 * @version 1.0.0
 * @date 2021/7/26 17:42
 */
public class FirstLastList {

    private Link first;
    private Link last;

    public FirstLastList(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insertFirst(long dd){
        Link link = new Link(dd);

        if (isEmpty()) {
            last = link;
        }
        link.next = first;
        first = link;
    }

    public void insertLast(long dd){
        Link lastLink = new Link(dd);
        if (isEmpty()) {
            first = lastLink;
        }else{
            last.next = lastLink;
        }
        last = lastLink;
    }

    public long deleteFirst(){
        long temp = first.dData;
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.print("List(first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
