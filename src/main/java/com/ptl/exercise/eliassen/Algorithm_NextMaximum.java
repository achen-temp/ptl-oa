package com.ptl.exercise.eliassen;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Algorithm_NextMaximum {

    /*
     * o solve the "Next Maximum" problem efficiently in O(n) time,
     * we use a monotonic stack that keeps track of indices whose next greater
     * element is not yet found.
     */

    public static List<Integer> solve(List<Integer> ar) {
        int n = ar.size();
        List<Integer> res = new ArrayList<>(Collections.nCopies(n, -1));
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && ar.get(i) > ar.get(stack.peek())) {
                int idx = stack.pop();
                res.set(idx, ar.get(i));
            }
            stack.push(i);
        }

        return res;
    }

}
