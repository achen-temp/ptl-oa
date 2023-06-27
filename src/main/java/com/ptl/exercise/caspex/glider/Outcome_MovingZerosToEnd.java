package com.ptl.exercise.caspex.glider;

import java.util.Arrays;
import java.util.List;

public class Outcome_MovingZerosToEnd {

    public static List<Integer> solve(List<Integer> ar){
        int left = 0; // Pointer to track non-zero elements

        // Move all non-zero elements to the left side of the array
        for (int i = 0; i < ar.size(); i++) {
            if (ar.get(i) != 0) {
                ar.set(left, ar.get(i));
                left++;
            }
        }

        // Fill the remaining elements with zeros
        while (left < ar.size()) {
            ar.set(left, 0);
            left++;
        }
        return ar;
    }

    public static void main(String[] args) {
        List<Integer> ar1 = Arrays.asList(0,1,0,3,12);
        System.out.println(solve(ar1));
    }
}
