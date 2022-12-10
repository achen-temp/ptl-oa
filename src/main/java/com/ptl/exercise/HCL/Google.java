package com.ptl.exercise.HCL;

import java.util.*;

public class Google {

    //Two sum - print Unique all pairs
    public static List<int[]> twoSum(int[] nums, int target) {
        //corner case
        if(nums == null || nums.length <= 1){
            return new ArrayList<>();
        }

        Map<Integer, Integer> map = new HashMap<>();

        List<int[]> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>(); //for unique pairs only
        for(int i=0; i < nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff) && !visited.contains(diff)){
                int[] pair = new int[2];
                pair[0] = nums[i];
                pair[1] = diff;
                result.add(pair);
                map.remove(nums[i]); //need to remove visited entries
                visited.add(diff);
                visited.add(nums[i]);
            }else{
                map.put(nums[i], diff);
            }
        }

        return result;

    }

    //2: System design -- Design an autocomplete system
    //Trie
    //https://dzone.com/articles/how-to-design-a-autocomplete-system

    public static void main(String[] args) {
        int[] nums = {6,6,6,6,6,6,9,7,4,3,5,8};
        int target = 12;
        List<int[]> results = twoSum(nums, target);
        for(int[] pair : results){
            System.out.print(Arrays.toString(pair) + ";");
        }
    }
}
