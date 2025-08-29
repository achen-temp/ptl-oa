package com.ptl.exercise.apple;

import java.util.Arrays;

/*
 * Write a program to implement your own ArrayList class. It should contain
 * add(), get(), remove(), size() methods. It should incrase its size
 */
public class Solution {

    private int capacity;     //total capacity of internal array
    private double refactor;  //refactor when size limit reached
    private Object[] data;     //current size of the current array
    private int size;

    public Solution(){
        this.capacity = 10;
        this.refactor = 2;  
        this.size = 0; 
        this.data = new Object[capacity];  
    }

    public void add(Object o){
        if(size == capacity){
            /* 
            this.capacity *= refactor;
            Object[] newData = new Object[capacity];
            for(int i = 0; i < size; i++){
                newData[i] = data[i];
            }
            data = newData;
            */
            this.capacity *= refactor;
            data = Arrays.copyOf(data, capacity);
        }
        data[size++] = o;
    }

    public Object get(int i){
        if(i < 0 || i >= size){
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        return data[i];
    }

    public boolean remove(Object o){
        for(int i = 0; i < size; i++){
            if(o == data[i]){
                for(int j = i + 1; j < size; j++){
                    data[j - 1] = data[j];
                }
                return true;
            }
        }
        return false;
    }
    
    public int size(){
        return this.size;
    }

    public static void main(String[] args) {
        Solution arrayList = new Solution();
        arrayList.add("Hello, World!");
        arrayList.add(1234);
        arrayList.add(true);
        System.out.println(arrayList.capacity);
        System.out.println(arrayList.size);
        printSolution(arrayList);

        arrayList.add(1000000);
        arrayList.add(false);
        System.out.println(arrayList.capacity);
        System.out.println(arrayList.size);
        printSolution(arrayList);

    }

    /*
     * follow up: 
     * 1. add "null", how do you handle.
     * 2. print capacity - after refactor, and size..
     * 3. when resize, how to copy directly instead of for loop?
     */

    private static void printSolution(Solution arrayList){
        System.out.println();
        for(int i = 0; i < arrayList.size(); i++){
            Object o = arrayList.get(i);
            System.out.println(o);
        }
    }
}
