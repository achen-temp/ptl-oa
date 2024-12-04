package com.ptl.exercise.aaliveinterview;

import java.util.Stack;

public class SudokuSolver {

  
    
        // Check if placing a value in the row is valid
        public static boolean valid1(int row, int[][] board, int value) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == value)
                    return false;
            }
            return true;
        }
    
        // Check if placing a value in the column is valid
        public static boolean valid2(int col, int[][] board, int value) {
            for (int row = 0; row < 9; row++) {
                if (board[row][col] == value)
                    return false;
            }
            return true;
        }
    
        // Check if placing a value in the 3x3 subgrid is valid
        public static boolean valid3(int gridIndex, int[][] board, int value) {
            int startRow = (gridIndex / 3) * 3;
            int startCol = (gridIndex % 3) * 3;
            for (int i = 0; i < 9; i++) {
                int row = startRow + i / 3;
                int col = startCol + i % 3;
                if (board[row][col] == value)
                    return false;
            }
            return true;
        }
    
        // Helper function to solve the Sudoku puzzle using backtracking
        public static boolean helper(int[][] board, int row, int col) {
            // Move to the next empty cell
            while (row < 9 && board[row][col] != '.') {
                col++;
                if (col == 9) {
                    col = 0;
                    row++;
                }
                if (row == 9)
                    return true;  // End of the board, puzzle solved
            }
    
            // Try placing numbers 1-9
            for (int num = 1; num <= 9; num++) {
                if (valid1(row, board, num) && valid2(col, board, num) && valid3((row / 3) * 3 + (col / 3), board, num)) {
                    // Place the number if valid
                    board[row][col] = num;
                    // Recur for the next empty cell
                    if (helper(board, row, col))
                        return true;
                    // If the placement doesn't work, backtrack
                    board[row][col] = -1;
                }
            }
            return false;  // Trigger backtracking
        }
    
        // Main function to start solving the Sudoku
        public static int[][] solution(int[][] board) {
            helper(board, 0, 0);  // Start solving from the first cell
            return board;
        }
  
    


    // Function to print the Sudoku board (for debugging or displaying the result)
    public static void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example Sudoku board (0 represents empty cells)
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        // Call the solution function to solve the Sudoku
        int[][] solvedBoard = solution(board);

        // Print the solved Sudoku board
        if (solvedBoard != null) {
            System.out.println("Solved Sudoku:");
            printBoard(solvedBoard);
        } else {
            System.out.println("No solution exists.");
        }
    }
}
