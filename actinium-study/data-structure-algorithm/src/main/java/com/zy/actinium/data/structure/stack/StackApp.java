package com.zy.actinium.data.structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO
 *
 * @author Neo
 * @version 1.0.0
 * @date 2021/7/23 16:49
 */
public class StackApp {

    public static void main(String[] args) throws IOException{
//        StackLong stackX = new StackLong(10);
//        stackX.push(10);
//        stackX.push(20);
//        stackX.push(40);
//        stackX.push(60);
//        stackX.push(80);
//
//        while (!stackX.isEmpty()) {
//            long value = stackX.pop();
//            System.out.print(value);
//            System.out.print(" ");
//        }
//        System.out.println(" ");

        String input,output;
        while (true){
            System.out.print("Enter a string: ");
            System.out.flush();
            input = getString();
            if(input.equals("")){
                break;
            }

            Reverser reverser = new Reverser(input);
            output = reverser.doRev();
            System.out.println("Reversed: "+output);
        }

    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
