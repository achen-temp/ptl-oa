package com.ptl.exercise.caspex.glider;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Outcome_StringSegmentation {

    //this solution pass ALL test cases
    public static String solve(String S,List<String> wordDict){
        //Write your code here
        int n = S.length();
        Set<String> hashSet = new HashSet<>(wordDict);
        boolean[] valids = new boolean[n + 1];
        valids[0] = true;
        for(int right = 0; right < n; right++) {
            boolean canBreak = false;
            for(int left = 0; left <= right; left++) {
                boolean canBreakLeft = valids[left];
                boolean canBreakRight = hashSet.contains(S.substring(left, right + 1));
                if(canBreakLeft && canBreakRight) {
                    canBreak = true;
                }
                valids[right + 1] = canBreak;
            }
        }
        return valids[n] ? "true" : "false";
    }

    /**
     * NOT SURE WHY THIS RECURSION SOLUTION WILL FAILL THE TESTS
     * (It shows ALL PASS when doing the OA, but reports says it FAILED ALL test cases)
     * (USE another solution: DP instead)
     * @param S
     * @param wordDict
     * @return
     */
    public static String solve1(String S, List<String> wordDict){

        Boolean[] arr = new Boolean[S.length()];
        return String.valueOf(helper(S, wordDict, 0, arr));
    }

    private static boolean helper(String input, List<String> wordDict, int index, Boolean[] arr) {
        if (index == input.length()) {
            return true;
        }
        if (arr[index] != null) {
            return arr[index];
        }

        for (int right = index + 1; right <= input.length(); right++) {
            if (wordDict.contains(input.substring(index, right)) && helper(input, wordDict, right, arr)) {
                arr[index] = true;
                return true;
            }
        }

        arr[index] = false;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solve("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(solve("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));

    }
}
