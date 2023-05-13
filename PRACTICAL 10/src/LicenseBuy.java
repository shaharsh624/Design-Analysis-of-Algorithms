public class LicenseBuy {

    // Licenses
    static int[] licenses = {6,7,2,1,7,3,8,2};

    // Bought or not
    static boolean[] bought = new boolean[licenses.length];

    public static int calculateCost() {
        int cost = 100;
        System.out.print("\nOrder of buying Licenses: ");
        for (int i = 1; i<= licenses.length ; i++) {
            int index = findIndexOfMax();
            cost += 100*(Math.pow(licenses[index], i));
            bought[index] = true;
            System.out.printf("\nMonth %d -> (No.: %d) (Rate: %d)", i, index+1, licenses[index]);
        }
        return cost;
    }

    public static int findIndexOfMax() {
        int max = Integer.MIN_VALUE;
        int index = -1;

        // Find max
        for (int i = 0; i< licenses.length ; i++) {
            if (!bought[i] && licenses[i] >= max) {
                max = licenses[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println("\nCost: $" + calculateCost());
    }

}
