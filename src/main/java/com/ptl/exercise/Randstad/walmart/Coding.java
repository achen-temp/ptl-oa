package com.ptl.exercise.randstad.walmart;

import java.util.*;

public class Coding {

    //two sorted array,  - find Kth smallest
    //if there are two duplicates, only consider once
    //[1,2,2,3] -- 3rd smallest should be 3, not 2
    public static int kthSmallest(int[] nums1, int[] nums2, int k){
        if(nums1 == null || nums2 == null){
            return -1; //
        }
        if(nums1.length + nums2.length <= k){
            return Math.max(nums1[nums1.length-1], nums2[nums2.length - 1]);
        }
        int p1 = 0, p2 = 0;
        while(p1 < nums1.length && p2 < nums2.length && k > 0){
            while(p1 < nums1.length - 1 && nums1[p1] == nums1[p1+1]){
                p1++;
            }
            while(p2 < nums2.length - 1 && nums2[p2] == nums2[p2+1]){
                p2++;
            }
            if(k == 1){
                return Math.min(nums1[p1], nums2[p2]);
            }else if(nums1[p1] == nums2[p2]){
                p1++;
                p2++;
                k--;
            }else{
                if(nums1[p1] < nums2[p2]){
                    p1++;
                }else{
                    p2++;
                }
                k--;
            }
        }

        while( k > 0 && p1 < nums1.length){
            while(p1 < nums1.length - 1 && nums1[p1] == nums1[p1+1]){
                p1++;
            }
            if(k == 1){
                return nums1[p1];
            }else{
                p1++;
                k--;  //check line 29 k--
            }
        }

        while( k > 0 && p2 < nums2.length){
            while(p2 < nums2.length - 1 && nums2[p2] == nums2[p2+1]){
                p2++;
            }
            if(k == 1){
                return nums2[p2];
            }else{
                p2++;
                k--;  //check line 29 k--
            }
        }
        return Math.max(nums1[nums1.length-1], nums2[nums2.length - 1]);
    }



    public static void main(String[] args){
        int[] nums1 = {1,3,3,3}; //his exaple
        int[] nums2 = {3,4,5,5,5,5,5,5,6,7,8}; //his
        int k = 5;
        int result = kthSmallest(nums1, nums2, k);
        System.out.println(result);
    }


}
