package com.ptl.exercise.Coding;

import java.util.*;

public class Solution {
    public static int fillWater(int[] buildings) {
        if (buildings == null || buildings.length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 1; i < buildings.length - 1; i++) { //no need 1st and last column
            int leftMax = Integer.MIN_VALUE;
            for (int k = 0; k <= i; k++) {
                leftMax = Math.max(buildings[k], leftMax);
            }
            int rightMax = Integer.MIN_VALUE;
            for (int k = i; k < buildings.length; k++) {
                rightMax = Math.max(buildings[k], rightMax);
            }
            int fill = Math.min(rightMax, leftMax) - buildings[i];
            result += fill;
        }
        return result; //should work
    }

    public static int paintCost(int[][] costs) {
        int col = costs[0].length;

        int prev1 = costs[0][0];
        int prev2 = costs[1][0];
        int prev3 = costs[2][0];
        for (int i = 1; i < col; i++) {
            int temp1 = prev1;
            int temp2 = prev2;
            int temp3 = prev3;
            prev1 = Math.min(temp2, temp3) + costs[0][i];
            prev2 = Math.min(temp1, temp3) + costs[1][i];
            prev3 = Math.min(temp1, temp2) + costs[2][i];
        }
        int min1 = Math.min(prev1, prev2);
        int result = Math.min(min1, prev3);
        return result;
    }

    public static List<List<Integer>> twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) { //count each number into a map
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) { //find pair and reduce count for both numbers
            int diff = target - nums[i];
            if (map.containsKey(diff) && map.get(diff) >= 1) {
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[i]);
                pair.add(diff);
                result.add(pair);
                map.put(diff, map.get(diff) - 1);
                map.put(nums[i], map.get(nums[i]) - 1);
            }
        }
        return result;
    }


    public static int binarySearch(int[] arr, int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearch(arr, l, mid, x);
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }


    public static int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "1+2*3+6/2";
        System.out.println(calculate(s));
    }

}
