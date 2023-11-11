package com.ptl.exercise.caspex.glider;

import java.util.Arrays;
import java.util.List;

public class Outcome_NotIncreasingNotDecreasing {

    public static int solve(List<Integer> ar){
        int ans = 0;
        for (int i = 0; i < ar.size() - 2; i++)
        {
            if ( ((ar.get(i) > ar.get(i + 1) && ar.get(i + 1) > ar.get(i + 2)))
                    ||
                    (ar.get(i) < ar.get(i + 1) && ar.get(i + 1) < ar.get(i + 2)) )
                ans++;
        }

        return ans;
    }

    public static void main (String[] args) {
        List<Integer> ar = Arrays.asList(1,2,4,1,2);
        System.out.println(solve(ar));
    }
}
