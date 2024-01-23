package com.ptl.exercise.apple;

public class Spencer {
    //1. given integer array, write code to find sum

    //2. given binary tree left node, right node, find their root
    public static int findCommonAncestor(Node root, int leftKey, int rightKey){
        Node cursor = root;
        while(cursor != null){
            if(cursor.key < leftKey && cursor.key < rightKey){
                cursor = cursor.right;
            }else if(cursor.key > leftKey && cursor.key > rightKey){
                cursor = cursor.left;
            }else{
                return cursor.key;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(90);
        root.left.left = new Node(25);
        root.left.right = new Node(35);
        root.right.left = new Node(80);
        root.right.right = new Node(100);

        System.out.println(findCommonAncestor(root, 25, 35));
    }
}

class Node{
    int key;
    Node left;
    Node right;
    public Node(int k){
        this.key = k;
    }
}
