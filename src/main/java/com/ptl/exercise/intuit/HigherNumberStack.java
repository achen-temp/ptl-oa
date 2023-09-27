package com.ptl.exercise.intuit;

import java.util.Arrays;
import java.util.Stack;

public class HigherNumberStack {

    public static int[] higherNumbers(int[] input){

        Stack<Integer> numberStack = insertToStack(generalStack(input));
        int[] output = new int[input.length];
        for (int i = 1; i <numberStack.size(); i++ ){
            output[i-1] = numberStack.get(i);
        }
        output[output.length-1] = -1;
        return output;
    }

    private static Stack<Integer> generalStack(int[] inoutArray){
        Stack<Integer> output  = new Stack<Integer>();
        for (int number : inoutArray) {
            output.add(number);
        }
        return output;
    }

    private static Stack<Integer>  insertToStack(Stack<Integer> input) {
        Stack<Integer> tmpStack = new Stack<Integer>();
        while(!input.isEmpty())
        {
            // pop out the first element
            int tmp = input.pop();

            // while temporary stack is not empty and
            // top of stack is greater than temp
            while(!tmpStack.isEmpty() && tmpStack.peek()
                    > tmp)
            {
                // pop from temporary stack and
                // push it to the input stack
                input.push(tmpStack.pop());
            }

            // push temp in temporary of stack
            tmpStack.push(tmp);
        }
        return tmpStack;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(higherNumbers(new int[]{3, 99, 28, 12, 47})));
    }
}
