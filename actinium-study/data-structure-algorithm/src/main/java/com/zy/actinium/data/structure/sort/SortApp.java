package com.zy.actinium.data.structure.sort;

/**
 * TODO
 *
 * @author Neo
 * @version 1.0.0
 * @date 2021/7/23 15:59
 */
public class SortApp {
    public static void main(String[] args) {
        int maxSize = 100;
//        BubbleSort array = new BubbleSort(maxSize);
//        SelectSort array = new SelectSort(maxSize);
        InsertSort array = new InsertSort(maxSize);
        array.insert(77);
        array.insert(99);
        array.insert(44);
        array.insert(55);
        array.insert(22);
        array.insert(88);
        array.insert(11);
        array.insert(00);
        array.insert(66);
        array.insert(33);


        array.display();

        array.insertSort();

        array.display();

    }
}
