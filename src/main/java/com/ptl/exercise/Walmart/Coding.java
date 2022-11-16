package com.ptl.exercise.Walmart;

import java.util.*;
import java.util.stream.Collectors;

public class Coding {

    //9/30- Tracy Group - 中国人tao?
    //evaluate "1+2" only + and -
    //followup: evaluate "1+2*4/3"  only +,-,*,/
    public static int calculate(String s) {

        //!!! if there is () in equation, we need stack, otherwise not needed
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0; //numbers
        int result = 0;
        int sign = 1;  // 1 means positive, -1 means negative

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = 10 * num + (int) (ch - '0');
            } else if (ch == '+') {
                result += sign * num; //we see +, evalute all expression on left of this +
                sign = 1; //mark this + for next round
                num = 0; //reset number for next round
            } else if (ch == '-') {
                result += sign * num;
                sign = -1;
                num = 0;
            } else if (ch == '(') {

                // Push the result and sign on to the stack, for later
                // We push the result first, then sign
                stack.push(result);
                stack.push(sign);

                // Reset operand and result, as if new evaluation begins for the new sub-expression
                sign = 1;
                result = 0;

            } else if (ch == ')') {

                // Evaluate the expression to the left
                // with result, sign and operand
                result += sign * num;

                // ')' marks end of expression within a set of parenthesis
                // Its result is multiplied with sign on top of stack
                // as stack.pop() is the sign before the parenthesis
                result *= stack.pop();

                // Then add to the next operand on the top.
                // as stack.pop() is the result calculated before this parenthesis
                // (operand on stack) + (sign on stack * (result from parenthesis))
                result += stack.pop();

                // Reset the operand
                num = 0;
            }
        }
        return result + (sign * num);
    }

    //FOLLOW UP: evaluate + - * / with no
    public static int calculate2(String s) {
        if (s == null || s.isEmpty()) return 0;
        int length = s.length();
        int currNum = 0, prevNum = 0, result = 0;
        char operation = '+';
        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currNum = (currNum * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length - 1) {
                if (operation == '+' || operation == '-') {
                    result += prevNum;
                    prevNum = (operation == '+') ? currNum : -currNum;
                } else if (operation == '*') {
                    prevNum = prevNum * currNum;
                } else if (operation == '/') {
                    prevNum = prevNum / currNum;
                }
                operation = currentChar;
                currNum = 0;
            }
        }
        result += prevNum;
        return result;
    }


    //Jessica + SELINA first round -- 10/5/2022
    public static int compare(String a, String b) {
        int result = 0;
        if (a.charAt(0) == '-') {
            if (b.charAt(0) == '-') {
                result = b.substring(1).compareTo(a.substring(1));
            } else {
                result = -1;
            }
        } else {
            if (b.charAt(0) == '-') {
                result = 1;
            } else {
                result = a.compareTo(b);
            }
        }
        if (result < 0) {
            System.out.println("a < b");
        } else if (result == 0) {
            System.out.println("a = b");
        } else {
            System.out.println("a > b");
        }
        return result;
    }

    public static String findNthLargestUpc(Map<Integer, List<String>> storeGTINMap, int n) {
        PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> compare(a, b));
        for (int store : storeGTINMap.keySet()) {
            List<String> list = storeGTINMap.get(store);
            for (String upc : list) {
                if (queue.size() < n) {
                    queue.add(upc);
                } else {
                    if (compare(upc, queue.peek()) > 0) {
                        queue.poll();
                        queue.add(upc);
                    }
                }
            }
        }
        if (queue.size() < n) {
            return "";
        } else {
            return queue.peek();
        }
    }

    //find longest common Postfix
    public static String longestCommonPostfix(String[] strs) {
        String result = "";
        if (strs == null || strs.length == 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(strs[0].length() - i - 1);
            boolean foundMismatch = false;
            for (int j = 1; j < strs.length; j++) {
                int index = strs[j].length() - i - 1;
                if (index < 0 || strs[j].charAt(index) != c) {
                    foundMismatch = true;
                    break;
                }
            }
            if (foundMismatch) {
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }

    public static String solve(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i % 2 == 0) {
                sb.append(c);
            } else {
                char upperC = Character.toUpperCase(c);
                char temp = (char) (upperC + 3);
                char newc = Character.toUpperCase(temp);
                if (upperC == 'X') {
                    newc = 'A';
                } else if (upperC == 'Y') {
                    newc = 'B';
                } else if (upperC == 'Z') {
                    newc = 'C';
                }
                sb.append(newc);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "zEalOY";
        System.out.println(solve(s));
    }
}
