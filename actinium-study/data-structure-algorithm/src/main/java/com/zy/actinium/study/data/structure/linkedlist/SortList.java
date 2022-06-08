package com.zy.actinium.study.data.structure.linkedlist;

/**
 * TODO
 *  有序链表
 * @author Neo
 * @version 1.0.0
 * @date 2021/7/27 14:52
 */
public class SortList {
    private Link first;

    public SortList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insert(long key) {

        // 1.新结点
        Link newLink = new Link(key);

        // 2.在链表上移动时需要一个previous的引用，用于把前一个链结点的next字段指向新的节点；
        // 3.新结点创建之后，将current的变量设为first然后将previous的值设为null，用与判断是否仍在表头；
        Link previous = null;
        Link current = first;

        // 4.使用while循环判断，当关键值dData不再小于待插入的链结点的关键值key，同时current不为null（到达表尾，或者链表是空的）；
        while (current != null && key > current.dData) {
            previous = current;
            current = current.next;
        }

        // 5.当while循环结束，current可能会在表头、表中、或者表尾、也有可能链表是空的；
        // 6.current在表头则previous的值为null，直接将first指向新的链结点；
        if (previous == null) {
            first = newLink;
          // 7.current在表中或者表尾则使用previous的next字段指向新的链结点；
        } else {
            previous.next = newLink;
        }

        // 8.无论什么情况都要让新链结点的next字段指向current。在表头或者表中指向下一个节点，在表尾则current为null,指向null；
        newLink.next = current;
    }

    public Link remove() {
        Link temp = first;
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
