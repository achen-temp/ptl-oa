package com.ptl.exercise.ig.magnitGlobal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Algorithms_CountCountries {
    public static List<List<String>> solve(List<List<String>> a) {
        // Create a map to count occurrences of each country
        Map<String, Integer> countryCount = new HashMap<>();

        // Iterate over the input list
        for (List<String> entry : a) {
            String country = entry.get(1);
            if (!country.equals("-1")) {
                countryCount.put(country, countryCount.getOrDefault(country, 0) + 1);
            }
        }

        // Create a list to store the result
        List<List<String>> result = new ArrayList<>();

        // Add entries to the result list
        for (Map.Entry<String, Integer> entry : countryCount.entrySet()) {
            List<String> countryEntry = new ArrayList<>();
            countryEntry.add(entry.getKey());
            countryEntry.add(String.valueOf(entry.getValue()));
            result.add(countryEntry);
        }

        // Sort the result list alphabetically by country name
        result.sort((o1, o2) -> o1.get(0).compareTo(o2.get(0)));

        return result;
    }



    public static void main(String[] args) {
        List<List<String>> input = Arrays.asList(
            Arrays.asList("0", "China"),
            Arrays.asList("1", "Cuba"),
            Arrays.asList("2", "-1"),
            Arrays.asList("3", "Cuba"),
            Arrays.asList("4", "-1"),
            Arrays.asList("5", "-1"),
            Arrays.asList("6", "Cuba"),
            Arrays.asList("7", "Germany"),
            Arrays.asList("8", "Germany"),
            Arrays.asList("9", "China")
        );

        List<List<String>> output = solve(input);
        for (List<String> row : output) {
            System.out.println(row.get(0) + " " + row.get(1));
        }
    }

}
