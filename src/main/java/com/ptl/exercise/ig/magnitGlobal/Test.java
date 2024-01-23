package com.ptl.exercise.ig.magnitGlobal;

public class Test {

    final int MAX_VALUE;

    public Test(){
        MAX_VALUE = 1;
    }
    
    public static void main(String[] args) throws InterruptedException{
        // Create an array to store the threads
        Thread[] threads = new Thread[6];

        // Create and start six threads
        for (int i = 0; i < 6; i++) {
            threads[i] = new IncrementThread();
            threads[i].start();
            threads[i].join();
        }

        // Print the final count
        System.out.println("Final Count: " + counter);
    }

    static int counter = 0;

    // Thread class to increment the shared counter
    private static class IncrementThread extends Thread {
        @Override
        public void run() {
            counter++;
            System.out.println(counter);
        }
    }
}
