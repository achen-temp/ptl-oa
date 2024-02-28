package com.ptl.exercise.ig.magnitGlobal;

import java.util.List;

public class Algorithms_ProjectManagerAssignTasks {
    
        //TRY IF THIS SOLUTION WILL PASS ALL THE TESTS.
        public static int minimumEffort(List<Integer> efforts, int deadline) {
            int len = efforts.size();
    
            // Initialize a 2D array for dynamic programming
            int totalSum = efforts.stream().mapToInt(o -> o).sum();
    
            int[][] dp = new int[len][deadline + 1];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < deadline + 1; j++) {
                    dp[i][j] = Integer.MAX_VALUE - totalSum; //should be a big value, not sure how big it is
                }
            }
    
            // Calculate base cases
            dp[0][1] = efforts.get(0);
            for (int i = 1; i < len; i++) {
                dp[i][1] = findSum(efforts, 0, i + 1);
            }
    
            // Dynamic programming to fill the rest of the array
            for (int i = 1; i < len; i++) {
                for (int j = 2; j <= deadline; j++) {
                    for (int k = 0; k < i; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[k][j - 1] + findSum(efforts, k + 1, i + 1));
                    }
                }
            }
    
            // Result: The minimum weights of each group
            return dp[len - 1][deadline];
        }
    
        private static int findSum(List<Integer> nums, int start, int end) {
            int sum = nums.get(start);
            for (int i = start; i < end; i++) {
                if (nums.get(i) > sum) {
                    sum = nums.get(i);
    
                }
            }
            return sum;
        }
    
}
