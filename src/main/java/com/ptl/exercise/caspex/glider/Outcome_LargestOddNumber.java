package com.ptl.exercise.caspex.glider;

import java.util.Arrays;

public class Outcome_LargestOddNumber {

    public static int findLargestOddNumber1(String S) {
        String[] splits = S.split("[a-z]+");
        int result = -1;

        for (String word : splits) {
            if (!word.isEmpty()) {
                int num = Integer.parseInt(word);
                if (num % 2 == 1 && num > result) {
                    result = num;
                }
            }
        }

        return result;
    }

    public static int findLargestOddNumber(String S) {
        return Arrays.stream(S.split("[a-z]+"))
                .filter(w -> !w.isEmpty())
                .map(e -> Integer.valueOf(e))
                .filter(v -> v% 2 == 1)
                .mapToInt(v -> v)
                .max()
                .orElse(-1);
    }

    public static void main(String[] args) {
        System.out.println(findLargestOddNumber("gt12cty65mt1"));
        System.out.println(findLargestOddNumber("mkf1043kdlcmk32komv0023"));
    }
}
