package com.zy.actinium.study.data.structure.sort;

/**
 * TODO
 * 插入排序 交换次数(O(N)) 比较次数(o(N^2))
 *
 * @author Neo
 * @version 1.0.0
 * @date 2021/7/23 15:52
 */
public class InsertSort {
    private long[] initArr;
    private int nElems;

    public InsertSort(int max) {
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
    public void insertSort() {
        int in, out;
        for (out = 1; out < nElems; out++) {
            long temp = initArr[out];
            in = out;
            while (in > 0 && initArr[in - 1] >= temp) {
                initArr[in] = initArr[in - 1];
                --in;
            }
            initArr[in] = temp;
        }
    }
 }
