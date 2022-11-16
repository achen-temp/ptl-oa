package com.ptl.exercise.Flextonic;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Algo_NumberConversion {

    private static final String[] thousands = {"", "M", "MM", "MMM"};
    private static final String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public static String solve(int N) {
        return thousands[N / 1000] + hundreds[N % 1000 / 100] + tens[N % 100 / 10] + ones[N % 10];
    }

    public static void main(String[] args) {
        System.out.println(solve(7));
    }
}
