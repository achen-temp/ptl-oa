package com.ptl.exercise.accolite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class coding {

    /**
     * String s1 = "Mangoes, Apples, Mangoes, Grapes"
     * String s2 = "Orange, Mangoes, Watermellon, Blue Berries, Watermellon"
     * <p>
     * return duplicates in each string and then remove duplicates appeared in another string
     * <p>
     * result1 -> "Apples,Grapes"
     * result2 -> "Orange, Mangoes, Blue Berries"
     */
    public static void removeDuplicates(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return;
        }
        List<String> wordList1 = Arrays.asList(s1.replaceAll("\\s+", "").split(","));
        List<String> wordList2 = Arrays.asList(s2.replaceAll("\\s+", "").split(","));

        String result1 = wordList1.stream().distinct().filter(w -> !wordList2.contains(w)).collect(Collectors.joining(",")); //先写下一行

        String result2 = wordList2.stream().distinct().filter(w -> !wordList1.contains(w)).collect(Collectors.joining(","));

        System.out.println(result1);
        System.out.println(result2);

    }
    public static void main(String[] args) {
        String s1 = "Mangoes, Apples, Mangoes, Grapes";
        String s2 = "Orange, Mangoes, Watermellon, Blue Berries, Watermellon";
        removeDuplicates(s1, s2);
    }
}


class BitShift{
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class myClass = Class.forName("Test");
        ClassLoader loader = myClass.getClassLoader();
        Object obj = myClass.newInstance();
    }
}

class MinimumSwapsForSorting {

    public static int minSwapsToSort(List<Integer> ar) {
        int n = ar.size();
        int swaps = 0;

        // Create a list of pairs (element, index)
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(ar.get(i), i));
        }

        // Sort the pairs list based on element values
        Collections.sort(pairs);

        // Create a visited array to keep track of visited elements
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            // If already visited or element is in its correct position
            if (visited[i] || pairs.get(i).index == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = pairs.get(j).index;
                cycleSize++;
            }

            // If cycle size > 0, then a cycle is found, add cycleSize - 1 to swaps
            if (cycleSize > 0) {
                swaps += cycleSize - 1;
            }
        }

        return swaps;
    }

    static class Pair implements Comparable<Pair> {
        int value, index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int compareTo(Pair other) {
            return Integer.compare(this.value, other.value);
        }
    }

    public static void main(String[] args) {
        List<Integer> arr1 = Arrays.asList(6, 4, 2, 1);
        int minSwaps1 = minSwapsToSort(arr1);
        System.out.println("Minimum swaps needed for arr1: " + minSwaps1);

        List<Integer> arr2 = Arrays.asList(2, 10, 8, 6, 4);
        int minSwaps2 = minSwapsToSort(arr2);
        System.out.println("Minimum swaps needed for arr2: " + minSwaps2);
    }
}

