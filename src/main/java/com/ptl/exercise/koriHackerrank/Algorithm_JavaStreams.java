package com.ptl.exercise.koriHackerrank;


import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * Implement your Filter and Mapper class here
 */
//YOUR CODE START FROM HERE -----------
class Filter{
    public static Predicate<String> nameStartingWithPrefix(String prefix){
        return s -> s.startsWith(prefix); //need to import java.util.function.*;
    }
}

class Mapper{
    public static Function<String, CharactersCount> getDistinctCharactersCount(){
        return s -> {
            int count = (int) s.chars().distinct().count();
            return new CharactersCount(s, count);
        };
    }
}
//YOUR CODE END HERE ----------------------
//ABOVE IS YOUR CODE, BELOW ARE ALL GIVEN....
class CharactersCount{
    private final String name;
    private final Integer distinctCharacterCount;

    public CharactersCount(String name, Integer distinctCharacterCount){
        this.name = name;
        this.distinctCharacterCount = distinctCharacterCount;
    }

    @Override
    public String toString(){
        return "\"" + this.name + "\" has " + this.distinctCharacterCount + " distinct characters.";
    }
}

public class Algorithm_JavaStreams {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
          "aaryanna",
          "aayanna",
          "bob",
          "alice",
          "aa",
          "chelsea",
          "edward",
          "hanna"
        );

        names.stream().filter(Filter.nameStartingWithPrefix("aa"))
                .map(Mapper.getDistinctCharactersCount())
                .forEachOrdered(System.out :: println);
    }
}
