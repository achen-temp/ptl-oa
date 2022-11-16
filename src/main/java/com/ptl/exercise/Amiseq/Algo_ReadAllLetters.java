package com.ptl.exercise.Amiseq;

import java.util.*;

public class Algo_ReadAllLetters {

    //minimum operations to read all unread letters in mailbox
    public static int solve(List<Integer> ar) {
        int result = 0;
        if (ar == null || ar.size() <= 0) {
            return result;
        }
        for (int i = 0; i < ar.size(); i++) {
            int num = ar.get(i);
            if (num == 1) {
                result += 1;
            } else if (num == 0) {
                if (i - 1 >= 0 && ar.get(i - 1) == 1) {
                    result += 1;
                }
            }
        }
        if (ar.get(ar.size() - 1) == 0 && result > 0) {
            result -= 1;
        }
        return result; //how many failed? enlarge i cannot see it..
    }

    public static void main(String[] args) {
        List<Integer> ar = Arrays.asList(0, 1, 0, 1, 0);
        System.out.println(solve(ar));
    }

}
