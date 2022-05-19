package com.zy.actinium.data.structure.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.junit.Test;

/**
 * TODO
 *
 * @author Neo
 * @version 1.0.0
 * @date 2021/7/26 14:52
 */
public class LinkListApp {

    @Test
    public void linkList() {
        LinkList linkList = new LinkList();
        linkList.insertFirst(22);
        linkList.insertFirst(44);
        linkList.insertFirst(66);
        linkList.insertFirst(88);

        linkList.displayList();

        while (!linkList.isEmpty()) {
            Link link = linkList.deleteFirst();
            System.out.print("Deleted ");
            link.displayLink();
            System.out.println("");
        }
        linkList.displayList();
    }

    @Test
    public void linkList2() {
        LinkList linkList = new LinkList();
        linkList.insertFirst(22);
        linkList.insertFirst(44);
        linkList.insertFirst(66);
        linkList.insertFirst(88);

        linkList.displayList();

        Link link = linkList.find(44);

        if (link != null) {
            System.out.println("Found link with key " + link.dData);
        } else {
            System.out.println("Can`t find link");
        }

        Link d = linkList.delete(66);

        if (d != null) {
            System.out.println("Delete link with key " + d.dData);
        } else {
            System.out.println("Can`t delete link");
        }

        linkList.displayList();
    }

    @Test
    public void firstLastList() {
        FirstLastList linkList = new FirstLastList();
        linkList.insertFirst(22);
        linkList.insertFirst(44);
        linkList.insertFirst(66);

        linkList.insertLast(11);
        linkList.insertLast(33);
        linkList.insertLast(55);

        linkList.displayList();

        linkList.deleteFirst();
        linkList.deleteFirst();

        linkList.displayList();


    }

    @Test
    public void linkStack() {
        LinkStack linkStack = new LinkStack();
        linkStack.push(11);
        linkStack.push(22);

        linkStack.displayStack();

        linkStack.push(33);
        linkStack.push(44);
        linkStack.displayStack();

        linkStack.pop();
        linkStack.pop();
        linkStack.displayStack();
    }

    @Test
    public void linkQueue() {

        LinkQueue linkQueue = new LinkQueue();
        linkQueue.insert(20);
        linkQueue.insert(40);

        linkQueue.displayQueue();

        linkQueue.insert(60);
        linkQueue.insert(80);

        linkQueue.displayQueue();

        linkQueue.remove();
        linkQueue.displayQueue();

        linkQueue.remove();
        linkQueue.displayQueue();
    }

    @Test
    public void sortList() {

        SortList sortList = new SortList();
        sortList.insert(20);
        sortList.insert(40);


        sortList.displayList();

        sortList.insert(10);
        sortList.insert(30);
        sortList.insert(50);

        sortList.displayList();

        sortList.remove();
        sortList.displayList();


    }

    @Test
    public void listInsertionSort(){

        int size = 10;

        Link[] links = new Link[size];

        System.out.print("Unsorted array: ");
        for (int i = 0; i < size; i++) {
            int n = ((int) (Math.random() * 99));
            Link newLink = new Link(n);
            links[i] = newLink;
            System.out.print(links[i].dData+" ");
        }

        System.out.println("");

        ListInsertionSort listInsertionSort = new ListInsertionSort(links);
        System.out.print("Sort Array: ");
        for (int i = 0; i < size; i++) {
            links[i] = listInsertionSort.remove();
            System.out.print(links[i].dData +" ");
        }
    }

    @Test
    public void doublyLinkList(){
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertFirst(22);
        doublyLinkedList.insertFirst(44);
        doublyLinkedList.insertFirst(66);

        doublyLinkedList.insertLast(11);
        doublyLinkedList.insertLast(33);
        doublyLinkedList.insertLast(55);

        doublyLinkedList.displayForward();
        doublyLinkedList.displayBackward();

        doublyLinkedList.deleteFirst();
        doublyLinkedList.deleteLast();
        doublyLinkedList.deleteKey(11);

        doublyLinkedList.displayForward();

        doublyLinkedList.insertAfter(22,77);
        doublyLinkedList.insertAfter(33,88);

    }

    @Test
    public void displayLinkListByIterator(){
        LinkList linkList = new LinkList();
        linkList.insertFirst(20);
        linkList.insertFirst(40);
        linkList.insertFirst(660);
        linkList.insertFirst(80);

        linkList.displayListByIterator();
    }

    @Test
    public void deleteInIterator(){
        LinkList linkList = new LinkList();
        ListIterator listIterator = linkList.getIterator();

        listIterator.insertAfter(21);
        listIterator.insertAfter(40);
        listIterator.insertAfter(30);
        listIterator.insertAfter(7);
        listIterator.insertAfter(45);

        linkList.displayList();

        listIterator.reset();

        Link link = listIterator.getCurrent();
        if (link.dData % 3 == 0) {
            listIterator.deleteCurrent();
        }
        while (!listIterator.atEnd()) {
            listIterator.nextLink();
            link = listIterator.getCurrent();
            if (link.dData % 3 == 0) {
                listIterator.deleteCurrent();
            }
        }

        linkList.displayListByIterator();
    }


    public static void main(String[] args) throws IOException {
        LinkList linkList = new LinkList();
        ListIterator listIterator = linkList.getIterator();
        long value;
        listIterator.insertAfter(20);
        listIterator.insertAfter(40);
        listIterator.insertAfter(80);
        listIterator.insertBefore(60);


        while (true) {
            System.out.print("Enter first letter of show,reset, ");
            System.out.print("next,get,before,after,delete: ");
            System.out.flush();
            int choice = getChar();
            switch (choice) {
                case 's':
                    if (!linkList.isEmpty()) {
                        linkList.displayList();
                    } else {
                        System.out.println("List is empty");
                    }
                    break;
                case 'r':
                    listIterator.reset();
                    break;
                case 'n':
                    if (!linkList.isEmpty() && !listIterator.atEnd()) {
                        listIterator.nextLink();
                    } else {
                        System.out.println("Can`t go to next link");
                    }
                    break;
                case 'g':
                    if (!linkList.isEmpty()) {
                        value = listIterator.getCurrent().dData;
                        System.out.println("Returned " + value);
                    } else {
                        System.out.println("List is empty");
                    }
                    break;
                case 'b':
                    System.out.print("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    listIterator.insertBefore(value);
                    break;
                case 'a':
                    System.out.print("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    listIterator.insertAfter(value);

                    break;
                case 'd':
                    if (!linkList.isEmpty()) {
                        value = listIterator.deleteCurrent();
                        System.out.println("Deleted " + value);
                    } else {
                        System.out.println("Can`t delete");
                    }
                default:
                    System.out.println("Invalid entry");
            }

        }
    }



    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }


    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);

    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }



}
