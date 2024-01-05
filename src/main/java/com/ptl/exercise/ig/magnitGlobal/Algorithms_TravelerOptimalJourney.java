package com.ptl.exercise.kori.magnitGlobal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithms_TravelerOptimalJourney {

    public static void main(String[] args) {
        //List<Integer> cities = Arrays.asList(0, 100, 200, -500, -100, -150, -50);
        List<Integer> cities = Arrays.asList(0, -10, -20, -30, 50);
        System.out.println(optimalJourneyTotal(cities)); //100
    }

    public static int optimalJourneyTotal(List<Integer> cities){
     int n = cities.size();

     //find all primes ending with 3 and less than n;
     List<Integer> primes = new ArrayList<>();
     for(int p = 1; p < n; p++){
          if(p == 1 || (p % 10 == 3 && isPrime(p))){
              primes.add(p);
          }
     }

     //use dp array to track the optimal journey
     int[] dp = new int[n];
     Arrays.fill(dp, Integer.MIN_VALUE);
     dp[0] = cities.get(0);

     for(int i = 0; i < n; i++){
          for(int p : primes){
               if(i + p < n){
                     dp[i + p] = Math.max(dp[i + p], dp[i] + cities.get(i + p));
               }else{
                     break;
               }
          }
     }
     return dp[n - 1];
}

    // outside of the method
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
