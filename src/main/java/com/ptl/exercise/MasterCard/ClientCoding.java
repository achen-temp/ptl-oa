package com.ptl.exercise.MasterCard;

import java.util.Stack;

public class ClientCoding {

    //a string contains letters and all types of parenthesis,
    //valid if the parenthesis are valid pairs
    public boolean validParens(String s) {
        if(s == null || s.length() <= 1){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        String parens = "(){}[]";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(parens.indexOf(c) < 0){ //other characters
                continue;
            }else if (c == '(') {
                stack.push(')');
            }else if (c == '{') {
                stack.push('}');
            }else if (c == '[') {
                stack.push(']');
            }else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
