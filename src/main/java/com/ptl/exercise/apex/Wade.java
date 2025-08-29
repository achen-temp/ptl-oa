package com.ptl.exercise.apex;

import java.util.*;

public class Wade {
    public static void main(String[] args) {
        Object[] input = { 'A', 'B', 'C', 1, 2, 3, '4', '5', 6, '@', '.', 'D' };

        List<Integer> integers = new ArrayList<>();
        List<Character> strings = new ArrayList<>();
        List<Character> chars = new ArrayList<>();

        for (Object obj : input) {
            if (obj instanceof Integer) {
                integers.add((Integer) obj);
            } else if (obj instanceof Character) {
                char c = (Character) obj;
                if (Character.isDigit(c)) {
                    integers.add(Character.getNumericValue(c));  // '4' → 4
                } else if (Character.isLetter(c)) {
                    strings.add(c);
                } else {
                    chars.add(c);
                }
            }
        }

        System.out.println("integer = " + integers);
        System.out.println("string = " + strings);
        System.out.println("chars = " + chars);

        // Follow-up: Split integers randomly into 2 arrays
        Random rand = new Random();
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        for (int num : integers) {
            if (rand.nextBoolean()) { //if true, add to arr1, false, add to arr2,  random boolean value
                arr1.add(num);
            } else {
                arr2.add(num);
            }
        }

        int sum1 = arr1.stream().mapToInt(i -> i).sum();
        int sum2 = arr2.stream().mapToInt(i -> i).sum();

        System.out.println("array_1 = " + arr1);
        System.out.println("array_2 = " + arr2);
        System.out.println("Sum array_1 = " + sum1);
        System.out.println("Sum array_2 = " + sum2);
    }
}
