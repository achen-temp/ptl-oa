package com.ptl.exercise.Aditi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Algo_PaintLegoBricks {

    public static void main(String[] args) {
        List<Integer> blocks = Arrays.asList(1, 2);
        int result = solve(blocks);
        System.out.println(result);
    }

    //there are two test hidden test case failure.
    public static int solve(List<Integer> c) {
        if (c == null || c.size() <= 1) {
            return 0;
        }

        Collections.sort(c, (a, b) -> a - b);
        int result = 0;
        for (int i = 0; i < c.size(); i++) {
            int ci = c.get(i);
            result += c.get(0) + i - ci;
        }

        return result;
    }
}
