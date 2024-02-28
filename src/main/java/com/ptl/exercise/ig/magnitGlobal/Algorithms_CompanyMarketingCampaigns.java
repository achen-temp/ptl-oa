package com.ptl.exercise.ig.magnitGlobal;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given integer array and splits k
 * Split the array into k sub-arrays
 * find the max number in each sub-array and sum all the max number
 * find the smallest sum
 */
public class Algorithms_CompanyMarketingCampaigns {

    public static void main(String[] args) {
        List<Integer> costs1 = Arrays.asList(3000, 1000, 4000);
        int weeks10 = 1;
        System.out.println(minimumWeeklyInput(costs1, weeks10)); // 4000
        int weeks11 = 2;
        System.out.println(minimumWeeklyInput(costs1, weeks11)); // 7000
        int weeks12 = 3;
        System.out.println(minimumWeeklyInput(costs1, weeks12)); // 8000
    }


    public static int minimumWeeklyInput(List<Integer> costs, int weeks) {
        int len = costs.size();

        // Initialize a 2D array for dynamic programming
        int totalSum = costs.stream().mapToInt(o -> o).sum();

        int[][] dp = new int[len][weeks + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < weeks + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE - totalSum; //should be a big value, not sure how big it is
            }
        }

        // Calculate base cases
        dp[0][1] = costs.get(0);
        for (int i = 1; i < len; i++) {
            dp[i][1] = findSum(costs, 0, i + 1);
        }

        // Dynamic programming to fill the rest of the array
        for (int i = 1; i < len; i++) {
            for (int j = 2; j <= weeks; j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[k][j - 1] + findSum(costs, k + 1, i + 1));
                }
            }
        }

        // Result: The minimum weights of each group
        return dp[len - 1][weeks];
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