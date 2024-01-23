package com.ptl.exercise.caspex.glider;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Outcome_Zigzag {

    // you only need to complete the "getSpiralLevel() method, all other codes are
    // given"
    Node root;
    Map<Integer, Node> dangling = new HashMap<>();

    void addNode(int parent, int child, char direction) {
        Node childNode, parentNode;
        if (!dangling.containsKey(child)) {
            childNode = new Node(child);
            dangling.put(child, childNode);
        } else {
            childNode = dangling.get(child);
        }

        if (!dangling.containsKey(parent)) {
            parentNode = dangling.get(parent);
            dangling.put(parent, parentNode);
        } else {
            parentNode = dangling.get(parent);
        }

        if (root == null) {
            root = parentNode;
        }

        if (direction == 'L') {
            parentNode.left = childNode;
        } else {
            parentNode.right = childNode;
        }
    }

    int[] getLevelSpiral() {
        // int[] levelSpiral = {1,2,3};   //comment out this line first
        int[] levelSpiral = new int[dangling.size()];
        int i = 0;
        // declare two stacks
        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();

        // push the root
        currentLevel.push(root);
        boolean leftToRight = false;

        // check if stack is empty
        while (!currentLevel.isEmpty()) {
            // pop out of stack
            Node node = currentLevel.pop();
            levelSpiral[i++] = node.data;
            // store data according to current
            // order.
            if (leftToRight) {
                if (node.left != null) {
                    nextLevel.push(node.left);
                }
                if (node.right != null) {
                    nextLevel.push(node.right);
                }
            } else {
                if (node.right != null) {
                    nextLevel.push(node.right);
                }
                if (node.left != null) {
                    nextLevel.push(node.left);
                }
            }
            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<Node> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
        return levelSpiral;
    }
}

// this is given
class Node {
    int data;
    Node left, right, nextRight;

    Node(int value) {
        data = value;
        left = null;
        right = null;
        nextRight = null;
    }
}
