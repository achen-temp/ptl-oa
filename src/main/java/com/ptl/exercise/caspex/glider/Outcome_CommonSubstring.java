package com.ptl.exercise.caspex.glider;

public class Outcome_CommonSubstring {

    public static int solve(int A, String X, int B, String Y){
        if(A == 0 || B == 0){
            return 0;
        }

        int result = 0;
        int[][] dp = new int[2][B + 1];

        for(int i = 1; i <= A; i++){
            for(int j = 1; j <= B; j++){
                if(X.charAt(i - 1) == Y.charAt(j - 1)){
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + 1;
                    result = Math.max(result, dp[i % 2][j]);
                }else{
                    dp[i % 2][j] = 0;
                }
            }
        }

        return result;
    }
    
}
