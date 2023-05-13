public class NetflixRecommendation {
    public static void main(String[] args) {
        int[] profits = {10,8,9,15,5};
        int[] weights = {2,1,4,3,2};
        int capacity = 8;
        dynamicKnapsack(profits, weights, capacity);
    }

    private static void dynamicKnapsack(int[] profits, int[] weights, int capacity) {
        int n = profits.length;
        int[][] board = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                try {
                    board[i][w] = Math.max((board[i - 1][w]), (board[i - 1][w - weights[i - 1]] + profits[i - 1]));
                } catch (IndexOutOfBoundsException e) {
                    board[i][w] = (board[i - 1][w]);
                }
            }
        }

        System.out.println("---------- Knapsack ----------");
        for (int i = 0; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                System.out.print(board[i][w] + " ");
            }
            System.out.println();
        }
        traceKnapsack(board, weights, profits, capacity);
        System.out.println("\nTotal Profit: " + board[n][capacity]);
    }

    private static void traceKnapsack(int[][] board, int[] weights, int[] profits, int capacity) {
        int n = weights.length;
        int res = board[n][capacity];
        int w  = capacity;
        for (int i=n; i>0 && res>0; i--) {
            if (res == board[i - 1][w])
                continue;
            else {
                System.out.printf("\nObject -> entertainment: %d, duration: %d", profits[i-1], weights[i - 1]);
                res = res - profits[i - 1];
                w = w - weights[i - 1];
            }
        }
    }

    private static void sortArrays(int[] weights, int[] profits) {
        int temp1;
        int temp3;
        int flag = 1;
        for (int i = 0; i < weights.length - 1; i++) {
            for (int j = 0; j < weights.length - i - 1; j++) {
                if (weights[j] > weights[j + 1]) {
                    temp1 = weights[j];
                    weights[j] = weights[j + 1];
                    weights[j + 1] = temp1;

                    temp3 = profits[j];
                    profits[j] = profits[j + 1];
                    profits[j + 1] = temp3;

                    flag = 0;
                }
            }
            if (flag == 1) {
                break;
            }
        }
    }
}
