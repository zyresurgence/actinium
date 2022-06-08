package com.zy.actinium.study.data.structure.recursion;

import org.junit.Test;

/**
 * TODO
 *  递归
 * @author Neo
 * @version 1.0.0
 * @date 2021/8/16 15:58
 */
public class BaseRecursion {


    /**
     * (n^2+n)/2
     * @param n
     * @return
     */
    public int triangle(int n){
        if (n==1) {
            return 1;
        }else {
            return (n + (triangle(n - 1)));
        }
    }

    @Test
    public void recursionOne(){
        System.out.println(triangle(4));
    }

    @Test
    public void binarySearchRecursion(){
        int maxSize = 100;
        BinarySearchRecursion binarySearchRecursion;
        binarySearchRecursion = new BinarySearchRecursion(maxSize);
        binarySearchRecursion.insert(72);
        binarySearchRecursion.insert(90);
        binarySearchRecursion.insert(45);
        binarySearchRecursion.insert(126);
        binarySearchRecursion.insert(54);
        binarySearchRecursion.insert(99);
        binarySearchRecursion.insert(144);
        binarySearchRecursion.insert(27);
        binarySearchRecursion.insert(135);
        binarySearchRecursion.insert(81);
        binarySearchRecursion.insert(18);
        binarySearchRecursion.insert(108);
        binarySearchRecursion.insert(9);
        binarySearchRecursion.insert(117);
        binarySearchRecursion.insert(63);
        binarySearchRecursion.insert(36);

        binarySearchRecursion.display();

        int searchKey = 144;
        if(binarySearchRecursion.find(searchKey) != binarySearchRecursion.size()){
            System.out.println("Found "+searchKey);
        }else {
            System.out.println("Can`t find "+searchKey);
        }
    }

    @Test
    public void mergeSortRecursion(){
        int maxSize = 100;
        MergeSortRecursion mergeSortRecursion;
        mergeSortRecursion = new MergeSortRecursion(maxSize);

        mergeSortRecursion.insert(64);
        mergeSortRecursion.insert(21);
        mergeSortRecursion.insert(33);
        mergeSortRecursion.insert(70);
        mergeSortRecursion.insert(12);
        mergeSortRecursion.insert(85);
        mergeSortRecursion.insert(44);
        mergeSortRecursion.insert(3);
        mergeSortRecursion.insert(99);
        mergeSortRecursion.insert(0);
        mergeSortRecursion.insert(108);
        mergeSortRecursion.insert(36);

        mergeSortRecursion.display();

        mergeSortRecursion.mergeSort();

        mergeSortRecursion.display();
    }


}
