package com.zy.actinium.data.structure.stack;

/**
 * TODO
 * 单词逆序
 * @author Neo
 * @version 1.0.0
 * @date 2021/7/23 16:53
 */
public class Reverser {
    private String input;
    private String output;

    public Reverser(String in) {
        input = in;
    }

    public String doRev(){
        int stackSize = input.length();
        StackChar stackX = new StackChar(stackSize);

        for (int i = 0; i <stackSize ; i++) {
            char ch = input.charAt(i);
            stackX.push(ch);
        }
        output = "";
        while (!stackX.isEmpty()){
            char ch = stackX.pop();
            output = output+ch;
        }
        return output;
    }
}
