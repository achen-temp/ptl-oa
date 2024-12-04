package com.ptl.exercise.inspyr;

import java.util.Arrays;

public class GravityFallCollider {

    public static int obstaclesToRemove(char[][] board){
        int rows = board.length;
        int cols = board[0].length;
 
        int[][] boundaires = new int[cols][2]; 
        for(int i = 0; i < boundaires.length; i++){
            Arrays.fill(boundaires[i], Integer.MIN_VALUE);
        }
        for(int j =0; j < cols; j++){
            for(int i = 0; i < rows; i++){
                if(board[i][j] == '*'){
                    boundaires[j][0] = i; //first row with * in col j
                    break;
                }
            }
            for(int i = rows - 1; i >= 0; i--){
                if(board[i][j] == '*'){
                    boundaires[j][1] = i; //last row with * in col j
                    break;
                }
            }
        }

        //System.out.println(Arrays.toString(boundaires));

        //boottomest row has *
        int lowestRow = -1;
        for(int i = 0; i < boundaires.length; i++){
            lowestRow = Math.max(lowestRow, boundaires[i][1]);
        }

        int countBottom = 0; //count all # to move whole puzzle down
        int rowsToMoveDown = rows - lowestRow - 1;
        for(int j = 0; j < cols; j++){
            for(int i = boundaires[j][1]; i <= boundaires[j][1] + rowsToMoveDown; i++){
                if(i >= 0 && board[i][j] == '#'){
                    countBottom++;
                }
            }
        }
        //System.out.println(countBottom);

        int countMiddle = 0; //count # insize figure
        for(int j = 0; j < cols; j++){
            for(int i = boundaires[j][0]; i <= boundaires[j][1]; i++){
                if(i >= 0 && board[i][j] == '#'){
                    countMiddle++;
                }
            }
        }
        //System.out.println(countMiddle);


        return countMiddle + countBottom;
    }

    public static void main(String[] args) {
        char[][] board1 = {
            {'*', '*', '*'},
            {'#', '*', '*'},
            {'*', '*', '-'},
            {'-', '-', '-'},
            {'-', '#', '#'}
        };
        System.out.println(obstaclesToRemove(board1) == 2);
        char[][] board2 = {
            {'*', '#', '*'},
            {'*', '*', '*'},
            {'#', '#', '#'}
        };
        System.out.println(obstaclesToRemove(board2) == 3);
        char[][] board3 = {
            {'-', '*', '-'},
            {'*', '*', '*'},
            {'-', '*', '-'},
            {'#', '#', '#'},
            {'#', '#', '#'}
        };
        System.out.println(obstaclesToRemove(board3) == 4);
        char[][] board4 = {
            {'-', '*', '-'},
            {'-', '*', '*'},
            {'-', '*', '-'},
            {'-', '#', '#'},
            {'-', '#', '#'}
        };
        System.out.println(obstaclesToRemove(board4) == 3);
        char[][] board5 = {
            {'-', '*', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '#', '#'},
            {'-', '#', '#'}
        };
        System.out.println(obstaclesToRemove(board5) == 2);
    }
}
