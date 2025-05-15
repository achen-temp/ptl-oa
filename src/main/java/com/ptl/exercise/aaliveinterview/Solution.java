package com.ptl.exercise.aaliveinterview;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    public static int solution(String s) {
        // Use a pointer to simulate stack behavior
        int pointer = -1; // Points to the last valid position in our simulated stack
        char[] chars = s.toCharArray();

        for (char ch : chars) {
            // If pointer is at a valid position and the current character pairs with the character at 'pointer'
            if (pointer >= 0 && ((chars[pointer] == '0' && ch == '1') || (chars[pointer] == '1' && ch == '0'))) {
                pointer--; // "Pop" the last character as we found a 0-1 or 1-0 pair
            } else {
                pointer++; // Move the pointer forward and "push" the character
                chars[pointer] = ch; // Place current character at the new "top" of the stack
            }
        }

        return pointer + 1; // The size of the remaining characters represents the smallest string length
    }


    public static int longestSubstring(String s) {
      if(s == null || s.length() == 0){
           return 0;
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
                // longest = Math.max(longest, right - left); //update longest
                if(right - left > longest){
                    longest = right - left;
                    result = s.substring(left, right);
                }
            }else{ //c is already in set, we need to move left to shrink the window
                 char leftChar = s.charAt(left);
                 set.remove(leftChar);
                 left++;  //update left and remove left character from set
            }
      }

      System.out.println(result);
      return longest;
   
    }


    public static void main(String[] args) {
        System.out.println(longestSubstring("abcabcdabc"));
    }
}