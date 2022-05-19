package com.zy.actinium.data.structure.sort;

/**
 * TODO
 * 冒泡排序 交换次数(O(N^2)) 比较次数(o(N^2))
 *
 * @author Neo
 * @version 1.0.0
 * @date 2021/7/23 15:52
 */
public class BubbleSort {
    private long[] initArr;
    private int nElems;

    public BubbleSort(int max) {
        initArr = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        initArr[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(initArr[i] + " ");
        }
        System.out.println("");
    }

    public void bubbleSort() {
        int out, in;
        for (out = nElems - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (initArr[in] > initArr[in + 1]) {
                    swap(in, in + 1);
                }
            }
        }
    }

    public void swap(int one, int two) {
        long temp = initArr[one];
        initArr[one] = initArr[two];
        initArr[two] = temp;
    }
}
