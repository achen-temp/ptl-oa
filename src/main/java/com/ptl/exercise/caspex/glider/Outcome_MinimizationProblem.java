package com.ptl.exercise.caspex.glider;

import java.util.Collections;
import java.util.List;

public class Outcome_MinimizationProblem {
    
 public static int solve(List<Integer> A, List<Integer> B, List<Integer> C) {
        // Sort the lists to apply the three-pointer technique
        Collections.sort(A);
        Collections.sort(B);
        Collections.sort(C);
        
        int i = 0, j = 0, k = 0;
        int minDifference = Integer.MAX_VALUE;
        
        // Traverse the arrays
        while (i < A.size() && j < B.size() && k < C.size()) {
            int minVal = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));
            int maxVal = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));
            int difference = maxVal - minVal;
            
            // Update minDifference if a smaller difference is found
            minDifference = Math.min(minDifference, difference);
            
            // Increment the pointer which points to the minimum element
            if (minVal == A.get(i)) {
                i++;
            } else if (minVal == B.get(j)) {
                j++;
            } else {
                k++;
            }
        }
        
        return minDifference;
    }
}


