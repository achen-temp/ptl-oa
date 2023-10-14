package com.ptl.exercise.caspex.glider;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Outcome_StringSegmentation {

    public static String solve(String S, List<String> wordDict){

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
