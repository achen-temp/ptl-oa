package com.ptl.exercise.intuit;

import java.util.Arrays;
import java.util.Stack;

public class HigherNumberSort {

    public static int[] higherNumbers(int[] input){
       Arrays.sort(input);
       int arraySize = input.length;
       int[] output = new int[arraySize];
       for (int i = 1; i < arraySize; i++) {
           output[i-1] = input[i];
       }
       output[arraySize-1] = -1;
       return output;
    }


    public static void main(String[] args) {
//        System.out.println(Arrays.toString(higherNumbers(new int[]{25, 4, 8, 2})));
        System.out.println(Arrays.toString(higherNumbers(new int[]{3, 99, 28, 12, 47})));
    }
}
