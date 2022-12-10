package com.ptl.exercise.MorganStanley;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Client {

    //Round 1: asked about Angular and backend common things
    //below coding, complete using regular coding, but could also use jaca 8
    // --> input: "Alex,25 John,14  Doyle,48"
    // --> output: "John,14 Alex,25 Doyle,48"
    public static void main(String[] args) {
        String input = "Alex,25 John,14  Doyle,48";
        String result = Arrays.stream(input.split("\\s+"))
                .map(item -> item.split(","))
                .sorted((arr1, arr2) -> Integer.valueOf(arr1[1]) - Integer.valueOf(arr2[1]))
                .map(arr -> arr[0] + "," + arr[1])
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }

    //Round 2: Onsite:
    /**
     * 1. rewrite round 1 problem in Java 8 and explain meaning of each step
     * 2. OOD: design parking lot (also design database table for it)
     * 3. Using Mockito to write test case for above parking lot
     * 4. What is facade design pattern, explain it because Morgan Stanley use it a lot
     * 5. Talk about projects in Resume - exact projects in details.
     * 6. Other small questions, difference between Mock and Spy
     */
}
