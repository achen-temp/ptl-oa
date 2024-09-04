package com.ptl.exercise.sisinc;

import java.util.Arrays;

public class WoodStick {
    
    public static void main(String[] args) {
        //A, B, Answer
        int[][] testMatrix = {
            {8, 9, 4}, 
            {1, 3, 1}, 
            {10, 21, 7},
            {13, 11, 5},
            {2, 1, 0},
            {1, 8, 2}
        };

        boolean hasError1 = false;
        for(int[] test : testMatrix){
            int result = solution1(test[0], test[1]);
            if(result != test[2]){
                hasError1 = true;
                System.out.println("solution 1 failed on " + Arrays.toString(test) + " Expected: " + test[2] + " Got: " + result);
                break;
            }
        }
        if(!hasError1){
            System.out.println("solution 1 CORRECT");
        }

        boolean hasError2 = false;
        for(int[] test : testMatrix){
            try{
                int result = solution2(test[0], test[1]);
                if(result != test[2]){
                    hasError2 = true;
                    System.out.println("solution 2 failed on " + Arrays.toString(test) + " Expected: " + test[2] + " Got: " + result);
                    break;
                }
            }catch(Exception e){
                hasError2 = true;
                System.out.println("solution 2 failed on " + Arrays.toString(test) + " Expected: " + test[2] + " Got: " + e.getMessage());
                break;
            }
        }
        if(!hasError2){
            System.out.println("solution 2 CORRECT");
        }

        boolean hasError3 = false;
        for(int[] test : testMatrix){
            int result = solution3(test[0], test[1]);
            if(result != test[2]){
                hasError3 = true;
                System.out.println("solution 3 failed on " + Arrays.toString(test) + " Expected: " + test[2] + " Got: " + result);
                break;
            }
        }
        if(!hasError3){
            System.out.println("solution 3 CORRECT");
        }

        boolean hasError4 = false;
        for(int[] test : testMatrix){
            int result = solution4(test[0], test[1]);
            if(result != test[2]){
                hasError4 = true;
                System.out.println("solution 4 failed on " + Arrays.toString(test) + " Expected: " + test[2] + " Got: " + result);
                break;
            }
        }
        if(!hasError4){
            System.out.println("solution 4 CORRECT");
        }

        boolean hasError5 = false;
        for(int[] test : testMatrix){
            int result = solution5(test[0], test[1]);
            if(result != test[2]){
                hasError5 = true;
                System.out.println("solution 5 failed on " + Arrays.toString(test) + " Expected: " + test[2] + " Got: " + result);
                break;
            }
        }
        if(!hasError5){
            System.out.println("solution 5 CORRECT");
        }

        boolean hasError6 = false;
        for(int[] test : testMatrix){
            int result = solution6(test[0], test[1]);
            if(result != test[2]){
                hasError6 = true;
                System.out.println("solution 6 failed on " + Arrays.toString(test) + " Expected: " + test[2] + " Got: " + result);
                break;
            }
        }
        if(!hasError6){
            System.out.println("solution 6 CORRECT");
        }
    }



    //solution 1
    public static int countPieces(int length, int stick1, int stick2){
        return (stick1 / length) + (stick2 / length);
    }

    public static boolean canFormSquare(int length, int stick1, int stick2){
        return countPieces(length, stick1, stick2) >= 4;
    }


    public static int solution1(int A, int B){
        for(int length = Math.min(A, B); length > 0; length--){
            if(canFormSquare(length, A, B)){
                return length;
            }
        }
        return 0;
    }


    //solution 2
    public static int solution2(int A, int B) {
        int lo = 0;
        int hi = B;
    
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (canBuildSquare(mid, A, B)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
    
        return hi;
    }
    
    public static boolean canBuildSquare(int sideLength, int A, int B) {
        int numA = A / sideLength;
        int numB = B / sideLength;
        return numA + numB >= 4;
    }

    //solution 3:
     public static int solution3(int A, int B) {
        // Swap A and B if B is greater than A, so that A is always the larger stick
        if (B > A) {
            int temp = A;
            A = B;
            B = temp;
        }
    
        // Calculate the longest possible square side that can be constructed from A and B
        int longestSide = Math.max(A / 4, Math.max(Math.min(A / 3, B), B / 2));
    
        // Return the longest side of the square
        return longestSide;
    }
    
    //solution 4
    public static int solution4(int A, int B) {
        int result = 1;
    
        // Try all possible stick lengths, starting from the maximum
        for (int length = 1; length < A + B; length++) {
            // Calculate the number of pieces we can get from each stick
            int piecesA = A / length;
            int piecesB = B / length;
    
            // If we can get at least four pieces from each stick, return the length
            if (piecesA + piecesB >= 4) {
                result = Math.max(result, length);
            }
        }
    
        // Return the calculated result
        return result;
    }   

    //solution 5
    public static int solution5(int A, int B) {
        // Calculate the maximum number of sticks of length (A/4) that can be obtained from A
        int case1 = A / 4;
    
        // Calculate the maximum number of sticks of length min(A/3, B) that can be obtained from A and B
        int case2 = Math.min(A / 3, B);
    
        // Calculate the maximum number of sticks of length (B/2) that can be obtained from B
        int case3 = B / 2;
    
        // Return the largest number of sticks that can be obtained from the three cases
        return Math.max(case1, Math.max(case2, case3));
    }


    //solution 6
    public static int solution6(int A, int B){
        int maxSize = 0;

        maxSize = Math.max(maxSize, B / 4);

        if(A >= B / 3){
            maxSize = Math.max(maxSize, B / 3);
        }

        if(A >= 2 * (B / 2)){
            maxSize = Math.max(maxSize, B / 2);
        }

        if(B >= A / 3){
            maxSize = Math.max(maxSize, A / 3);
        }

        maxSize = Math.max(maxSize, A / 4);

        return maxSize;
    }




    
}
