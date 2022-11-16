package com.ptl.exercise.Redolent;

import java.util.List;

public class Algo_MinimumStartValue {

    /**
     * I dont understand the problem, but below answer clear all tests
     */
    public static int minX(List<Integer> arr) {
        int x = 1;
        for (int i = arr.size() - 1; i >= 0; i--) {
            //x = x - arr.get(i);
            //if(x < 1){
            //    x = 1;
            //}
            x = x - arr.get(i) < 1 ? 1 : (x - arr.get(i));
        }
        return x;
    }

}
