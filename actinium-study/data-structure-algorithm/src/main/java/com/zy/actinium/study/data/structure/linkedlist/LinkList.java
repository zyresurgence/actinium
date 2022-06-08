package com.zy.actinium.study.data.structure.linkedlist;

/**
 * TODO
 *  链表
 * @author Neo
 * @version 1.0.0
 * @date 2021/7/26 14:41
 */
public class LinkList {
    private Link first;

    public void LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    //获取迭代器
    public ListIterator getIterator() {
        return new ListIterator(this);
    }

    //表头插入元素
    public void insertFirst(int id) {
        Link link = new Link(id);
        link.next = first;
        first = link;
    }

    //查找指定元素
    public Link find(int key) {
        Link current = first;
        while (current.dData != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    //获取头链节点
    public Link getFirst(){
        return first;
    }

    //设置头链节点
    public void setFirst(Link link) {
        first = link;
    }

    //删除指定元素
    public Link delete(int key) {
        Link current = first;
        Link previous = first;
        while (current.dData != key) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }

    //删除表头元素
    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    //展示链表元素
    public void displayList() {
        System.out.print("List(first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    //基于链表迭代器实现的数据展示
    public void displayListByIterator(){
        ListIterator iterator = getIterator();
        iterator.reset();
        long value = iterator.getCurrent().dData;
        System.out.print(value+" ");
        while (!iterator.atEnd()) {
            iterator.nextLink();
            value = iterator.getCurrent().dData;
            System.out.print(value+" ");
        }
    }

}
