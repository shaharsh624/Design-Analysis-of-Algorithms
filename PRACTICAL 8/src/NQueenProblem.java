import java.util.Scanner;

public class NQueenProblem {
    static int N;

    static boolean solveNQueen(int board[][], int col) {
        if (col >= N) {
            printSolution(board);
            System.out.println();
            return true;
        }
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                if (solveNQueen(board, col + 1)) {
                    return true;
                }
                // Backtrack if the above condition is false
                board[i][col] = 0;
            }
        }
        return false;
    }

    // function to check whether the position is safe or not
    static boolean isSafe(int board[][], int row, int col) {
        int i, j;
        // Check for Same Row (col-1...)
        for (i = col - 1; i >= 0; i--) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        // Check for Upper Diagonal (row-1... , col-1...)
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // Check for Lower Diagonal (row+1... , col-1...)
        for (i = row, j = col; j >= 0 && i < N; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    // print the final solution matrix
    static void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of board: ");
        N = sc.nextInt();
        sc.close();

        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = 0;
            }
        }

        if (!solveNQueen(board, 0)) {
            System.out.print("Solution does not exist");
            return;
        }
        
        printSolution(board);

    }
}
