package com.zy.actinium.data.structure.queue;

/**
 * TODO
 *  队列 没有nItems 计数器
 * @author Neo
 * @version 1.0.0
 * @date 2021/7/23 17:10
 */
public class QueueNoNItems {

    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;

    public QueueNoNItems(int s) {
        maxSize = s+1;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
    }

    public void insert(long j){
        if(rear == maxSize-1){
            rear = -1;
        }
        queArray[++rear] = j;
    }

    public long remove(){
        long temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        return temp;
    }

    public long peekFront(){
        return queArray[front];
    }

    public boolean isEmpty(){
        return (rear+1 == front);
    }

    private boolean isFull(){
        return (rear+2 == front || front+maxSize-2 == rear);
    }

    public int size(){
        if(rear>=front){
            return  rear-front+1;
        }else {
            return (maxSize - front) + (rear + 1);
        }
    }
}
