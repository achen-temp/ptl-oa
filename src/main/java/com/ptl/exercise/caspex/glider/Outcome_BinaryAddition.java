package com.ptl.exercise.caspex.glider;

import java.util.ArrayList;
import java.util.List;

public class Outcome_BinaryAddition {

    public static String solve(String a, String b){
        StringBuilder sb = new StringBuilder();
        int carryOver = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0) {
            int sum = carryOver;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            sb.insert(0, sum % 2);
            carryOver = sum / 2;
        }

        if (carryOver > 0) {
            sb.insert(0, carryOver);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solve("11", "1")); //100
        System.out.println(solve("1010", "1011")); //10101
    }
}
