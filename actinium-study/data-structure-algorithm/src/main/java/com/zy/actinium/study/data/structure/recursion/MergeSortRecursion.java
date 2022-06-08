package com.zy.actinium.study.data.structure.recursion;

/**
 * TODO
 *  递归 归并排序
 * @author Neo
 * @version 1.0.0
 * @date 2021/8/16 17:45
 */
public class MergeSortRecursion {

    private long[] theArray;
    private int nElems;

    public MergeSortRecursion(int max){
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value){
        theArray[nElems] = value;
        nElems++;
    }

    public void display(){
        for (int j = 0; j < nElems; j++) {
            System.out.print(theArray[j]+" ");
        }
        System.out.println("");
    }

    public void mergeSort(){
        //工作空间
        long[] workSpace = new long[nElems];
        //归并排序
        recMergeSort(workSpace, 0, nElems - 1);
    }

    /**
     *
     * @param workSpace     工作空间
     * @param lowerBound    最小边界
     * @param upperBound    最大边界
     *
     *  数组长度为2的指数
     *
     *     64,21,33,70,12,85,44,3
     *
     *  1. 21,64
     *  2.       33,70
     *  3. 21,33,64,70
     *  4.             12,85
     *  5.                  3,44
     *  6.             3,12,44,85
     *  7. 3,12,21,33,44,64,70,85
     *
     *  数组长度不是2的指数
     *
     *      64,21,33,70,12,85,44,3,99,0,108,36
     *
     *  1.  21,64
     *  2.  21,33,64
     *  3.          12,70
     *  4.          12,70,85
     *  5.                  3,44
     *  6.                  3,44,99
     *  7.                         0,108
     *  8.                         0,36,108
     *  9.  12,21,33,64,70,85
     *  10.                   0,3,36,44,99,108
     *  11. 0,3,12,21,33,36,44,64,70,85,99,108
     */
    public void recMergeSort(long[] workSpace,int lowerBound,int upperBound){
        //空数组
        if (lowerBound==upperBound) {
            return;
        }else {
            //拆分点
            int mid = (lowerBound + upperBound) / 2;
            //左边
            recMergeSort(workSpace,lowerBound,mid);
            //右边
            recMergeSort(workSpace,mid+1,upperBound);
            //左右归并
            merge(workSpace, lowerBound, mid + 1, upperBound);
        }

    }

    /**
     * @param workSpace     工作空间
     * @param lowPtr        低指针
     * @param highPtr       高指针
     * @param upperBound    最大边界
     */
    private void merge(long[] workSpace,int lowPtr,int highPtr,int upperBound){
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;

        //把较小的数移动到新数组
        while (lowPtr<=mid && highPtr <=upperBound){
            if (theArray[lowPtr]<theArray[highPtr]) {
                workSpace[j++] = theArray[lowPtr++];
            }else {
                workSpace[j++] = theArray[highPtr++];
            }
        }

        //把左边剩余的数移到新数组
        while (lowPtr<=mid){
            workSpace[j++] = theArray[lowPtr++];
        }

        //把右边剩余的数移到新数组
        while (highPtr<=upperBound){
            workSpace[j++] = theArray[highPtr++];
        }

        //把新数组的数覆盖到工作数组
        for (j = 0; j <n ; j++) {
            theArray[lowerBound + j] = workSpace[j];
        }
    }
}
