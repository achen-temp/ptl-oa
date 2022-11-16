package com.ptl.exercise.Altimetrik;

//print 1 to n in two thread, even and odd
class MyRunnable implements Runnable {
    public int n;
    public int num;
    public boolean printEven;

    static Object lock = new Object();

    public MyRunnable(int num, int n, boolean printEven) {
        this.n = n;
        this.num = num;
        this.printEven = printEven;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (num <= n) {
                if (num % 2 != (printEven ? 1 : 0)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                    }
                } else {
                    System.out.print(num + ",");
                }
                lock.notifyAll();
                num++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyRunnable(1, 10, false));
        Thread t2 = new Thread(new MyRunnable(1, 10, true));
        t1.start();
        t2.start();
    }
}

//print 1 to n in two thread, even and odd
class MyClass {
    public int start;
    public int end;

    public MyClass(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public synchronized void printNumber(boolean isEven) {
        while (start < end) {
            if (start % 2 == (isEven ? 1 : 0)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(start++ + ",");
            notify();
        }
    }

    public static void main(String[] args) {
        int start = 1, end = 10;
        MyClass solution = new MyClass(start, end);
        Thread t1 = new Thread(() -> solution.printNumber(true));
        Thread t2 = new Thread(() -> solution.printNumber(false));
        t1.start();
        t2.start();
    }
}

public class Coding {

    //convert string number to integer "123 -> 123
    public static int convert(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '-') {
            return (-1) * convert(s.substring(1));
        }

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            result = result * 10 + num;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "-123";
        int result = convert(s);
        System.out.println(result);
    }
}
