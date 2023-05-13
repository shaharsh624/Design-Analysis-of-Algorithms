public class NewGreedyKnapsack {
    public static void main(String[] args) {
        int[] quantity = {2,3,5,7,1,4,1};
        int[] cost = {10,15,15,7,6,18,3};
        int budget = 15;
        int maxQuantity = 0;

        for(int i = 0; i < cost.length; i ++) {
            int min = Integer.MIN_VALUE;
            int minIndex = 0;
            for(int j = 0; j < cost.length; j ++) {
                if(min < cost[j]) {
                    min = cost[j];
                    minIndex = j;
                }
            }
            if(budget >= cost[minIndex] * quantity[minIndex]) {
                budget = budget - cost[minIndex] * quantity[minIndex];
                maxQuantity = maxQuantity + quantity[minIndex];
                System.out.print(minIndex + " ");
                cost[minIndex] = Integer.MIN_VALUE;
            }
        }
        System.out.println("\nMaximum quantity of items purchased from budget of 200 is " + maxQuantity);
        System.out.println("Amount left will be " + budget);
    }
}

