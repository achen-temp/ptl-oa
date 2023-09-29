package com.ptl.exercise.Aditi;

import java.util.Arrays;
import java.util.List;

interface CanHop {
}

class Frog implements CanHop {
    public static void main(String[] args) {
        Frog frog = new TurtleFrog();
    }
}

class BrazilianHornedFrog extends Frog {
}

class TurtleFrog extends Frog {
}


public class Test {

    public static void getNearet(int[] matrix, int m, int n) {
        int[][] dist = new int[m][n];
        int[] stepx = {-1, 1, 1, -1};
        int[] stepy = {1, -1, 1, -1};

    }
}
@FunctionalInterface
interface NumberComparator{
    boolean compareNumbers(int x, int y);
}

class Feifei{
    public static void main(String[] args) {
        List<String> javaVersions = Arrays.asList("java 6", "java 7", "java 8");
        boolean flag = javaVersions.stream().allMatch(str -> {
            System.out.println("Testing: " + str);
            return str.contains("8");
        });
        System.out.println(flag);
    }
}
