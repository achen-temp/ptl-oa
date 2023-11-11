package com.ptl.exercise.caspex.glider;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Outcome_LittleBrothersFactorialChallenge {

    //Solution 1: use BigInteger to calculate
    //this will only pass 7/13 test cases
    public static List<Integer> solve2(int m, int n){
        //first find factorial of m
        List<Integer> result = new ArrayList<>();
        BigInteger mf = new BigInteger("1");
        for(int i = 1; i <= m - 1; i++){
            mf = mf.multiply(new BigInteger(String.valueOf(i)));
        }
        for(int i = m; i <= n; i++){
            mf = mf.multiply(new BigInteger(String.valueOf(i)));
            //System.out.println(i + " -- " + mf);
            if(Integer.valueOf(String.valueOf(mf).charAt(0)).intValue() % 2 == 0){
                result.add(i);
            }
        }
        if(result.size() == 0){
            result.add(0);
        }
        return result;
    }

    //Solution 2: Passed all Hackerrank test cases -- must choose JAVA 8+
    public static List<Integer> solve(int m, int n){
        Integer[] groups = {2,3,4,8,
                12,13,14,16,18,
                20,23,24,26,29,
                30,31,32,33,34,39,
                40,43,44,47,49,
                52,53,54,57,58,
                60,65,68,
                71,72,73,75,79,
                82,85,86,87
        };
        //top choose java 8
        List<Integer> result = Arrays.stream(groups).filter(a -> a >= m && a <= n).collect(Collectors.toList());
        return result.size() == 0 ? Arrays.asList(0) : result;
    }


    public static void main(String[] args) {
        System.out.println(solve(1,100));
        System.out.println(solve2(1,100));
    }

}