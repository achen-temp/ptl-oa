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
        int maxStates = 1 << arr.size(); // 2^(nums array size)
        int finalMask = maxStates - 1;

        // 'dp[i]' stores max score we can get after picking remaining numbers represented by 'i'.
        int[] dp = new int[maxStates];

        // Iterate on all possible states one-by-one.
        for (int state = finalMask; state >= 0; state--) {
            // If we have picked all numbers, we know we can't get more score as no number is remaining.
            if (state == finalMask) {
                dp[state] = 0;
                continue;
            }

            int numbersTaken = Integer.bitCount(state);
            int pairsFormed = numbersTaken / 2;
            // States representing even numbers are taken are only valid.
            if (numbersTaken % 2 != 0) {
                continue;
            }

            // We have picked 'pairsFormed' pairs, we try all combinations of one more pair now.
            // We iterate on two numbers using two nested for loops.
            for (int firstIndex = 0; firstIndex < arr.size(); firstIndex++) {
                for (int secondIndex = firstIndex + 1; secondIndex < arr.size(); secondIndex++) {
                    // We only choose those numbers which were not already picked.
                    if (((state >> firstIndex) & 1) == 1 || ((state >> secondIndex) & 1) == 1) {
                        continue;
                    }
                    int currentScore = (pairsFormed + 1) * gcd(arr.get(firstIndex), arr.get(secondIndex));
                    int stateAfterPickingCurrPair = state | (1 << firstIndex) | (1 << secondIndex);
                    int remainingScore = dp[stateAfterPickingCurrPair];
                    dp[state] = Math.max(dp[state], currentScore + remainingScore);
                }
            }
        }

        // Returning score we get from 'n' remaining numbers of array.
        return dp[0];
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1,2,3,4,5,6);
        int highestScore = solve(arr);
        System.out.println("Highest Score: " + highestScore);
    }
}
