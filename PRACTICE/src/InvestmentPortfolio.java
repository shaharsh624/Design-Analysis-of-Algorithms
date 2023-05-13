public class InvestmentPortfolio {
    public static void main(String[] args) {
        int[] c = {20,50,10,30,20};
        int[] q = {5,2,4,3,2};
        double[] r = {1.5,1.8,2.1,1.1,0.5};
        int n = c.length;
        int b = 300;
        int months = 12;

        int[] costs = new int[n];
        double[] returns = new double[n];

        for (int i=0 ; i<n ; i++) {
            costs[i] = c[i]*q[i];
            returns[i] = c[i]*q[i]*r[i];
        }
        bSort(returns, costs);
        int t=1;
        int budget = b;
        double totalReturns = 0;

        while (t<=12) {
            if (t<5 && budget>=costs[t-1]) {
                budget -= costs[t-1];
                totalReturns += returns[t-1] * t;
                t++;
            } else {
                totalReturns = totalReturns*t;
                t++;
            }
        }
        System.out.println("Total Return: Rs." + totalReturns);
        System.out.println("Remaining budget: Rs." + (budget));
        System.out.println("No. of Assets purchased: " + (t-1));
    }

    public static void bSort(double[] returns, int[] costs) {
        int n = returns.length;
        double temp1;
        int temp2;

        for (int i=0 ; i<n ; i++) {
            for (int j=0 ; j<n-i-1 ; j++) {
                if (returns[j] < returns[j+1]) {
                    temp1 = returns[j];
                    returns[j] = returns[j+1];
                    returns[j+1] = temp1;

                    temp2 = costs[j];
                    costs[j] = costs[j+1];
                    costs[j+1] = temp2;
                }
            }
        }
    }
}
