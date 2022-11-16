package com.ptl.exercise.Redolent;

import java.util.*;

public class Algo_ArrangingCoins {

    public static void arrangeCoins(List<Long> coins) {
        if (coins == null || coins.size() == 0) {
            return;
        }

        for (long coin : coins) {
            long num = (long) Math.sqrt(2 * coin);

            if (num * (num + 1) <= 2 * coin) {
                System.out.println(num);
            } else {
                System.out.println(num - 1);
            }

        }
    }
    
}
