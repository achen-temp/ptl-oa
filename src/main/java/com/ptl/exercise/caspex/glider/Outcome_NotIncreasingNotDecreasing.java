package com.ptl.exercise.caspex.glider;

import java.util.Arrays;
import java.util.List;

public class Outcome_NotIncreasingNotDecreasing {

    public static int minimumDeletions(List<Integer> ar){
        if (ar == null || ar.size() <= 2) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < ar.size() - 2; i++)
        {
            if ((ar.get(i) < ar.get(i + 1) &&
                    ar.get(i + 1) < ar.get(i + 2))
                    ||
                    ((ar.get(i) > ar.get(i + 1) &&
                            ar.get(i + 1) > ar.get(i + 2))))
                result++;
        }

        return result;
    }

    public static void main (String[] args) {
        List<Integer> ar = Arrays.asList(1,2,4,5);
        System.out.println(minimumDeletions(ar));
    }
}
