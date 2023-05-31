package com.ptl.exercise;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EarningWarnings {
}

class JamesShen052023{
    /**
     * word count with java 8
     */
    public static void wordCount(String s){
        Arrays.stream(s.toLowerCase().split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Long.compare(e1.getValue(), e2.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));
    }

    public static void main(String[] args) {
        wordCount("Repetition of Words. The last word of a clause or sentence is repeated as the first word of the next one. Example: \"Fear leads to anger; anger leads to hatred; hatred leads to conflict; conflict leads to suffering.\" — Yoda, in Star Wars Episode I: The Phantom Menace.");
    }
}
