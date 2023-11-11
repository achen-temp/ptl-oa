package com.ptl.exercise.caspex.glider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Outcome_BrothersGame {

    /**
     * Given Array with all 0s and 1s. Flip part or whole array once so you get the maximum number of 1s.
     * Return the maximum number of 1s you can get.
     */

    public static int solve(List<Integer> ar){
        if(ar == null || ar.size() == 0){
            return 0;
        }

        int sum = 0;
        int[] nums = new int[ar.size()];
        for(int i = 0; i < ar.size(); i++){
            sum += ar.get(i);
            nums[i] = ar.get(i) == 0 ? 1 : -1;
        }

        int[] left = new int[3]; //hold value, left boundary, right boundary
        int[] right = new int[3];
        for(int i = 0; i < nums.length; i++){
            if(right[0] + nums[i] >= 0){
                right[0] += nums[i];
            }else{
                right[1] = i + 1;
                right[0] = 0;
            }

            if(left[0] < right[0]){
                left[1] = right[1];
                left[2] = i;
                left[0] = right[0];
            }
        }
        return sum + left[0];
    }

    public static void main(String[] args) {
        List<Integer> ar1 = Arrays.asList(0,1,0,0,1);
        System.out.println(solve(ar1)); //4
        List<Integer> ar2 = Arrays.asList(1,0,0,1,0,0);
        System.out.println(solve(ar2)); //5
        List<Integer> ar3 = Arrays.asList(1,0,0,1,0);
        System.out.println(solve(ar3)); //4
        List<Integer> ar4 = Arrays.asList(1,0,0,1,1,1,0,0,0,1);
        System.out.println(solve(ar4)); //8
        List<Integer> ar5 = Arrays.asList(0,0,0,1,0,0);
        System.out.println(solve(ar5)); //5
        List<Integer> ar6 = Arrays.asList(0,0,0,0,0,1);
        System.out.println(solve(ar6)); //6
        List<Integer> ar7 = Arrays.asList(1,0,1,0,1,0,1);
        System.out.println(solve(ar7)); //5
        List<Integer> ar8 = Arrays.asList(1,1,1);
        System.out.println(solve(ar8)); //3
        List<Integer> ar9 = Arrays.asList(0, 0, 0, 1, 1, 1, 0);
        System.out.println(solve(ar9)); //6
        List<Integer> ar10 = Arrays.asList(0, 0, 0, 0);
        System.out.println(solve(ar10)); //4
        List<Integer> ar11 = Arrays.asList(0);
        System.out.println(solve(ar11)); //1
        List<Integer> ar12 = Arrays.asList(1);
        System.out.println(solve(ar12)); //1
        List<Integer> ar13 = new ArrayList<>();
        System.out.println(solve(ar13)); //0
    }
}
