package com.ptl.exercise.airbnb;

public class RLEIterator {

    private static int[] rle;
    private static int index;
    private static int curr;

    public static int next(int k) {
        while(index < rle.length && k > rle[index]){
            k = k - rle[index];
            index += 2;
        }

        if(index > rle.length - 1){
            return -1;
        }else{
            rle[index] -= k;
            return rle[index + 1];
        }
    }

    public static void main(String[] args) {
        rle = new int[]{3,8,0,9,2,5};
        System.out.println(next(2));
        System.out.println(next(1));
        System.out.println(next(1));
        System.out.println(next(2));

        /*
        System.out.println(next(3));
        System.out.println(next(2));
        System.out.println(next(1));
        */
    }
}
