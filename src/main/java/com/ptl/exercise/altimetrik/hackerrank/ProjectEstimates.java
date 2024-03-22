package com.ptl.exercise.altimetrik.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProjectEstimates {

    public static Integer findPairsWithDifference(List<Integer> projectCosts, int target) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (int cost : projectCosts) {
            map.put(cost, map.getOrDefault(cost, 0) + 1);
        }

        for (int cost : projectCosts) {
            if (map.containsKey(cost - target)) {
                if ( (cost - target == cost && map.get(cost) > 1) || (cost - target != cost)) {
                    String comb1 = (cost - target) + "|" + cost;
                    String comb2 = cost + "|" + (cost - target);
                    if(!set.contains(comb1) && !set.contains(comb2)){
                        set.add(comb1);
                        set.add(comb2);
                        result++;
                    }
                }
            }
            if (map.containsKey(cost + target)) {
                if ( (cost + target == cost && map.get(cost) > 1) || (cost + target != cost)) {
                    String comb1 = (cost + target) + "|" + cost;
                    String comb2 = cost + "|" + (cost + target);
                    if(!set.contains(comb1) && !set.contains(comb2)){
                        set.add(comb1);
                        set.add(comb2);
                        result++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> projectCosts = Arrays.asList(1, 5, 3, 9, 7, 2, 8, 5, 5);
        int target = 2;
        int pairs = findPairsWithDifference(projectCosts, target);
        System.out.println("Pairs with difference " + target + ": " + pairs);
    }
}
