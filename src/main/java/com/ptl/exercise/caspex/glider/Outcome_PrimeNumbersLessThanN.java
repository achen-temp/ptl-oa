package com.ptl.exercise.caspex.glider;

import java.util.ArrayList;
import java.util.List;

public class Outcome_PrimeNumbersLessThanN {

    //find all prime numbers smaller than N
    public static int solve(int N){
        List<Integer> ar = new ArrayList<>();
        boolean[] valids = new boolean[N];

        for(int i = 2; i < N; i++){
            if(!valids[i]){
                ar.add(i);
                for(int k = i * i; k < N; k += i){
                    valids[k] = true;
                }
            }
        }
        return ar.size();
    }

    public static void main(String[] args) {
        System.out.println(solve(10)); //4
        System.out.println(solve(0)); //0
    }
}
