public class GreedyKnapsack {
    public static void main(String[] args) {
        float[] weights = {2,3,5,7,1,4,1};
        float[] profits = {10,15,15,7,6,18,3};
        int capacity = 15;
        greedyKnapsack(profits, weights, capacity);
    }

    private static void greedyKnapsack(float[] profits, float[] weights, int capacity) {
        int n = profits.length;
        float[] ratio = new float[n];

        for (int i = 0; i < n; i++) {
            ratio[i] = profits[i] / weights[i];
        }

        sortArrays(ratio,weights,profits);

        float weight = 0;
        float profit = 0;
        int i;
        for (i=0 ; i<n; i++) {
            if (weight + weights[i] <= capacity) {
                weight += weights[i];
                profit += ratio[i] * weights[i];
            }
            else {
                float remainingCapacity = capacity - weight;
                weight += remainingCapacity;
                profit += ratio[i] * remainingCapacity;
                break;
            }
        }
        System.out.println("Total weight: " + weight);
        System.out.println("Total profit: " + profit);
    }

    private static void sortArrays(float[] ratio, float[] weights, float[] profits) {
        for (int i = 0; i < ratio.length - 1; i++) {
            for (int j = 0; j < ratio.length - i - 1; j++) {
                if (ratio[j] < ratio[j + 1]) {
                    float temp1 = ratio[j];
                    ratio[j] = ratio[j + 1];
                    ratio[j + 1] = temp1;

                    float temp2 = weights[j];
                    weights[j] = weights[j + 1];
                    weights[j + 1] = temp2;

                    float temp3 = profits[j];
                    profits[j] = profits[j + 1];
                    profits[j + 1] = temp3;
                }
            }
        }
    }
}

