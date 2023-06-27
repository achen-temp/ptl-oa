package com.ptl.exercise.brillio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Coding {

    public static void main(String[] args) {
        int[] interval1 = new int[]{1,3};
        int[] interval2 = new int[]{2,4};
        int[] interval3 = new int[]{6,8};
        int[] interval4 = new int[]{9,10};
        List<int[]> intervals = Arrays.asList(interval1, interval2, interval3, interval4);
        List<int[]> merged = mergeIntervals(intervals);
        for(int[] interval: merged){
            System.out.println(interval[0] + "," + interval[1]);
        }

    }

    //Alfie Wei --- 06/23/2023 -- Brillio -- fullstack,  Sree.. is interviewer
    public static List<int[]> mergeIntervals(List<int[]> intervals){
        //so i just use 2 elements int array to represent the start and end of internals
        if(intervals == null || intervals.size() == 0){
            return intervals;
        }
        //sort
        Collections.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]); //sort by start and then end

        List<int[]> result = new ArrayList<>();
        result.add(intervals.get(0));

        for(int i = 1; i < intervals.size(); i++){
            int[] current = intervals.get(i);
            int[] last = result.get(result.size() - 1);
            if(current[0] <= last[1]){ //since interval only has start and end, so index 0 is start, index 1 is end.
                last[1] = current[1];
            }else{
                result.add(current);
            }
        }
        return result;
    }
}


