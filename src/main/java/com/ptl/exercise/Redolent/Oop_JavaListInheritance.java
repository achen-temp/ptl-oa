package com.ptl.exercise.redolent;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// (given)
interface MyList {
    void convert(String[] a);
    void replace(int idx);
    ArrayList<String> compact();
}

// Custom exception
class InvalidStringException extends Exception {
    public InvalidStringException(String message) {
        super(message);
    }
}

// ArrayToList class implementing MyList
class ArrayToList implements MyList {
    ArrayList<String> arrayToList;

    public ArrayToList() {
        arrayToList = new ArrayList<>();
    }

    public void convert(String[] a) {
        for (int i = 0; i < a.length; i++) {
            arrayToList.add(a[i]);
            System.out.println("I have added the string: " + a[i] + " at the index: " + i); //注意空格
        }
    }

    public void replace(int idx) {
        if (idx >= 0 && idx < arrayToList.size()) {
            String original = arrayToList.get(idx);
            arrayToList.set(idx, "");
            System.out.println("I have replaced the string: " + original + " with a null string");//注意空格
        }
    }

    public ArrayList<String> compact() {
        ArrayList<String> result = new ArrayList<>();
        for (String s : arrayToList) {
            if (!s.equals("")) {
                result.add(s);
            }
        }
        return result;
    }
}

// (given)
public class Oop_JavaListInheritance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random(0);

        int n = Integer.parseInt(sc.nextLine());
        String[] a = new String[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextLine();

        MyList obj = new ArrayToList();
        obj.convert(a);

        int x = rand.nextInt(n);
        for (int i = 0; i < x; i++)
            obj.replace(rand.nextInt(n));

        ArrayList<String> s = obj.compact();

        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).charAt(0) >= 97 && s.get(i).charAt(0) <= 122) {
                try {
                    throw new InvalidStringException("This is an invalid string");
                } catch (InvalidStringException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
