public class DynamicCoinChange {
    public static void main(String[] args) {
        int[] d = {1,4,6};
        int amount = 8;
        int n = d.length;
        int[][] board = new int[n+1][amount+1];

        for (int i=0 ; i<n ; i++) {
            board[i][0] = 0;
        }

        for (int i=1 ; i<=n ; i++) {
            for (int j=1 ; j<=amount ; j++) {
                if (j<d[i-1]) {
                    board[i][j] = board[i-1][j];
                } else if (j==d[i-1]){
                    board[i][j] = 1;
                } else if (j>d[i-1] && i==1){
                    board[i][j] = 1+board[i][j-d[i-1]];
                } else {
                    board[i][j] = Math.min(board[i-1][j], 1+board[i][j-d[i-1]]);
                }
            }
        }

        System.out.println("No. of Coins : " + board[n][amount]);
        System.out.print("Coins: ");

        // Trace
        int i = n;
        int j = amount;
        while (j>0) {
            if (board[i-1][j] == board[i][j]) {
                i--;
            } else {
                j = j-d[i-1];
                System.out.print(d[i-1] + " ");
            }
        }
    }
}
