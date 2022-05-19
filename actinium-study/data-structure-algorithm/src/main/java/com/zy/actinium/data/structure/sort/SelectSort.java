package com.zy.actinium.data.structure.sort;

/**
 * TODO
 * 选择排序 交换次数(O(N)) 比较次数(o(N^2))
 *
 * @author Neo
 * @version 1.0.0
 * @date 2021/7/23 15:52
 */
public class SelectSort {
    private long[] initArr;
    private int nElems;

    public SelectSort(int max) {
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

    //排序
    public void selectSort() {
        int out, in, min;
        for (out = 0; out < nElems - 1; out++) {
            //每做一次循环就减少一次循环
            min = out;
            for (in = out + 1; in < nElems; in++) {
                if (initArr[in] < initArr[min]) {
                    min = in;
                }
                swap(out, min);
            }
        }
    }

    //换位
    public void swap(int one, int two) {
        long temp = initArr[one];
        initArr[one] = initArr[two];
        initArr[two] = temp;
    }
}
