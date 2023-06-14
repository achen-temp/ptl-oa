package com.ptl.exercise.caspex.glider;

import java.util.Arrays;

public class Outcome_MovingZerosToEnd {

    public static int[] solve(int[] nums){
        int left = 0; // Pointer to track non-zero elements

        // Move all non-zero elements to the left side of the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[left] = nums[i];
                left++;
            }
        }

        // Fill the remaining elements with zeros
        while (left < nums.length) {
            nums[left] = 0;
            left++;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{0,1,0,3,12})));
        System.out.println(Arrays.toString(solve(new int[]{0})));
    }
}
