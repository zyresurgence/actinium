package com.zy.actinium.data.structure.binarytree;

/**
 * TODO
 *  二叉树-节点
 * @author Neo
 * @version 1.0.0
 * @date 2021/8/18 14:24
 */
public class Node {
    public int iData;
    public double dData;
    public Node leftChild;
    public Node rightChild;

    public void displayNode(){
        System.out.println("{"+iData+","+dData+"}");
    }



}
