package com.cafebabe.datastructure.bin;

public class Tree {
    private Node root;

    class Node {
        int iData;
        double fData;
        Node leftNode;
        Node rightNode;

        public Node(int iData, double fData) {
            this.iData = iData;
            this.fData = fData;
        }
    }

    //查找出节点
    public Node find(int key) {
        Node current = root;
        while (current.iData != key) {
            if (key < current.iData) {
                current = current.leftNode;

            } else {
                current = current.rightNode;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }


    public void insert(Node e) {

    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        //to find node to delete
        while (current.iData != key) {
            parent = current;
            if (key < current.iData) {
                isLeftChild = true;
                current = current.leftNode;
            } else {
                isLeftChild = false;
                current = current.rightNode;
            }
            // didn`t find key ,return false;
            if (current == null) {
                return false;
            }
        }

        //find node to delete
        // 1.: the node to delete has no any child node
        if (current.leftNode == null && current.rightNode == null) {
            if (current == root) {
                root = null;
            } else {
                if (isLeftChild) {
                    current.leftNode = null;
                } else {
                    current.rightNode = null;
                }

            }
        }
        //2.: the node to delete has one child node
        else if (current.rightNode == null) {   //if only had left node
            if (current == root) {
                root = current.leftNode;
            } else if (isLeftChild) {
                parent.leftNode = current.leftNode;
            } else {
                parent.rightNode = current.leftNode;
            }
        } else if (current.leftNode == null) {
            if (current == root) {
                root = current.rightNode;
            } else if (isLeftChild) {
                parent.leftNode = current.rightNode;
            } else {
                parent.rightNode = current.rightNode;
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftNode = successor;
            } else {
                parent.rightNode = successor;
            }
            successor.leftNode = current.leftNode;
        }
        return true;
    }


    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node currentNode = delNode.rightNode;
        while (currentNode != null) {
            successorParent = successor;
            successor = currentNode;
            currentNode = currentNode.leftNode;
        }
        if (successor != delNode.rightNode) {
            //中继父节点的 leftNode = 中继节点的rightNode
            successorParent.leftNode = successor.rightNode;
            //中继节点的右节点要保持 目标节点的右节点
            successor.rightNode = delNode.rightNode;
        }
        return successor;
    }
}
