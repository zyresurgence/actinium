package com.zy.actinium.study.data.structure.linkedlist;

/**
 * TODO
 *  双向链表
 *
 * @author Neo
 * @version 1.0.0
 * @date 2021/8/23 11:42
 */
public class DoublyLinkedList {

    private DoublyLink first;
    private DoublyLink last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    //表头插入
    public void insertFirst(long dd) {
        DoublyLink newLink = new DoublyLink(dd);

        //链表为空
        if (isEmpty()) {
            //先让尾结点指向新链结点
            last = newLink;
        } else {
            //旧的first的prev 结点指向新链结点
            first.prev = newLink;

            //新结点的next指向旧first
            newLink.next = first;
        }
        //将newLink设置为新的头结点
        first = newLink;
    }

    //表尾插入
    public void insertLast(long dd) {
        DoublyLink newLink = new DoublyLink(dd);

        if (isEmpty()) {
            first = newLink;
        } else {
            //旧的last的next 结点指向新链结点
            last.next = newLink;

            //链表不为空的情况下，新结点的prev指向旧last
            newLink.prev = last;
        }
        //将newLink设置为新的尾结点
        last = newLink;
    }

    //表头删
    public DoublyLink deleteFirst() {
        DoublyLink temp = first;
        if (first.next == null) {
            last = null;
        } else {
            //将原先指向待删除结点的指针指向null
            first.next.prev = null;
        }
        //将头结点指针指向待删除结点的下一个结点
        first = first.next;
        return temp;
    }

    //表尾删
    public DoublyLink deleteLast() {
        DoublyLink temp = first;
        if (first.next == null) {
            first = null;
        } else {
            //将原先指向待删除结点的指针指向null
            last.prev.next = null;
        }
        //将头结点指针指向待删除结点的上一个结点
        last = last.prev;
        return temp;
    }

    //在指定值链结点后插入
    public boolean insertAfter(long key, long dd) {
        DoublyLink current = first;
        //定位到指定值的链结点
        while (current.dData != key) {
            current = current.next;
            if (current == null) {
                return false;
            }
        }

        DoublyLink newLink = new DoublyLink(dd);

        //是否已到达表尾 到达表尾则类似尾插
        if (current == last) {
            newLink.next = null;
            last = newLink;
        } else {
            //新的链结点newLink的next指向原先current的next指向的链结点;
            newLink.next = current.next;
            //原先链结点current指向的链结点的prev 指向现在代替原来current链结点的newLink
            current.next.prev = newLink;
        }
        //新链结点newLink的prev指向current
        newLink.prev = current;
        //原先链结点current的next 指向新的链结点newLink
        current.next = newLink;
        return true;
    }

    public DoublyLink deleteKey(long key) {
        DoublyLink current = first;
        //定位到待删除的节点current
        while (current.dData != key) {
            current = current.next;
            if (current == null) {
                return null;
            }
        }

        if (current == first) {
            //在表头就是头删直接指向结点的下一个结点
            first = current.next;
        } else {
            //待删除结点current的前一个结点 指向current的下一个结点
            current.prev.next = current.next;
        }

        if (current == last) {
            //在表尾则是尾删直接指向待删除结点的上一个结点
            last = current.prev;
        } else {
            //待删除结点current的后一个结点的prev指向current的前一个结点
            current.next.prev = current.prev;
        }
        return current;
    }

    //从开头遍历到结束
    public void displayForward() {
        System.out.print("List (first-->last): ");
        DoublyLink current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    //从结束反向遍历到开头
    public void displayBackward() {
        System.out.print("List (last-->first): ");
        DoublyLink current = last;
        while (current != null) {
            current.displayLink();
            current = current.prev;
        }
        System.out.println("");
    }

}
