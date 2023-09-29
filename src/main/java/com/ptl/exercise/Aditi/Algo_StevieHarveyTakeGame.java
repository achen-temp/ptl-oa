package com.ptl.exercise.Aditi;

public class Algo_StevieHarveyTakeGame {

    //Output: Stevie, Harvey, Draw
    public static String solve(int N, int P, int M, int X) {
        if (P > X) {
            return solve(N, N + 1 - P, M, N + 1 - X);
        }
        int distance = X - P;

        //DRAW
        if (distance % 2 == 1 || P + X > 2 * M || P + X > 2 * (N + 1 - M)) {
            return "Draw";
        }

        //FIRST PLAYER WINS
        if (distance < M && M % 2 != distance % 2 && P + X > M && 2 * N + 2 > M + P + X) {
            return "Stevie";
        }

        //2ND PLAYER WINS
        return "Harvey";
    }

}
