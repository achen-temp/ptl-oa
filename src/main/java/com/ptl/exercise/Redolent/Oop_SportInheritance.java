package com.ptl.exercise.Redolent;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Oop_SportInheritance {

    public static void main(String[] args) {
        //int[] cricketAges = {26, 32, 36, 33, 24, 31, 30, 35, 36, 21, 28};
        int[] cricketAges = {26, 26, 26, 26, 26, 26, 26, 26, 26, 26, 26};
        int[] footballAges = {32, 21, 27, 35, 24, 36, 31, 25, 23, 30, 22};
        int[] retire = {11, 7, 6, 1, 1};
        int fee = 659;
        int transferId = 5;
        Oop_SportInheritance solution = new Oop_SportInheritance();
        Cricket crickeTeam = solution.new Cricket();
        Football footballTeam = solution.new Football();
        crickeTeam.calculateAvgAge(cricketAges);
        footballTeam.calculateAvgAge(footballAges);
        for (int id : retire) {
            footballTeam.retirePlayer(id);
        }
        footballTeam.playerTransfer(fee, transferId);
    }

    interface Sport {
    }

    class Cricket implements Sport {
        int[] playerIDs; //1-based

        public Cricket() {
            playerIDs = new int[11];
            Arrays.fill(playerIDs, 1);
            System.out.println("A new cricket team has been formed");
        }

        public void calculateAvgAge(int[] age) {
            int totalAge = Arrays.stream(age).sum();
            double avgAge = totalAge * 1.0 / age.length;
            double result = (double) (Math.round(avgAge * 100)) / 100.0;
            DecimalFormat df = new DecimalFormat("#0.00"); //need import java.text.DecimalFormat on top
            String resultstr = df.format(result);
            System.out.println("The average age of the team is " + resultstr);
        }

        public void retirePlayer(int id) {
            int index = id - 1;
            if (playerIDs[index] == -1) {
                System.out.println("Player has already retired");
            } else {
                playerIDs[index] = -1;
                System.out.println("Player with id: " + id + " has retired");
            }
        }
    }

    class Football implements Sport {
        int[] playerIDs; //1-based

        public Football() {
            playerIDs = new int[11];
            Arrays.fill(playerIDs, 1);
            System.out.println("A new football team has been formed");
        }

        public void calculateAvgAge(int[] age) {
            int totalAge = Arrays.stream(age).sum();
            double avgAge = totalAge * 1.0 / age.length;
            double result = (int) (Math.round(avgAge * 100)) / 100.0;
            DecimalFormat df = new DecimalFormat("#0.00");
            String resultstr = df.format(result);
            System.out.println("The average age of the team is " + resultstr);
        }

        public void retirePlayer(int id) {
            int index = id - 1;
            if (playerIDs[index] == -1) {
                System.out.println("Player has already retired");
            } else {
                playerIDs[index] = -1;
                System.out.println("Player with id: " + id + " has retired");
            }
        }

        public void playerTransfer(int fee, int id) {
            int index = id - 1;
            if (playerIDs[index] == 1) {
                System.out.println("Player with id: " + id + " has been transferred with a fee of " + fee);
            } else if (playerIDs[index] == -1) {
                System.out.println("Player has already retired");
            }
        }
    }
}
