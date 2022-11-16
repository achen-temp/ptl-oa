package com.ptl.exercise.Infoway;

import java.util.*;
import java.util.stream.Collectors;

public class Algo_GroupWords extends Thread {

    //group string with same character
    public static void groupWords(List<String> words) {
        Map<String, List<String>> map = new LinkedHashMap<>();
        for (String word : words) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String mapKey = new String(arr);
            if (!map.containsKey(mapKey)) {
                map.put(mapKey, new ArrayList<>());
            }
            map.get(mapKey).add(word);
        }
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("EAT", "ATE", "TEA", "CAT", "RAT");
        groupWords(words);
    }
}
