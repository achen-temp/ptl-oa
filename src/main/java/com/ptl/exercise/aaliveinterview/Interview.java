package com.ptl.exercise.aaliveinterview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Interview {

    

        public static void main(String[] args) {
            Function<List<Integer>, Integer> function = x -> x
                .stream()
                .map(i -> i * 2)
                .mapToInt(i -> i)
                .distinct()
                .sum();
    
            Function<Integer, Integer> function2 = x -> x * 10;
            Function<Integer, Integer> function3 = x -> x * 100;
    
            int len = function.andThen(function2)
                .andThen(function3)
                .apply(Arrays.asList(1, 2, 2));
    
            System.out.println(len);
        }
    
    
    
    
}
