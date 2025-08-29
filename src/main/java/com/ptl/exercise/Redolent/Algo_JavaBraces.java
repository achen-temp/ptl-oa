package com.ptl.exercise.redolent;

import java.util.Stack;

public class Algo_JavaBraces {
    
}

class Parser{
    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') return "false";
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') return "false";
            }
        }

        return stack.isEmpty() ? "true" : "false";
    }

}
