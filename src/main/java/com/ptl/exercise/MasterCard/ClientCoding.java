package com.ptl.exercise.MasterCard;

import java.util.*;

class AndySong_TechClub{

    //print foo is divisible by 2, print bar if divisible by 3,
    //print foo bar if divisible by both 2 and 3.
    public static void printNumber(int num){
        if(num % 2 == 0 && num%3 == 0){
            System.out.println( num + " --- foo bar");
        }else if(num % 2 == 0){
            System.out.println(num + " --- foo");
        }else if(num % 3 == 0){
            System.out.println(num + " --- bar");
        }else{
            System.out.println(num);
        }
    }

    public static void main(String[] args){
        for(int i =0; i < 100; i++){
            printNumber(i);
        }
    }


}

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
