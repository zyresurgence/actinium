package com.zy.actinium.study.data.structure.queue;

import org.junit.Test;

/**
 * TODO
 *
 * @author Neo
 * @version 1.0.0
 * @date 2021/7/23 17:14
 */
public class QueueApp {

   @Test
   public void Queue(){
       Queue queue = new Queue(5);
       queue.insert(10);
       queue.insert(20);
       queue.insert(30);
       queue.insert(40);

       queue.remove();
       queue.remove();
       queue.remove();

       queue.insert(50);
       queue.insert(60);
       queue.insert(70);
       queue.insert(80);


       while (!queue.isEmpty()) {
           long n = queue.remove();
           System.out.print(n);
           System.out.print(" ");
       }
       System.out.println("");
   }

    @Test
    public void PriorityQueue(){
        PriorityQueue priorityQueue = new PriorityQueue(5);
        priorityQueue.insert(30);
        priorityQueue.insert(50);
        priorityQueue.insert(10);
        priorityQueue.insert(40);
        priorityQueue.insert(20);


        while (!priorityQueue.isEmpty()){
            long item = priorityQueue.remove();
            System.out.print(item+" ");
        }
        System.out.println("");
    }
}
