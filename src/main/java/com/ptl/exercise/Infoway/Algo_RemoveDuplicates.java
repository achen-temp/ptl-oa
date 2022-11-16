package com.ptl.exercise.Infoway;

import java.util.*;

public class Algo_RemoveDuplicates {

    public static List<String> removeDuplicates(List<String> list) {
        List<String> result = new ArrayList<>();
        for (String word : list) {
            String noDup = removeDup(word);
            result.add(noDup);
        }
        return result;
    }

    public static String removeDup(String s) {
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                sb.append(c);
                set.add(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Javaa", "class", "plublicc");
        List<String> result = removeDuplicates(list);
        System.out.println(result);
    }

}
