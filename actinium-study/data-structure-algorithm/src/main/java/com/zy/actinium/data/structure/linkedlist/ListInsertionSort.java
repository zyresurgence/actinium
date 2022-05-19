package com.zy.actinium.data.structure.linkedlist;

/**
 * TODO
 * 链表-链表插入排序
 *
 * @author Neo
 * @version 1.0.0
 * @date 2021/8/23 10:54
 */
public class ListInsertionSort {

    private Link first;

    public ListInsertionSort(Link[] linkArr) {
        first = null;
        for (int i = 0; i < linkArr.length; i++) {
            insert(linkArr[i]);
        }
    }

    public void insert(Link link) {
        Link previous = null;
        Link current = first;

        while (current != null && link.dData > current.dData) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            first = link;
        } else {
            previous.next = link;
        }

        link.next = current;
    }

    public Link remove() {
        Link temp = first;
        first = first.next;
        return temp;
    }

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

    public void displayList() {
        System.out.print("List(first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }

}
