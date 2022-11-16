package com.ptl.exercise.Paypal;

import java.util.Stack;

public class Coding {

    //two strings, # is to remove previous character
    //check if two strings after process #, are equal
    public static int compareStrings(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return 0;
        }
        Stack<Character> stack1 = new Stack();
        Stack<Character> stack2 = new Stack();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (c == '#') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else {
                stack1.push(c);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (c == '#') {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            } else {
                stack2.push(c);
            }
        }
        if (stack1.size() != stack2.size()) {
            return 0;
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.pop() != stack2.pop()) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(compareStrings("yf#c#", "yy#k#pp##"));
    }

}
