package com.ptl.exercise.redolent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algo_CommonPrefixLength {

    public static void main(String[] args) {
        List<String> inputs = Arrays.asList("aa");
        List<Integer> results = commonPrefix(inputs);
        System.out.println(results);
    }

    public static List<Integer> commonPrefix(List<String> inputs) {
        List<Integer> res = new ArrayList<>();
        for (String str : inputs) {
            res.add(getSumCount(str));
        }
        return res;
    }

    public static int getSumCount(String s) {
        // Write your code here
        int n = s.length();
        int p1 = 0, p2 = 0;
        char[] charArr = s.toCharArray();
        int[] nums = new int[n];

        int result = s.length();
        for (int i = 1; i < n; i++) {
            if (i > p2) {
                p1 = p2 = i;
                while (p2 < n && charArr[p2 - p1] == charArr[p2]) {
                    p2++;
                }
                nums[i] = p2 - p1;
                p2--;
                result += nums[i];
            } else {
                int k = i - p1;
                if (nums[k] < p2 - i + 1) {
                    nums[i] = nums[k];
                    result += nums[i];
                } else {
                    p1 = i;
                    while (p2 < n && charArr[p2 - p1] == charArr[p2]) {
                        p2++;
                    }
                    nums[i] = p2 - p1;
                    p2--;
                    result += nums[i];
                }
            }
        }
        return result;
    }
}
