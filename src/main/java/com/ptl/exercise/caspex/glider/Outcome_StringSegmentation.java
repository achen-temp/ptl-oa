package com.ptl.exercise.caspex.glider;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Outcome_StringSegmentation {

    public static String solve(String S, List<String> wordDict){
        Set<String> wordSet = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[S.length()];
        return canBreak(S, wordDict, 0, memo) ? "true" : "false";
    }

    private static boolean canBreak(String s, List<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && canBreak(s, wordDict, end, memo)) {
                memo[start] = true;
                return true;
            }
        }

        memo[start] = false;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solve("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(solve("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));

    }
}
