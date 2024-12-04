package com.ptl.exercise.inspyr;

public class RectangularMatrix2 {

    
    public static void main(String[] args) {
        RectangularMatrix2 rm = new RectangularMatrix2();

        char[][] board1 = {{'s','o','s','o'}, {'s', 'o', 'o', 's'}, {'s','s','s','s'}};
        String word1 = "sos";   //3
        System.out.println(rm.solution(board1, word1) == 3);

        char[][] board2 = {{'a','a'}, {'a', 'a'}};
        String word2 = "aa";  //5
        System.out.println(rm.solution(board2, word2) == 5);

        char[][] board3 = {{'z','z','z'}, {'z', 'z', 'z'}, {'z','z','z'}};
        String word3 = "zz";  //16
        System.out.println(rm.solution(board3, word3) == 16);

        char[][] board4 = {{'c','c','o','d', 'e'}, {'o', 'c', 'o', 'd', 'e'}, {'d','t','o','d', 't'}, {'e', 't', 't', 'd', 'e'}, {'a','b','c','d', 'e'}};
        String word4 = "code";  //5
        System.out.println(rm.solution(board4, word4) == 5);

        char[][] board5 = {{'x'}};
        String word5 = "oops";  //0
        System.out.println(rm.solution(board5, word5) == 0);

        char[][] board6 = {{'c','o','d','e','s','i','g','n','a','l'}};
        String word6 = "codesignal"; //1
        System.out.println(rm.solution(board6, word6) == 1);

        char[][] board7 = {{'c'},{'o'},{'d'},{'e'},{'s'},{'i'},{'g'},{'n'},{'a'},{'l'}};
        String word7 = "codesignal"; //1
        System.out.println(rm.solution(board7, word7) == 1);

        char[][] board8 = {{'c','o','c','o','c','o','c','o','c','c'}};
        String word8 = "co"; //4
        System.out.println(rm.solution(board8, word8) == 4);

        char[][] board9 = {{'c'},{'o'},{'c'},{'o'},{'c'},{'o'},{'c'},{'o'},{'c'},{'o'}};
        String word9 = "co"; //5
        System.out.println(rm.solution(board9, word9) == 5);
    }

    public int solution(char[][] board, String word) {
        int count = 0;
        int rows = board.length;
        int cols = board[0].length;
        int wordLength = word.length();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Check in the right direction
                if (j + wordLength <= cols && matchRight(board, word, i, j)) {
                    count++;
                }
                
                // Check in the down direction
                if (i + wordLength <= rows && matchDown(board, word, i, j)) {
                    count++;
                }
                
                // Check in the diagonal direction
                if (i + wordLength <= rows && j + wordLength <= cols && matchDiagonal(board, word, i, j)) {
                    count++;
                }
            }
        }
        
        return count;
    }

    // Check if word matches starting from (i, j) in the right direction
    private boolean matchRight(char[][] board, String word, int i, int j) {
        for (int k = 0; k < word.length(); k++) {
            if (board[i][j + k] != word.charAt(k)) {
                return false;
            }
        }
        return true;
    }

    // Check if word matches starting from (i, j) in the down direction
    private boolean matchDown(char[][] board, String word, int i, int j) {
        for (int k = 0; k < word.length(); k++) {
            if (board[i + k][j] != word.charAt(k)) {
                return false;
            }
        }
        return true;
    }

    // Check if word matches starting from (i, j) in the diagonal direction
    private boolean matchDiagonal(char[][] board, String word, int i, int j) {
        for (int k = 0; k < word.length(); k++) {
            if (board[i + k][j + k] != word.charAt(k)) {
                return false;
            }
        }
        return true;
    }
}
