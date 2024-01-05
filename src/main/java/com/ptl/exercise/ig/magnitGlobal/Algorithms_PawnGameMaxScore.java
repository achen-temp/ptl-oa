package com.ptl.exercise.kori.magnitGlobal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithms_PawnGameMaxScore {

    public static void main(String[] args) {
        List<Integer> cities = Arrays.asList(0, 100, 200, -500, -100, -150, -50);
        //List<Integer> cities = Arrays.asList(0, -10, -20, -30, 50);
        System.out.println(maxGameScore(cities)); // 100
    }

    //I think this is correct, but if it is not, use another solution below
    public static int maxGameScore(List<Integer> cell) {
        int n = cell.size();

        // find all primes ending with 3 and less than n;
        List<Integer> primes = new ArrayList<>();
        for (int p = 1; p < n; p++) {
            if (p == 1 || (p % 10 == 3 && isPrime(p))) {
                primes.add(p);
            }
        }

        // use dp array to track the optimal journey
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = cell.get(0);

        for (int i = 0; i < n; i++) {
            for (int p : primes) {
                if (i + p < n) {
                    dp[i + p] = Math.max(dp[i + p], dp[i] + cell.get(i + p));
                } else {
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


    //this is 2nd solution, some student used this, i didnot try
    public static int maxGameScore2(List<Integer> cell){
        int n = cell.size();
        int[] sieve = new int[n + 1];
        Arrays.fill(sieve, 1);
        sieve[0] = 0;

        for(int i = 2; i < sieve.length; i++){
            int j = i + i;
            while(j < sieve.length){
                sieve[j] = 0;
                j += i;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for(int i = 0; i < sieve.length; i++){
            if(sieve[i] > 0 && (i == 1 || i % 10 == 3)){
                primes.add(i);
            }
        }

        int[] dp = new int[n];
        dp[n - 1] = cell.get(n - 1);
        for(int i = n - 2; i >= 0; i--){
            int greatestJump = Integer.MIN_VALUE;

            for(int p : primes){
                if(i + p < n){
                    greatestJump = Math.max(greatestJump, cell.get(i) + dp[i + p]);
                }
            }

            dp[i] = greatestJump;
        }

        return dp[0];
    }
}
