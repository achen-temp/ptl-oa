package com.ptl.exercise.caspex.glider;

import java.util.Arrays;
import java.util.List;

public class Outcome_TheOnlyWayIsUp {

    public static int solve(int B, List<Integer> ar){
        if(ar == null || ar.size() <= 1){
            return 0;
        }
        int count = 0;
        int prev = ar.get(0);
        for(int i = 1; i < ar.size(); i++){
            if(ar.get(i) > prev){
                prev = ar.get(i);
                continue;
            }else{
                int count1 = ((prev - ar.get(i)) / B) + 1;
                prev = ar.get(i) + B * count1;
                count += count1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> ar = Arrays.asList(1,3,3,2);
        int B = 2;
        System.out.println(solve(B, ar));
    }
}
