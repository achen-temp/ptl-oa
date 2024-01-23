package com.ptl.exercise.ig.magnitGlobal;

import java.util.Arrays;
import java.util.List;

public class Algorithms_WarehouseManagerAllocateResource {

    public static void main(String[] args) {
        List<Integer> storageA = Arrays.asList(1, 2, 0, 4);
        List<Integer> storageB = Arrays.asList(4, 5, 0, 0, 1);
        System.out.println(minimumResources(storageA, storageB));

    }

    public static int minimumStorage(List<Integer> storageA, List<Integer> storageB) {
        if (storageA.isEmpty() || storageB.isEmpty()) {
            return -1;
        }
        int sum1 = storageA.stream().mapToInt(Integer::intValue).sum();
        int sum2 = storageB.stream().mapToInt(Integer::intValue).sum();
        long zero1 = storageA.stream().filter(a -> a == 0).count();
        long zero2 = storageB.stream().filter(a -> a == 0).count();

        if (sum1 == sum2) {
            if ((zero1 == 0 || zero2 == 0) && zero1 + zero2 != 0) {
                return -1;
            } // one input has no zero
            return sum1 + (int) Math.max(zero1, zero2);
        } else if (sum1 > sum2) {
            if (zero2 == 0) {
                return -1;
            } // just this if block
            return sum1 + (int) zero1;
        } else {
            if (zero1 == 0) {
                return -1;
            }
            return sum2 + (int) zero2;
        }
    }
}
