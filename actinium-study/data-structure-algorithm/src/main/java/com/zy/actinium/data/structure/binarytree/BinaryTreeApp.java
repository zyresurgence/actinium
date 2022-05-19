package com.zy.actinium.data.structure.binarytree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO
 *
 * @author Neo
 * @version 1.0.0
 * @date 2021/8/19 16:59
 */
public class BinaryTreeApp {

    public static void main(String[] args) throws IOException {

        int value;

        Tree tree = new Tree();
        tree.insert(50, 1.5);
        tree.insert(25, 1.2);
        tree.insert(75, 1.7);
        tree.insert(12, 1.5);
        tree.insert(37, 1.2);
        tree.insert(43, 1.7);
        tree.insert(30, 1.5);
        tree.insert(33, 1.2);
        tree.insert(87, 1.7);
        tree.insert(93, 1.5);
        tree.insert(97, 1.5);
        tree.insert(85, 1.5);


        while (true) {
            System.out.print("Enter first letter of show, ");
            System.out.print("insert,find,delete,or traverse: ");

            int choice = getChar();

            switch (choice) {
                case 's':
                    tree.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    tree.insert(value, value + 0.9);
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    Node found = tree.find(value);
                    if (found != null) {
                        System.out.print("Found: ");
                        found.displayNode();
                        System.out.println();
                    } else {
                        System.out.print("Could not find ");
                        System.out.println(value);
                    }
                    break;
                case 'd':
                    System.out.print("Enter value to delete: ");
                    value = getInt();
                    boolean didDelete = tree.delete(value);
                    if (didDelete) {
                        System.out.println("Deleted " + value);
                    } else {
                        System.out.println("Cloud not delete" + value);
                    }
                    break;
                case 't':
                    System.out.print("Enter type 1,2 or 3: ");
                    value = getInt();
                    tree.traverse(value);
                    break;
                default:
                    System.out.println("Invalid entry");
            }

        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }


    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);

    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

}
