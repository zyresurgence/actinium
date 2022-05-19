package com.zy.actinium.data.structure.stack;

/**
 * TODO
 * 栈
 *
 * @author Neo
 * @version 1.0.0
 * @date 2021/7/23 16:46
 */
public class StackChar {

    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackChar(int s) {
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }

    //压入
    public void push(char j) {
        stackArray[++top] = j;
    }
    //弹出
    public char pop() {
        return stackArray[top--];
    }

    //查看当前最后项
    public long peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }
}
