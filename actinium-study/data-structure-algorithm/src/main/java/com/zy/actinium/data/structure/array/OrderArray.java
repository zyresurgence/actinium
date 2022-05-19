package com.zy.actinium.data.structure.array;

/**
 * TODO
 * 有序数组的封装
 * @author Neo
 * @version 1.0.0
 * @date 2021/7/23 14:52
 */
public class OrderArray {

    private long[] initArr;

    private int nElems;

    public OrderArray(int max) {
        initArr = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (initArr[curIn] == searchKey) {
                return curIn;
            } else if (lowerBound > upperBound) {
                return nElems;
            } else {
                if (initArr[curIn] < searchKey) {
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
                }
            }
        }
    }

    public void insert(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (initArr[j] > value) {
                break;
            }
        }
        for (int k = nElems; k > j; k--) {
            initArr[k] = initArr[k - 1];
        }
        initArr[j] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int j = find(value);
        if (j == nElems) {
            return false;
        } else {
            for (int k = j; k < nElems; k++)
                initArr[k] = initArr[k + 1];
            nElems--;
            return true;
        }
    }

    public void display() {
        System.out.println(nElems);
        for (int j = 0; j < nElems; j++) {
            System.out.print(initArr[j] + " ");
        }
        System.out.println("");
    }
}
