package com.ptl.exercise.Randstad;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Algo_MinimalOperations {

    //minimum swap needs to convert array to ascending order
    //O(nlogn)
    public static int solve(List<Integer> ar) {
        int len = ar.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(ar.get(i), i);
        }

        Collections.sort(ar);

        boolean[] visited = new boolean[len];
        Arrays.fill(visited, false);

        int result = 0;
        for (int i = 0; i < len; i++) {
            if (visited[i] || map.get(ar.get(i)) == i)
                continue;

            int j = i;
            int size = 0;
            while (!visited[j]) {
                visited[j] = true;
                j = map.get(ar.get(j));
                size++;
            }

            if (size > 0) {
                result += (size - 1);
            }
        }
        return result;
    }

    //O(n)
    //3 test failures in  hackerrank
    static int miniSwaps(List<Integer> ar) {
        int count = 0;
        int[] idx = new int[ar.size()];
        for (int i = 0; i < ar.size(); i++) {
            idx[ar.get(i) - 1] = i;
        }
        for (int i = 0; i < ar.size(); i++) {
            if (ar.get(i) == i + 1) {
                continue;
            }
            int tmp = ar.get(i);
            ar.set(i, ar.get(idx[i]));
            ar.set(idx[i], tmp);
            idx[tmp - 1] = idx[i];
            count++;
        }
        return count;
    }

    //O(n)
    static int minimumSwaps(int[] ar) {
        int count = 0;
        int[] idx = new int[ar.length];
        for (int i = 0; i < ar.length; i++) {
            idx[ar[i] - 1] = i;
        }
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == i + 1) {
                continue;
            }
            int tmp = ar[i];
            ar[i] = ar[idx[i]];
            ar[idx[i]] = tmp;
            idx[tmp - 1] = idx[i];
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2,10,8,6,4);
        int result2 = solve(nums);
        System.out.println(result2);
    }
}
