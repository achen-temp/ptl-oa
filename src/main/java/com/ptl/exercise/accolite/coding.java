package com.ptl.exercise.accolite;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class coding {

    /**
     * String s1 = "Mangoes, Apples, Mangoes, Grapes"
     * String s2 = "Orange, Mangoes, Watermellon, Blue Berries, Watermellon"
     * <p>
     * return duplicates in each string and then remove duplicates appeared in another screen
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
