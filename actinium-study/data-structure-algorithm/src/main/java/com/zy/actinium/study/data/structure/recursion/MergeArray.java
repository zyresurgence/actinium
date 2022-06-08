package com.zy.actinium.study.data.structure.recursion;

import java.util.Arrays;

/**
 * TODO
 *  合并有序数组
 * @author Neo
 * @version 1.0.0
 * @date 2021/9/23 17:06
 */
public class MergeArray {


    public static void main(String[] args) {
        int[] arrayA = {5, 20, 32, 45, 66};
        int[] arrayB = {1, 35, 48, 63, 99};
        int[] arrayC = new int[10];
        merge(arrayA, arrayA.length, arrayB, arrayB.length, arrayC);
    }


    /**
     * merge A,B to C
     *
     * @param arrayA
     * @param sizeA
     * @param arrayB
     * @param sizeB
     * @param arrayC
     */
    public static void merge(int[] arrayA, int sizeA, int[] arrayB, int sizeB, int[] arrayC) {

        int dexA = 0, dexB = 0, dexC = 0;

        //将 arrayA,arrayB中 较小的数据项复制到arrayC
        while (dexA < sizeA && dexB < sizeB) {
            if (arrayA[dexA] < arrayB[dexB]) {
                arrayC[dexC++] = arrayA[dexA++];
            } else {
                arrayC[dexC++] = arrayB[dexB++];
            }
        }

        while (dexA < sizeA) {
            arrayC[dexC++] = arrayA[dexA++];
        }

        while (dexB < sizeB) {
            arrayC[dexC++] = arrayB[dexB++];
        }

        System.out.println("arrayA: " + Arrays.toString(arrayA));
        System.out.println("arrayB: " + Arrays.toString(arrayB));
        System.out.println("arrayC: " + Arrays.toString(arrayC));

    }

}
