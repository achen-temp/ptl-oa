package com.ptl.exercise.codebase;
import java.util.*;

public class oa {


    /*
      Q: Match the following components of a command pattern with their correct purposes.
      1. Command          A. Knows how to execute a command
      2. Receiver         B. Does the work when execute() method is called
      3. Invoker          C. Decides which commands to execute at which points
      4. Client           D. Invokes a method of the receiver

      Q: Liskovs substition principles states that if a class B is a subtype of class A,
      ...
      A:  It means that if the object of type A can do something, the object of type B
          could also be able to perform the same thing

      Q: Determine the correct class name that should be entered to throw CustomException
         public class CustomException extends
      A:  WebApplicationException

      Q: "Computer" table
      A: same object

      Q: Harry want to find siblings
      A: see code below
     */

    public static void main(String[] args) {
        int[] input2 = {3,5,6,4,1,2,8,9};
        for(int num : input2){
            int[] result = siblingSearch(input2.length, input2, num);
            System.out.println(Arrays.toString(result));
        }


    }

    /**
     *
     * @param input1: length of input2
     * @param input2: an array representing a level order tree
     * @param input3: target
     * @return  [] represents all siblings of target, [-1] if not siblings
     *     4
     *   3    1
     * 2  6  5
     *
     * input1 = 6 (length is 6)
     * input2 = [4,,3,1,2,6,5]
     *
     * input3 = 4 --- > [-1] because 4 does not have siblings
     * input3 = 3 ----> [1] beccause 1 is sibling of 3 - they are at same level
     * input3 = 1 -----> [3]
     * input3 = 2 ------> [6,5] because 6 and 5 are both at same level as 2
     * input3 = 6 ------> [2,5]
     * input3 = 5 ------> [2,6]
     * input3 = 7 ------> [-1] because 7 not in input2
     */
    public static int[] siblingSearch(int input1, int[] input2, int input3) {
        for(int gen = 0; gen < input1; gen++){
            int left = (int)Math.pow(2, gen) - 1;
            int right = (int)Math.pow(2, gen + 1) - 1 - 1;
            boolean lastRow = false;
            if(right >= input2.length - 1){
                right = input2.length -1 ; //update right if level is not full elements
                lastRow = true;
            }
            boolean targetLevel = false;
            for(int i = left; i <= right; i++){
                if(input2[i] == input3){
                    targetLevel = true;
                }
            }
            if(targetLevel){
                int[] result = new int[right - left];
                int k = 0;
                for(int i = left; i <= right; i++) {
                    if (input2[i] != input3) {
                        result[k++] = input2[i];
                    }
                }
                return result.length == 0 ? new int[]{-1} : result;
            }
            if(lastRow){
                break;
            }
        }
        return new int[]{-1};
    }

}
