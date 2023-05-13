public class GreedyParty {
    public static void main(String[] args) {
        int[] foodQuantity = {2, 1, 2};
        int[] foodCost = {10, 20, 30};
        int[] decorationQuantity = {1, 3, 2, 1};
        int[] decorationCost = {20, 50, 30, 40};
        int[] quantity = new int[foodQuantity.length + decorationQuantity.length];
        int[] cost = new int[foodCost.length + decorationCost.length];
        int budget = 200;
        int maxQuantity = 0;

        for(int i = 0; i < foodQuantity.length; i ++) {
            quantity[i] = foodQuantity[i];
            cost[i] = foodCost[i];
        }
        for(int i = foodQuantity.length; i < quantity.length; i ++) {
            quantity[i] = decorationQuantity[i - foodQuantity.length];
            cost[i] = decorationCost[i - foodCost.length];
        }
        for(int i = 0; i < cost.length; i ++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int j = 0; j < cost.length; j ++) {
                if(min > cost[j]) {
                    min = cost[j];
                    minIndex = j;
                }
            }
            if(budget >= cost[minIndex] * quantity[minIndex]) {
                budget = budget - cost[minIndex] * quantity[minIndex];
                maxQuantity = maxQuantity + quantity[minIndex];
                System.out.print(minIndex + " ");
                cost[minIndex] = Integer.MAX_VALUE;
            }
        }
        System.out.println("\nMaximum quantity of items purchased from budget of 200 is " + maxQuantity);
        System.out.println("Amount left will be " + budget);
    }
}

