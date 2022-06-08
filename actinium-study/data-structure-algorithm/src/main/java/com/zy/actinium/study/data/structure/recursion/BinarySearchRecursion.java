package com.zy.actinium.study.data.structure.recursion;

/**
 * TODO
 * 递归二分查找
 *
 * @author Neo
 * @version 1.0.0
 * @date 2021/8/16 17:17
 */
public class BinarySearchRecursion {
    private long[] a;
    private int nElems;

    public BinarySearchRecursion(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        return recFind(searchKey, 0, nElems - 1);
    }

    private int recFind(long searchKey, int lowerBound, int upperBound) {
        int curIn;
        curIn = (lowerBound + upperBound) / 2;
        //找到值就返回
        if (a[curIn] == searchKey) {
            return curIn;
        //到达了数组的边界 意味着未找到元素，所以在判定最终结果要加上 返回值不等于数组的length
        } else if (lowerBound > upperBound) {
            return nElems;
        } else {
            if (a[curIn] < searchKey) {
                //向右
                return recFind(searchKey, curIn + 1, upperBound);
            } else {
                //向左
                return recFind(searchKey, lowerBound, curIn - 1);
            }
        }
    }

    public void insert(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] > value) {
                break;
            }
        }
        for (int k = nElems; k > j; k--) {
            a[k] = a[k - 1];
        }
        a[j] = value;
        nElems++;
    }

    public void display() {
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println("");
    }
}
