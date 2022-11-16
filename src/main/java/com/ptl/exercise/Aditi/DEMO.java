package com.ptl.exercise.Aditi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Test2 {
    public static void main(String[] args) {
        //int[][] matrix = {{1, 1, 1, 1}, {1, 0, 1, 0}, {0, 1, 0, 1}, {0, 0, 0, 0}};
        int[][] matrix = {{1, 1, 1, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        int m = 4, n = 4;
        getNearest(matrix, m, n);
    }

    public static void getNearest(int[][] matrix, int m, int n) {
        int[][] dist = new int[m][n];
        int[] stepx = {-1, 0, 1, 0};
        //int[] stepx = {-1, 1, 1, -1, -1, 0, 1, 0};
        int[] stepy = {0, -1, 0, 1};
        //int[] stepy = {1, -1, 1, -1, 0, -1, 0, 1};

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dist[i][j] = 0;
                    q.add(new Pair(i, j));
                } else {
                    dist[i][j] = m + n;
                }
            }
        }
        while (!q.isEmpty()) {
            Pair tmp = q.remove();
            int x = tmp.key, y = tmp.value;

            for (int i = 0; i < 4; i++) {
                int newx = x + stepx[i];
                int newy = y + stepy[i];

                if (0 <= newx && newx < m && 0 <= newy && newy < n
                        && dist[newx][newy] > dist[x][y] + 1) {
                    dist[newx][newy] = dist[x][y] + 1;
                    q.add(new Pair(newx, newy));
                }
            }
        }
        for (int[] v : dist) {
            System.out.println(Arrays.toString(v));
        }
    }
}

class Pair {
    int key;
    int value;

    public Pair(int k, int v) {
        key = k;
        value = v;
    }
}

public class DEMO {

    private String name;

    public static void main(String[] args) {
        DEMO m1 = new DEMO();
        DEMO m2 = new DEMO();
        m1.name = m2.name = "m1";
        callMe(m1, m2);
        System.out.println(m1.name + " & " + m2.name);
    }

    private static void callMe(DEMO... m) {
        m[0] = m[1];
        m[1].name = "new name";
    }
}
