package com.ptl.exercise.cvs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Alfie {

    static List<Item> items = Arrays.asList(
            new Item("101", "Apple", "1.99"),
            new Item("102", "Banana", "0.99"),
            new Item("103", "Orange", "5.50"),
            new Item("104", "Mango", "6.25"),
            new Item("105", "Grapes", "4.75"),
            new Item("106", "Peach", "5.00"),
            new Item("103", "Orange", "5.50"), // duplicate
            new Item("103", "Orange", "5.50"),
            new Item("104", "Mango", "6.25"), // duplicate
            new Item("104", "Mango", "6.25"),
            new Item("107", "Pineapple", "7.99"),
            new Item("108", "Watermelon", "3.99"),
            new Item("109", "Kiwi", "5.01"));

    static class Item {
        String itemId;
        String name;
        String price;

        public Item(String itemId, String name, String price) {
            this.itemId = itemId;
            this.name = name;
            this.price = price;
        }

    }

    private static void lambdaTest() {
        // 1. remove duplcates from itemlist
        // solution 1, use filter with set
        Set<String> set = new HashSet<>(); // becxause set.add method return false if contains
        items.stream().filter(item -> set.add(item.itemId)).collect(Collectors.toList());

        // solution 2. override equals and hashcode in item class, so we can use distinct
        items.stream().distinct().collect(Collectors.toList());

        //solution 3. use collectors.toMap
        List<Item> distinctItems = new ArrayList<>(
                items.stream()
                        .collect(Collectors.toMap(
                                i -> i.itemId,
                                Function.identity(),
                                (existing, replacement) -> existing // or replacement to keep last
                        ))
                        .values());
        
        distinctItems.forEach(item -> System.out.println(item.itemId));


        //problem 2: filter with price greater than 5
        List<Item> filtered = items.stream().filter(item -> Double.parseDouble(item.price) > 5.00).collect(Collectors.toList());
        filtered.forEach(item -> System.out.println(item.itemId + " " + item.name + " " + item.price));
    }

    public static void main(String[] args) {

        // 1. how to filter the duplicates
        lambdaTest();

        //2. longest substring without repeatig character
        System.out.println(lengthOfLongestSubstring("Aeta, a cvs healthcare provider"));
    }


 
    //longest substring
    
    public static String lengthOfLongestSubstring(String s) {
      if(s == null || s.length() == 0){
           return s;
      }
      Set<Character> set = new HashSet<>();
      
      int left = 0;
      int right = 0;
      int longest = Integer.MIN_VALUE; //hold result
      String result = "";
      
      while(left <= right && left < s.length() && right < s.length()){
            char c = s.charAt(right);
            //below we check if c is already in set, if not, we update "longest"
            if( ! set.contains(c)){
                 set.add(c);
                 right++;
                 //longest = Math.max(longest, right - left); //update longest
                 int current = right - left;
                 if(current > longest){
                    longest = current;
                    result = s.substring(left, right);
                 }
            }else{ //c is already in set, we need to move left to shrink the window
                 char leftChar = s.charAt(left);
                 set.remove(leftChar);
                 left++;  //update left and remove left character from set
            }
      }
      return "'" + result + "'" +  " with length " + longest;
   
    }


}
