package com.ptl.exercise.magnitGlobal;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.File;
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
        List<Integer> arr = Arrays.asList(1000, 500, 2000, 8000, 1500);
        int K = 3; // Number of subarrays
        System.out.println(partition(arr, arr.size(), K));
    }

    public static int partition(List<Integer> list, int n, int k){
        if(k == 1){
            return findMax(list, 0, n - 1);
        }
        if(n == 1){
            return list.get(0);
        }

        int leastSum = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            leastSum = Math.min(leastSum,
                    Math.max(partition(list, i, k - 1), findMax(list, i, n - 1)));
        }
        return leastSum;
    }

    public static int findMax(List<Integer> list, int from, int to){
        int max = Integer.MIN_VALUE;
        for(int i = from; i <= to; i++){
            max = Math.max(max, list.get(i));
        }
        return max;
    }


}

class BinarySearchWay{
    class Solution {
        private int minimumSubarraysRequired(int[] nums, int maxSumAllowed) {
            int currentSum = 0;
            int splitsRequired = 0;

            for (int element : nums) {
                // Add element only if the sum doesn't exceed maxSumAllowed
                if (currentSum + element <= maxSumAllowed) {
                    currentSum += element;
                } else {
                    // If the element addition makes sum more than maxSumAllowed
                    // Increment the splits required and reset sum
                    currentSum = element;
                    splitsRequired++;
                }
            }

            // Return the number of subarrays, which is the number of splits + 1
            return splitsRequired + 1;
        }

        public int splitArray(int[] nums, int m) {
            // Find the sum of all elements and the maximum element
            int sum = 0;
            int maxElement = Integer.MIN_VALUE;
            for (int element : nums) {
                sum += element;
                maxElement = Math.max(maxElement, element);
            }

            // Define the left and right boundary of binary search
            int left = maxElement;
            int right = sum;
            int minimumLargestSplitSum = 0;
            while (left <= right) {
                // Find the mid value
                int maxSumAllowed = left + (right - left) / 2;

                // Find the minimum splits. If splitsRequired is less than
                // or equal to m move towards left i.e., smaller values
                if (minimumSubarraysRequired(nums, maxSumAllowed) <= m) {
                    right = maxSumAllowed - 1;
                    minimumLargestSplitSum = maxSumAllowed;
                } else {
                    // Move towards right if splitsRequired is more than m
                    left = maxSumAllowed + 1;
                }
            }

            return minimumLargestSplitSum;
        }
    }
}

class Test{
      public Test(){
          Bar b = new Bar();
          Bar b1 = new Bar();
          update(b);
          update(b1);
          b1 = b;
          update(b);
          update(b1);
      }
      private void update(Bar bar){
          bar.x = 20;
          System.out.println(bar.x);
      }

    public static void main(String[] args) {
        new Test();
    }
    private class Bar{
              int x = 10;
    }

}