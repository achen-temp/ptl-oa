package com.ptl.exercise.ebay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class coding {
}

//date: 05/04/2023 - charlie lie
//interviewer: neha sharma

/**
 * problem: given array, find distance of current element to its next greater element
 * distance next greater element
 * Input: arr[] = {73, 74, 75, 71, 69, 72, 76, 73}
 * Output: {1, 1, 4, 2, 1, 1, 0, 0}
 * Input: arr[] = {73, 74, 75, 71, 69, 72, 76, 73}
 * Output: {1, 1, 4, 2, 1, 1, 0, 0}
 */
class CharlieLi052023{



    /**
     * stack store index of current element
     * loop from 0 - end: 每一个位置，如果比stack top小，那肯定不是next greater，所以要add to stack
     * 如果比stack 顶大，那就把stack一直往外pop，直到stack top比当前大，那么pop出来的elemnt的next greater都是当前element
     * 每个pop出来的elemnt的index - current index = distance，
     * 当一直pop到stack top比当前的要大，那么就把当前的加到stack，然后继续往下找。
     * 比如9,8,7,6,5,8,7,10
     * 9，8，7，6,5降序一直加到stack，那么stack就是index of 9,8,7,6,5
     * 下一个8，肯定是7,6,5的next greater，所以算出来7,6,5 distance = 3,2,1。
     * 把7,6,5 pop out. and add 8, so stack is index of 9,8 + 8 = 9,8,8
     * next is 7, stack is  index of 9,8,8,7
     * next is 10, we can calculate distance for 9,8,8,7
     * @param nums
     * @return
     *10 --- 0
     * 7,   1   7,10
     * 8,   2,   8,10
     * 5,        5,8,10
     *
     */
    //find the distance to next greater element
    public static int[] nextGreater(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(stack.isEmpty() || nums[i] <= nums[stack.peek()]){
                stack.push(i);
            }else{
                while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                    int index = stack.pop();
                    result[index] = i - index;
                }
                stack.push(i);
            }
        }
        return result;
    }

    //find next greater element
    public static int[] findNextGreaterElement(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(stack.isEmpty() || nums[i] <= nums[stack.peek()]){
                stack.push(i);
            }else{
                while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                    int index = stack.pop();
                    result[index] = nums[i]; //this is the only difference
                }
                stack.push(i);
            }
        }
        return result;
    }

    //LC240
    public static boolean findTarget(int[][] matrix, int target){
        int row=matrix.length-1;
        int col=0;
        // 当坐标在矩阵范围内时，查找target
        while(row>=0&&col<matrix[0].length){
            // 如果当前数字等于target，返回true
            if(matrix[row][col]==target) {
                return true;
            }
            // 如果当前数字大于target，行减一
            if(matrix[row][col]>target) {
                row--;
            } else{
                col++; // 如果当前数字小于target，列加一
            }
        }
        return false;
    }

    public static List<Integer> findRepeatingZeros(){
        int[] nums = {0,0,1,2,3,5,6,0,0,8,0,0};
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 1; i++) {

            if (nums[i] == 0 && nums[i + 1] == 0) {
                result.add(i);
            }
            if (i != 0 && nums[i - 1] == 0 && nums[i] == 0 && nums[i + 1] != 0) {
                result.add(i);
            }
        }
        if(nums[nums.length - 1] == 0 && nums[nums.length - 2] == 0){
            result.add(nums.length - 1);
        }
        System.out.println(result);
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = findNextGreaterElement(arr);
       // System.out.println(Arrays.toString(result));
        System.out.println(findRepeatingZeros());
    }
}

class HarveyLin052023{
    /*
    HARVEY-LIN-EBAY-CLIENT-R1-05/18/2023
1. tell me your biggest project and WHY do you like it
2. coding: findNextGreaterElementDistance (
   1.Given example and walk through the example with your logic
   2.time and space complexity
3. given matrix, each row is increasing from left to right.
   next row beginning is larger than previous row end
   Find if a target exists in the matrix --- binary search
4. have you used microservices
5. you ask interviewer a question
HARVEY-LIN-EBAY-CLINET-R2--05/22/2023
1. Have you used java OOP concepts and design patterns
2. how do you increase performance in database side?
3. coding: given array in ascending order, find their squares in ascending order (-4,-3,1,2) --> {1,4,9,16}
   1. corner case: -4 and 4 have same squares, how do you handle
   2. add exception if the input array is null or empty, throw the exception
   3. time and space complexity
   4. If we just square all elements and then sort them.. Is this solution better than your two pointers solution? -- my solution 2 pointers is bettter bexcause it is O(n), your sorting is O(nlogn)
     */
}

class AlfieLi082023{
    /**
     * 1. how kafka keep message in order
     * 2. how producer send message in order
     * 3. how to find a deadlock
     * 4. Coding1:  find Repeating Zeros indexes,  O(n), only 1 collection allowed
     * {0,0,2,3,4,5,0,0,8,9,0,0,0} -- return {0,1,6,7,10,11,12}
     * 5. Coding2: write a deadlock
     * 6. How do you debug a code if log has no error
     * 7. how do you quickly adapt to large Legacy code system
     */
}