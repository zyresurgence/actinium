package com.zy.actinium.study.data.structure.advancedsort;

import org.junit.Test;

/**
 * TODO
 *
 * @author Neo
 * @version 1.0.0
 * @date 2021/8/17 19:32
 */
public class AdvanceSortApp {

    @Test
    public void shellSort(){
        int maxSize = 10;

        ShellSort shellSort;
        shellSort = new ShellSort(maxSize);

//        for (int i = 0; i <maxSize ; i++) {
//            long n = ((int) (Math.random() * 99));
//            shellSort.insert(n);
//        }

        shellSort.display();

        shellSort.shellSort();

        shellSort.display();


    }
}
