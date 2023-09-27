package com.ptl.exercise.magnitGlobal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class oa {

    //given integer array and number K
    //split the array into K groups and find the maximum of each group. then find the sum of the max value in each group
    //return the LEAST sum
    public static int leastSumOfSubGroup(List<Integer> costs, int weeks){
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1000, 500, 2000, 8000, 1500};
        int K = 3; // Number of subarrays

        List<List<List<Integer>>> combinations = splitArray(arr, K);

        for (List<List<Integer>> combination : combinations) {
            //System.out.println(combination);
        }
    }

    public static List<List<List<Integer>>> splitArray(int[] arr, int k) {
        List<List<List<Integer>>> result = new ArrayList<>();
        List<List<Integer>> currentCombination = new ArrayList<>();
        splitArrayRecursive(arr, k, 0, new ArrayList<>(), currentCombination, result);
        return result;
    }

    private static void splitArrayRecursive(int[] arr, int k, int currentIndex, List<Integer> list, List<List<Integer>> currentCombination, List<List<List<Integer>>> result) {
        if(k == 1){
            //add reminder array
            //System.out.println(list);
            System.out.println(currentCombination);
            return;
        }

        // Include the current element in the current subarray
        for(int i = currentIndex; i < arr.length; i++){
            if(k > 1){
                list.add(arr[i]);
                currentCombination.add(new ArrayList<>(list));
                splitArrayRecursive(arr, k - 1, i + 1, list, currentCombination, result);
                currentCombination.remove(currentCombination.size() - 1);
                list.remove(list.size() - 1);
            }
        }
    }


    /*
    public static void main(String[] args) {
        List<Integer> costs = Arrays.asList(1000, 500, 2000, 8000, 1500);
        int weeks = 3;
        int result = leastSumOfSubGroup(costs, weeks);
        System.out.println(result);
    }
    */


}

class Test2{

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int K = 3;

        // Find all the possible ways to split the array into K subarrays
        List<List<Integer>> allSplits = findSplits(arr, K);

        // Print all the possible splits
        for (List<Integer> split : allSplits) {
            for (int i = 0; i < split.size(); i++) {
                System.out.print(split.get(i));
                if (i < split.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> findSplits(int[] arr, int K) {
        List<List<Integer>> allSplits = new ArrayList<>();

        // Recursively find all the possible splits
        findSplits(arr, 0, K, new ArrayList<>(), allSplits);

        return allSplits;
    }

    private static void findSplits(int[] arr, int start, int K, List<Integer> split, List<List<Integer>> allSplits) {
        // Base case
        if (K == 0) {
            allSplits.add(new ArrayList<>(split));
            return;
        }

        // Recursive case
        for (int i = start; i < arr.length; i++) {
            split.add(arr[i]);
            findSplits(arr, i + 1, K - 1, split, allSplits);
            split.remove(split.size() - 1);
        }
    }

}
