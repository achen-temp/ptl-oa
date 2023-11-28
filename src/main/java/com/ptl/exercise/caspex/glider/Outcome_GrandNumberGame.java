package com.ptl.exercise.caspex.glider;

import java.util.Arrays;
import java.util.List;

public class Outcome_GrandNumberGame {

    /**
     * LC 1799
     * @param arr
     * @return
     */
    public static int solve(List<Integer> arr){
        int dpSize = 1 << arr.size();
        //System.out.println(arr.size() + "," + dpSize);
        int[] dp = new int[dpSize];

        for (int i = dpSize - 1; i >= 0; i--) {
            if (i == dpSize - 1) {
                dp[i] = 0;
                continue;
            }

            int bitCount = Integer.bitCount(i);
            if(bitCount % 2 != 0){
                continue;
            }
            int pairs = bitCount / 2;

            for (int j = 0; j < arr.size(); j++) {
                for (int k = j + 1; k < arr.size(); k++) {
                    if (((i >> j) & 1) == 1 || ((i >> k) & 1) == 1) {
                        continue;
                    }
                    int score = (pairs + 1) * gcd(arr.get(j), arr.get(k)); //gcd method is defined below
                    int index = i | (1 << j) | (1 << k);
                    int remainingScore = dp[index];
                    dp[i] = Math.max(dp[i], score + remainingScore);
                }
            }
        }

        //System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }


    public static void main(String[] args) {
        List<Integer> arr1 = Arrays.asList(1,2,3,4,5,6);
        int highestScore1 = solve(arr1);
        System.out.println("Highest Score: " + highestScore1); //14
        List<Integer> arr2 = Arrays.asList(3,4,9,5);
        int highestScore2 = solve(arr2);
        System.out.println("Highest Score: " + highestScore2);
    }
}
