package com.ptl.exercise.caspex.glider;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Outcome_BiggestRectangle {

    public static void main(String[] args) {
        List<Integer> B = Arrays.asList(7,3,6,5,6,0,7);
        System.out.println(maxArea(B));
    }

    public static int maxArea(List<Integer> B) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int length = B.size();
        int maxArea = 0;
        for (int i = 0; i < length; i++) {
            while ((stack.peek() != -1)
                    && (B.get(stack.peek()) >= B.get(i))) {
                int currentHeight = B.get(stack.pop());
                int currentWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int currentHeight = B.get(stack.pop());
            int currentWidth = length - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }
        return maxArea;
    }
}
