package com.zy.actinium.data.structure.advancedsort;

/**
 * TODO
 * 高级排序-希尔排序
 *
 * @author Neo
 * @version 1.0.0
 * @date 2021/8/17 19:27
 */
public class ShellSort {

    private long[] theArray;
    private int nElems;

    public ShellSort(int max) {
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        theArray[nElems] = value;
        nElems++;
    }

    public void display() {
        System.out.print("A=");
        for (int j = 0; j < nElems; j++) {
            System.out.print(theArray[j] + " ");
        }
        System.out.println("");
    }

    //希尔排序
    public void shellSort() {
        int inner, outer;
        long temp;

        int h = 1;

        /*
         * Knuth 间隔序列 (1,4,13,40,121,364...)
         * nElems = 10 h = 4
         */
        while (h < nElems / 3) {
            h = h * 3 + 1;
        }

        /*
         *  theArray [5,15,32,45,22,65,11,30,98,8]
         *  h = 4
         *  outer = 4   temp = 22   inner = 4   inner - h = 0   5>=22   false   no swap
         *  outer = 5   temp = 65   inner = 5   inner - h = 1   15>=65  false   no swap
         *  outer = 6   temp = 11   inner = 6   inner - h = 2   32>=11  true    swap        [5,15,11,45,22,65,32,30,98,8]
         *                          inner = 2   inner > h - 1   2>3     false   && 短路 所以不会数组越界异常
         *  outer = 7   temp = 30   inner = 7   inner - h = 3   45>=30  true    swap        [5,15,11,30,22,65,32,45,98,8]
         *                          inner = 4   inner - h = 0   5>=30   false   no swap
         *  outer = 8   temp = 98   inner = 8   inner - h = 4   22>=98  false   no swap
         *  outer = 9   temp = 8    inner = 9   inner - h = 5   65>=8   true    swap        [5,15,11,30,22,8,32,45,98,65]
         *                          inner = 5   inner - h = 1   15>=8   true    swap        [5,8,11,30,22,15,32,45,98,65]
         *                          inner = 1   inner > h - 1   1>3     false   && 短路 所以不会数组越界异常
         *
         *  theArray [5,8,11,30,22,15,32,45,98,65]
         *  h = 1
         *  outer = 1   temp = 8    inner = 1   inner - h = 0   5>=8    false   no swap
         *  outer = 2   temp = 11   inner = 2   inner - h = 1   8>=11   false   no swap
         *  outer = 3   temp = 30   inner = 3   inner - h = 2   11>=30  false   no swap
         *  outer = 4   temp = 22   inner = 4   inner - h = 3   30>=22  true    swap        [5,8,11,22,30,15,32,45,98,65]
         *              temp = 22   inner = 3   inner - h = 2   11>=22  false   no swap
         *  outer = 5   temp = 15   inner = 5   inner - h = 4   30>=15  true    swap        [5,8,11,22,15,30,32,45,98,65]
         *              temp = 15   inner = 4   inner - h = 3   22>=15  true    swap        [5,8,11,15,22,30,32,45,98,65]
         *  outer = 6   temp = 32   inner = 6   inner - h = 5   30>=32  false   no swap
         *  outer = 7   temp = 45   inner = 7   inner - h = 6   32>=45  false   no swap
         *  outer = 8   temp = 98   inner = 8   inner - h = 7   45>=98  false   no swap
         *  outer = 9   temp = 65   inner = 9   inner - h = 8   98>=65  true    swap        [5,8,11,15,22,30,32,45,65,98]
         *              temp = 65   inner = 8   inner - h = 7   45>=65  false   no swap
         * end theArray  [5,8,11,15,22,30,32,45,65,98]
         */
        while (h > 0) {
            for (outer = h; outer < nElems; outer++) {
                temp = theArray[outer];
                inner = outer;
                while (inner > h - 1 && theArray[inner - h] >= temp) {
                    theArray[inner] = theArray[inner - h];
                    inner -= h;
                }
                theArray[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }
}
