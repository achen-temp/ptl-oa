package com.ptl.exercise.inspyr;

import java.util.*;

public class MoveCars {



    /**
     * Given some cars and their coordinates in X and Y two list.
     * (x1, x2, x3) are X coordinate for car1, car2 and car3
     * (y1, y2, y3) are Y coordinate for car1, car2 and car3
     * Write code to find the minimum Fuel(distance) to move all the cars 
     * NEXT TO each other on X coordinates.
     * 
     * @param x
     * @param y
     * @return
     */
    public static int minimumFuel(List<Integer> x, List<Integer> y){
        
        if(x.isEmpty() || x.size() <= 1 || y.isEmpty() || y.size() <= 1 || x.size() != y.size()){
            return 0;
        }

        //move x -- find median,  generate new X
        //int medianX = findMedianHelper(x);
        List<Integer> newX = generateNewSequence(x);
        System.out.println("new sequence: " + newX);

        int medianY = findMedianHelper(y);
        System.out.println("median of Y: " + medianY);

        int result = 0;
        for(int i = 0; i < x.size(); i++){
            result += Math.abs(newX.get(i) - x.get(i)) + Math.abs(medianY - y.get(i));
        }

        return result;
    }

    private static int findMedianHelper(List<Integer> list){
        List<Integer> list2 = new ArrayList<>(list);
        Collections.sort(list2);
        int medianIndex = list2.size() / 2;
        return list2.get(medianIndex);
    }


    private static List<Integer> generateNewSequence(List<Integer> list){
        int median = findMedianHelper(list);
        List<Integer> result = new ArrayList<>();  //1,2,3,4
        //3 -- left2, right1,  left1, right2
        //odd ---left2, right2
        //find start, start + size
        //3, 3 - (size/2) --> 1, 2,3,4
        int start = median - (list.size() / 2);
        for(int i = start; i < start + list.size(); i++){
            result.add(i);
        }
        return result;
    }























    
    public static void main(String[] args) {
        List<Integer> x = List.of(2, 1, 5, 2);
        List<Integer> y = List.of(4, 4,4, 6);
        System.out.println(minimumFuel(x, y));
    }


    public static int minimalFuel(List<Integer> x, List<Integer> y){
        if(x.isEmpty() || x.size() <= 1 || y.isEmpty() || y.size() <= 1 || x.size() != y.size()){
            return 0;
        }

        //for x, we need to sort them and then put them next to each other with center at median value
        //the problem asks us to move all the cars next to each other, so the minimum cost to move them
        //is to move them together with center at median.
        List<Integer> newX = findSequence(x);
        int medianY = findMedian(y);

        System.out.println("new x " + newX);
        System.out.println("median of y " + medianY);

        int minFuel = 0;
        for(int i = 0; i < x.size(); i++){
            minFuel += Math.abs(x.get(i) - newX.get(i)) + Math.abs(medianY - y.get(i));
        }

        return minFuel;
    }

    public static int findMedian(List<Integer> list){
        List<Integer> list2 = new ArrayList<>(list);
        Collections.sort(list2);
        return list2.get(list2.size() / 2);
    }

    public static List<Integer> findSequence(List<Integer> list){
        int median = findMedian(list);
        int start = median - list.size() / 2;
        List<Integer> sequence = new ArrayList<>();
        for(int i = start ; i < start + list.size(); i++){
            sequence.add(i);
        }
        return sequence;
    }
}
