package com.ptl.exercise.randstad.test_role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Oa {
   // todo

   public static void main(String[] args) {
      List<Integer> list = Arrays.asList(1, 5, 6, 8, 8, 8, 0, 1, 1, 0, 6, 5);
      List<Integer> output = removeDuplicates(list);
      System.out.println(output);
   }

   public static List<Integer> removeDuplicates(List<Integer> list) {

      Stack<Integer> stack = new Stack<>();
      stack.push(list.get(0));

      for (int i = 1; i < list.size(); i++) {
         if (!stack.isEmpty() && list.get(i) == stack.peek()) {
            stack.pop();
         } else if (list.get(i) == list.get(i - 1)) {
            continue;
         } else {
            stack.push(list.get(i));
         }
      }
      return new ArrayList<>(stack);
   }

}
