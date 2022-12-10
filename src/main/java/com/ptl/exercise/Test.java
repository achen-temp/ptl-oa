package com.ptl.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Test {

    public static void solve(int m, int n, int[][] matrix){
        Stack<Integer> stack = new Stack<Integer>();
        int i, k = 0, l = 0;
        while( k <= m && l <= n ){
            for(i = l; i <= n; i++){
                stack.push(matrix[k][i]);
            }
            k++;
            for(i = k; i <= m; i++){
                stack.push(matrix[i][n]);
            }
            n--;
            if(k <= m){
                for(i = n; i >= l; i--){
                    stack.push(matrix[m][i]);
                }
                m--;
            }
            if(l <= n){
                for(i = m; i >= k; i--){
                    stack.push(matrix[i][l]);
                }
                l++;
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.peek() + " ");
            stack.pop();
        }
    }

//38 shi l bushi i

    public static void main2(String[] args) throws IOException {
        //写这个把 -- 太变态了 输入都要自己写
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String row1 = br.readLine();
        String[] str1 = row1.replaceAll("\\s+$", "").split(" ");
        int row = Integer.parseInt(str1[0]);
        int col = Integer.parseInt(str1[1]);
        int[][] matrix = new int[row][col];
        String line;
        int i = 0;
        while( (line = br.readLine()) != null ){
            String[] arr = line.replaceAll("\\s+$", "").split(" ");
            for(int k = 0; k < col; k++){
                matrix[i][k] = Integer.parseInt(arr[k]);
            }
            i++;
        }
        */
        int row = 4;
        int col = 4;
        int[][] matrix = {{1,2,3,4},
                          {5,6,7,8},
                          {9,10,11,12},
                          {13,14,15,16}};
        Test.solve(row-1, col-1, matrix); //不知道了看没问题的
        //
    }


    public static double findPi(int n){
        if(n <= 0){
            return -1; //not valid -- 写上
        }
        double pi2 = 0;
        for(int i = 1; i <= n; i++){
            pi2 += 1.0/(i * i);
        }
        return Math.sqrt(6*pi2);
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int max = 0, buy = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (buy > prices[i]) {
                buy = prices[i];
            }
            max = Math.max(prices[i] - buy, max);
        }
        return max;
    }

    public static int[] method(int[] arr){
        if(arr == null || arr.length < 2){
            return null;
        }
        //buy和sell是买入和卖出数
        int buy = arr[0], sell = arr[1], profit = sell - buy;

        int tempProfit = Integer.MIN_VALUE;
        for(int i = 1; i < arr.length; i++){
            tempProfit = arr[i] - buy;
            if(tempProfit > profit){ //every value, find temporary profit and it bigger, replace 'profit'
                profit = tempProfit;
                sell = arr[i]; //update new sell price to search for another profit
            }
            if(buy > arr[i]){ //update current buy price with current stock price to find minimal buy price
                buy = arr[i];
            }
        }
        int[] result = new int[2];
        result[0] = sell - profit; // buy may not be updated finally, so use sell-profit
        result[1] = sell;
        return result;
    }


    public static void main(String[] args) {
        int[] result = method(new int[]{21,12,11,9,6,3});
        System.out.println(Arrays.toString(result));
    }


}
