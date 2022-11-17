package com.ptl.exercise.HCL;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Algo_ClosestNumbers {

    /**
     * Find minimal absolute difference between any two pairs of integer array
     */

    public static void closestNumbers(List<Integer> numbers){
        if(numbers == null || numbers.size() <= 1){
            return;
        }
        Collections.sort(numbers);
        int diff = Integer.MAX_VALUE;
        for(int i = 1; i < numbers.size(); i++){
            diff = Math.min(diff, numbers.get(i) - numbers.get(i - 1));
        }
        for(int i = 1; i < numbers.size(); i++){
            if(numbers.get(i) - numbers.get(i-1) == diff){
                System.out.println(numbers.get(i-1) + " " + numbers.get(i));
            }
        }
    }
    public static void main(String[] args) {
        closestNumbers(Arrays.asList(4, 2, 1, 3));
    }
}
