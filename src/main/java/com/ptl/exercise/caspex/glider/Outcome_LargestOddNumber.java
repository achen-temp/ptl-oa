package com.ptl.exercise.caspex.glider;

public class Outcome_LargestOddNumber {

    public static int findLargestOddNumber(String S) {
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

    public static void main(String[] args) {
        System.out.println(findLargestOddNumber("gt12cty65mt1"));
        System.out.println(findLargestOddNumber("mkf1043kdlcmk32komv0023"));
    }
}
