package com.ptl.exercise.aaliveinterview;

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

    public static void main(String[] args) {
        System.out.println(solution("01010")); // Output: 1
        System.out.println(solution("111000")); // Output: 0
        System.out.println(solution("111*000")); // Output: 7
    }
}