package com.zy.actinium.data.structure.queue;

/**
 * TODO
 * 队列
 *
 * @author Neo
 * @version 1.0.0
 * @date 2021/7/23 17:10
 */
public class Queue {

    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(long j){
        if(rear == maxSize-1){
            rear = -1;
        }
        queArray[++rear] = j;
        nItems++;
    }

    public long remove(){
        long temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public long peekFront(){
        return queArray[front];
    }

    public boolean isEmpty(){
        return (nItems == 0);
    }

    private boolean isFull(){
        return (nItems == maxSize);
    }

    public int size(){
        return nItems;
    }
}
