package com.ptl.exercise.aaliveinterview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Interview {


    public static int drawTimes(int[] nums1, int[] nums2){
        if(nums1 == null || nums2.length == 0 || nums2 == null || nums2.length == 0){
            return 0;
        }
        int len1 = nums1.length;
        int sum = 0;
        int res = 0;
        for(int i = 0; i < nums2.length; i++){
            int num = nums2[i];
            if(sum + num <= len1){
                sum += num;
                res++;
            }else{
                break;
            }
        }
      
        return res;
    }

    

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6,7,8,9,10};
        int[] nums2 = {2,3,6};
        System.out.println(drawTimes(nums1, nums2));
    }
    
    
    
    
}
