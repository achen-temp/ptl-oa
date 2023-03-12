package com.ptl.exercise.Ubs;

//Edward Yin - Chris meng - 1/5/2023
//Weehaukee NJ
public class Interview {

    //1. asked about threads basics, wait vs sleep
    //2. spring boot annotations,
    //3. JPA how it works
    //4. Anonymous class
    //5. Redis vs JumpFile

    /**
     * Coding, Use 3 threads to print 0,1,0,2,0,3,0,4
     * thread 1 print 0, thread 2 print odd, thread 3 print even
     * -- he asked to use two threads to print 1,2,3,4...
     * -- completed coding 2 threads then he asked java spring questions
     * -- didnot get chance to work on 3 threads problem
     */
}

//Use 3 threads to print 0,1,0,2,0,3,0,4
class ThreeThreads {
    public int start;
    public int end;
    boolean shouldPrint0 = true;

    public ThreeThreads(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public synchronized void printNumber(String name, int toPrint) {
        while (start <= end) {
            if (shouldPrint0) {
                if (toPrint == 0) { //print
                    //System.out.println(name + ":" + 0);
                    System.out.print(0 + ",");
                    shouldPrint0 = false;
                    notifyAll();
                } else {
                    threadWait();
                }
            } else {
                if (start % 2 == 1) { //should print odd
                    if (toPrint == 1) { //current thread toPrint is 1 -- found match
                        //System.out.println(name + ":" + start++);
                        System.out.print(start++ + ",");
                        shouldPrint0 = true;
                        notifyAll();
                    } else {
                        threadWait();
                    }
                } else { //should print even
                    if (toPrint == 2) {
                        //System.out.println(name + ":" + start++);
                        System.out.print(start++ + ",");
                        shouldPrint0 = true;
                        notifyAll();
                    } else {
                        threadWait();
                    }
                }
            }
        }
    }

    public void threadWait() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int start = 1, end = 10;
        ThreeThreads solution = new ThreeThreads(start, end);
        Thread t0 = new Thread(() -> solution.printNumber("t0", 0)); //print 0
        Thread t1 = new Thread(() -> solution.printNumber("t1", 1)); //print odd
        Thread t2 = new Thread(() -> solution.printNumber("t2", 2)); //print even
        t0.start();
        t1.start();
        t2.start();
    }
}
