public class DynamicKnapsack {
    public static void main(String[] args) {
        int[] profits = {3,4,5,6};
        int[] weights = {2,3,4,5};
        int capacity = 5;
        int n = profits.length;
        int[][] board = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                try {
                    board[i][w] = Math.max((board[i - 1][w]), (board[i - 1][w - weights[i - 1]] + profits[i - 1]));
                } catch (IndexOutOfBoundsException e) {
                    board[i][w] = board[i - 1][w];
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

            // either the result comes from the top
            // (K[i-1][w]) or from (val[i-1] + K[i-1]
            // [w-wt[i-1]]) as in Knapsack table. If
            // it comes from the latter one/ it means
            // the item is included.
            if (res == board[i - 1][w])
                continue;
            else {
                // This item is included.
                System.out.printf("\nObject %d -> profit: %d, weight: %d" ,i, profits[i-1], weights[i - 1]);

                // Since this weight is included its
                // value is deducted
                res = res - profits[i - 1];
                w = w - weights[i - 1];
            }
        }
    }

}


// Algorithm

/*
Dynamic-0-1-knapsack (v, w, n, W)
{
    for w = 0 to W do
        c[0, w] = 0
    for i = 1 to n do
        c[i, 0] = 0
    for w = 1 to W do
        if wi ≤ w then
            if (c[i-1, w] < vi+c[i-1, w-wi]) then
                c[i, w] = vi + c[i-1, w-wi]
            else
                c[i, w] = c[i-1, w]
            endif
        else
            c[i, w] = c[i-1, w]
        endif
    endfor
}
*/







