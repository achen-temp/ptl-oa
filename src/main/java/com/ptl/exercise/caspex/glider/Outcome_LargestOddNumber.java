package com.ptl.exercise.caspex.glider;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Outcome_LargestOddNumber {

    public static int solve(String S) {
        String[] words = S.split("[a-z]+");
        int res = -1;

        for (String word : words) {
            if (word != null && word.trim() != null && word.trim().length() != 0) {
                int num = Integer.parseInt(word);
                if (num % 2 != 0 && res < num) {
                    res = num;
                }
            }
        }

        return res;
    }

    public static int findLargestOddNumber(String S) {
        return Arrays.stream(S.split("[a-z]+"))
                .filter(w -> !w.isEmpty())
                .mapToInt(e -> Integer.valueOf(e))
                .filter(v -> v% 2 == 1)
                .max()
                .orElse(-1);
    }

    public static void main(String[] args) {
        System.out.println(solve("gt12cty65mt1"));
        System.out.println(findLargestOddNumber("mkf1043kdlcmk32komv0023"));
    }
}
