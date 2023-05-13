import java.util.*;
public class DynamicLCS {
    public static void main(String[] args) {
        char[] s1 = {'s','t','o','n','e'};
        char[] s2 = {'l','o','n','g','e','s','t'};
        int[][] board = new int[s1.length+1][s2.length+1];

        for (int i=0 ; i<s1.length ; i++) {board[i][0] = 0;}
        for (int i=0 ; i<s1.length ; i++) {board[0][i] = 0;}

        for (int i=1 ; i<=s1.length ; i++) {
            for (int j=1; j<=s2.length; j++) {
                if (s1[i-1] == s2[j-1]) {
                    board[i][j] = 1 + board[i-1][j-1];
                } else {
                    board[i][j] = Math.max(board[i-1][j],board[i][j-1]);
                }
            }
        }
        traceLCS(board,s1,s2);
    }

    private static void traceLCS(int[][] board, char[] s1, char[] s2) {
        int i = s1.length;
        int j = s2.length;
        Stack<Character> stack = new Stack<>();
        while(j>=1 && i>=1){
            if (board[i][j] == board[i-1][j]) {
                i--;
            }
            else if (board[i][j] == board[i][j-1]) {
                j--;
            }
            else {
                stack.push(s1[i-1]);
                i--; j--;
            }
        }
        System.out.print("Longest Common Sequence: ");
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
