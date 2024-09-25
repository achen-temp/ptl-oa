package com.ptl.exercise.caspex.glider;

import java.util.List;

public class CoinCollections {
    
    public static int solve(List<Integer> A, List<Integer> B) {
        int i = 0, j = 0;
        int n = A.size(), m = B.size();
        
        int sumA = 0, sumB = 0;
        int maxCoins = 0;
        
        boolean decreasing = A.get(0) > A.get(1);
        // Traverse both roads to find the maximum collection path
        while (i < n && j < m) {
            if(!decreasing){
                if (A.get(i) < B.get(j)) {
                    sumA += A.get(i);
                    i++;
                } else if (A.get(i) > B.get(j)) {
                    sumB += B.get(j);
                    j++;
                } else { // Matching points found
                    sumA += A.get(i);
                    sumB += B.get(j);
                    
                    // Choose the best switch path
                    maxCoins += Math.max(sumA, sumB);
                    //System.out.print(A.get(i) + " ");
                // System.out.print(B.get(j) + " ");
                    i++;
                    j++;
                    
                    sumA = 0;
                    sumB = 0;
                }
            }else{ //decreasing, pick the big one first
                if (A.get(i) > B.get(j)) {
                    sumA += A.get(i);
                    i++;
                } else if (A.get(i) < B.get(j)) {
                    sumB += B.get(j);
                    j++;
                } else { // Matching points found
                    sumA += A.get(i);
                    sumB += B.get(j);
                    
                    // Choose the best switch path
                    maxCoins += Math.max(sumA, sumB);
                    //System.out.print(A.get(i) + " ");
                // System.out.print(B.get(j) + " ");
                    i++;
                    j++;
                    
                    sumA = 0;
                    sumB = 0;
                }
            }
        }
        
        // Collect remaining coins from Road A
        while (i < n) {
            sumA += A.get(i);
            //System.out.print(A.get(i) + " ");
            i++;
        }
        
        // Collect remaining coins from Road B
        while (j < m) {
            sumB += B.get(j);
            //System.out.print(B.get(j) + " ");
            j++;
        }
        
        maxCoins += Math.max(sumA, sumB);
        
        return maxCoins;
    }

    public static void main(String[] args) {
        // Example #2 test
        List<Integer> A = List.of(8, 7, 6, 5, 2, 1); // Road A
        List<Integer> B = List.of(9, 8, 7, 4, 2);    // Road B
        
        int result = solve(A, B);
        System.out.println("Maximum coins collected: " + result); // Expected output: 38
    }
}
