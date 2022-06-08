package com.zy.actinium.study.data.structure.binarytree;

import java.util.Stack;

/**
 * TODO
 *  二叉树
 * @author Neo
 * @version 1.0.0
 * @date 2021/8/18 16:35
 */
public class Tree {

    private Node root;

    public Tree() {
        root = null;
    }

    //查找元素
    public Node find(int key) {
        Node current = root;
        while (current.iData != key) {
            //根据节点大小向左右找
            if (key < current.iData) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }

            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(int id, double dd) {
        Node newNode = new Node();
        newNode.iData = id;
        newNode.dData = dd;

        //判定根节点是否创建
        if (root == null) {
            //未创建根节点，将该插入数据作为根节点
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                /*
                 * 从根节点对应条件下的子节点进行比较 小于放到左边 大于放到右边
                 *               55
                 *            /      \
                 *           40      60
                 *          /  \    /  \
                 *         35  45  58  65
                 */
                if (id < current.iData) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        //先遍历所有节点找到对应的数据所在的子节点
        while (current.iData != key) {
            parent = current;
            if (key < current.iData) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }

            if (current == null) {
                return false;
            }
        }

        /*
         * 该节点没有子节点
         * 从根节点对应条件下的子节点进行比较 小于放到左边 大于放到右边
         *               55
         *            /      \
         *           40      60
         *          /  \    /  \
         *         35  45  58  65
         */
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }

        /*
         * 该节点没有右子节点
         * 从根节点对应条件下的子节点进行比较 小于放到左边 大于放到右边
         *               55
         *            /      \
         *           40      60
         *          /       /  \
         *         35      58  65
         */
        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        /*
         * 该节点没有左子节点
         * 从根节点对应条件下的子节点进行比较 小于放到左边 大于放到右边
         *               55
         *            /      \
         *           40      60
         *            \     /  \
         *            45   58  65
         */
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        /*
         * 该节点下有两个子节点
         * 从根节点对应条件下的子节点进行比较 小于放到左边 大于放到右边
         *               55
         *            /      \
         *           40      60
         *          /  \    /  \
         *         35  45  58  65
         */
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
                successor.rightChild = current.rightChild;
            } else {
                parent.rightChild = successor;
                successor.leftChild = current.leftChild;
            }
        }
        return true;
    }

    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }

        if (successor != delNode.leftChild) {
            successorParent.rightChild = successor.leftChild;
            successor.leftChild = delNode.leftChild;
        }

        return successor;
    }

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.print("\nPreorder Traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.print("\nInorder Traversal: ");
                inorder(root);
                break;
            case 3:
                System.out.print("\nPostOrder Traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }

    private void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.iData+" ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void inorder(Node localRoot) {
        if (localRoot != null) {
            inorder(localRoot.leftChild);
            System.out.print(localRoot.iData+" ");
            inorder(localRoot.rightChild);
        }
    }

    private void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.iData+" ");
        }
    }

    public void displayTree(){
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("..........................................");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++) {
                System.out.print(" ");
            }
            while (globalStack.isEmpty() == false) {
                Node temp = ((Node) globalStack.pop());
                if (temp != null) {
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                }else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        }
    };
}
