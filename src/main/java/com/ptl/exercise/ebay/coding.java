package com.ptl.exercise.ebay;

import java.util.Arrays;
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

    public static void printDistances(int[] arr) {
        int n = arr.length;
        int[] dist = new int[n]; // array to store distances
        Arrays.fill(dist, 0); // initialize all distances to 0
        Stack<Integer> stack = new Stack<Integer>(); // stack to store indices

        // loop through the array from left to right
        for (int i = 0; i < n; i++) {
            // if the current element is greater than the element at the top of the stack,
            // then pop elements from the stack and calculate the distance
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                int index = stack.pop();
                dist[index] = i - index;
            }
            stack.push(i); // push current index to the stack
        }

        // remaining elements in the stack have no next greater element
        while (!stack.isEmpty()) {
            int index = stack.pop();
            dist[index] = 0;
        }

        // print the distances for each element
        for (int i = 0; i < n; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        printDistances(arr);
    }
}