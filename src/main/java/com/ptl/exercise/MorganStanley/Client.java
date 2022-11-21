package com.ptl.exercise.MorganStanley;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Client {



    //input: "Alex,25 John,14  Doyle,48"
    //output: "John,14 Alex,25 Doyle,48"
    public static void main(String[] args) {
        String input = "Alex,25 John,14  Doyle,48";
        String result = Arrays.stream(input.split("\\s+"))
                .map(item -> item.split(","))
                .sorted((arr1, arr2) -> Integer.valueOf(arr1[1]) - Integer.valueOf(arr2[1]))
                .map(arr -> arr[0] + "," + arr[1])
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }
}
