package com.ptl.exercise.caspex.glider;

import java.util.Arrays;
import java.util.List;

public class Outcome_NotIncreasingNotDecreasing {

    public static int solve(List<Integer> ar){
        int ans = 0;
        if(ar == null || ar.size() <= 1){
            return ans;
        }
        for(int i = 0; i < ar.size() - 2; i++){
            int curr = ar.get(i);
            int next = ar.get(i + 1);
            int next2 = ar.get(i + 2);
            if(curr < next && next < next2){
                ans++;
            }
            if(curr > next && next > next2){
                ans++;
            }
        }
        return ans;
    }

    public static void main (String[] args) {
        List<Integer> ar = Arrays.asList(1,2,4,1,2);
        System.out.println(solve(ar));
    }
}
