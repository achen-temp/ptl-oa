package com.ptl.exercise.ig.magnitGlobal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithms_MinimalTransactionsBetweenPerson {

    public static int getMinTransactions(int n, List<List<Integer>> debts) {
        int[] netAmounts = new int[n];
        for (List<Integer> debt : debts) {
            int from = debt.get(0);
            int to = debt.get(1);
            int amount = debt.get(2);

            netAmounts[from] -= amount;
            netAmounts[to] += amount;
        }
        List<Integer> debtors = new ArrayList<>();
        List<Integer> creditors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (netAmounts[i] > 0) {
                creditors.add(i);
            } else if (netAmounts[i] < 0) {
                debtors.add(i);
            }
        }
        int transactions = 0;
        while (!debtors.isEmpty() && !creditors.isEmpty()) {
            int debtorIndex = debtors.get(0);
            int creditorIndex = creditors.get(0);
            int debtAmount = Math.min(-netAmounts[debtorIndex], netAmounts[creditorIndex]);
            netAmounts[debtorIndex] += debtAmount;
            netAmounts[creditorIndex] -= debtAmount;
            if (netAmounts[debtorIndex] == 0) {
                debtors.remove(0);
            }
            if (netAmounts[creditorIndex] == 0) {
                creditors.remove(0);
            }
            transactions++;
        }
        return transactions;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> debts = Arrays.asList(
                Arrays.asList(1, 2, 15),
                Arrays.asList(3, 2, 14),
                Arrays.asList(0, 3, 10),
                Arrays.asList(3, 1, 20));

        int result = getMinTransactions(n, debts);
        System.out.println("Minimum number of transactions required: " + result);
    }
}
