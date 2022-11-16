package com.ptl.exercise.Aditi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Algo_RememberPassword {

    /**
     * time for enter 1 password is 1 second, if blocked, has to wait 5 seconds
     *
     * @param k   -- the number of failed tries, after which the access will be blocked for 5 seconds
     * @param ar  -- the available password list
     * @param str --- real password
     * @return two numbers, minTime + maxTime
     */
    public static List<Integer> solve(int k, List<String> ar, String str) {
        int timeEnterOne = 1;
        int timeBlock = 5;
        List<Integer> result = new ArrayList<>();
        if (ar == null || ar.size() == 0) {
            return result;
        }

        int correctPasswordLength = str.length();
        List<String> pwdWithLessLen = ar.stream().filter(a -> a.length() < correctPasswordLength).collect(Collectors.toList());
        List<String> pwdWithSameLen = ar.stream().filter(a -> a.length() == correctPasswordLength).collect(Collectors.toList());
        int blocksLessLength = pwdWithLessLen.size() / k; //blocks to finish passwords with less length
        //time to finish less length + one correct length is minSeconds;
        int minSeconds = pwdWithLessLen.size() * timeEnterOne + blocksLessLength * timeBlock + timeEnterOne;
        result.add(minSeconds);

        //max time is we try password with same length and try correct password in the end
        int maxLength = pwdWithLessLen.size() + pwdWithSameLen.size() - 1; //not include correct password
        int maxBlocks = maxLength / k;
        int maxSeconds = maxLength * timeEnterOne + maxBlocks * timeBlock + timeEnterOne;
        result.add(maxSeconds);
        return result;
    }

    public static void main(String[] args) {
        List<String> passwords = Arrays.asList("11", "22", "1", "2");
        String correctPassword = "22";
        int k = 100;
        List<Integer> result = solve(k, passwords, correctPassword);
        System.out.println(result);
    }
}
