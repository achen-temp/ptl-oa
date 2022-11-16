package com.ptl.exercise.Aditi;

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
