package com.ptl.exercise.redolent;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Algo_ArrayReduction {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4, 6, 8);
        int result = reductionCost(nums);
        System.out.println(result);
    }

    public static int reductionCost(List<Integer> num) {
        if (num == null || num.size() <= 1) {
            return 0;
        }

        Queue<Integer> queue = new PriorityQueue<>();
        for (int n : num) {
            queue.add(n);
        }

        int result = 0;
        while (queue.size() >= 2) {
            int num1 = queue.poll();
            int num2 = queue.poll();
            result += num1 + num2;
            queue.add(num1 + num2);
        }
        return result;
    }
}
