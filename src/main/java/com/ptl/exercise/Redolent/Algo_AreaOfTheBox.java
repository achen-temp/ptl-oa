package com.ptl.exercise.redolent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algo_AreaOfTheBox {

    public static void main(String[] args) {
        int[][] queries = {{3, 4}, {6, 5}};
        int[] result = numberOfWays(queries);
        System.out.println(Arrays.toString(result));
    }

    //use this one if input is list of list
    public static List<Long> numberOfWays(List<List<Integer>> queries) {
        List<Long> result = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            List<Integer> irow = queries.get(i);
            int rows = irow.get(0);
            int columns = irow.get(1);
            int minNumber = Math.min(rows, columns);
            long sumWays = 0;
            for (int k = 1; k <= minNumber; k++) {
                int sumWay = (rows - k + 1) * (columns - k + 1);
                if (sumWay >= 0) {
                    sumWays += sumWay;
                }
            }
            result.add(sumWays);
        }
        return result;
    }
    
    // use this one if input is arrays
    public static int[] numberOfWays(int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] irow = queries[i];
            int rows = irow[0];
            int columns = irow[1];
            int minNumber = Math.min(rows, columns);
            int sumWays = 0;
            for (int k = 1; k <= minNumber; k++) {
                int sumWay = (rows - k + 1) * (columns - k + 1);
                if (sumWay >= 0) {
                    sumWays += sumWay;
                }
            }
            result[i] = sumWays;
        }
        return result;
    }
}
