import java.util.Arrays;

public class GreedyGroceryStore {
    public static void main(String[] args) {
        int[] x = {100,100,100,700,100,100};
        int[] y = {98,100,100,700,100,100};
        int Q = 100000;
        int X = 99;
        int Y = 100;
        int n = 6;
        satisfyCustomer(x,y,Q,X,Y,n);
    }

    private static void satisfyCustomer(int[] x, int[] y, int q, int x1, int y1, int n) {
        int[] result = new int[n];
        for (int i=0 ; i<n ; i++) {
            result[i] = (x[i]*x1) + (y[i]*y1);
        }

        System.out.println(Arrays.toString(result));
        sortArrays(result,x,y);

        int weight=q;
        int profit=0;
        for (int i=0 ; i<n ; i++) {
            if (result[i] <= weight) {
                weight = weight - result[i];
                System.out.println(weight);
            }
        }
    }

    private static void sortArrays(int[] ratio, int[] weights, int[] profits) {
        int temp1;
        int temp2;
        int temp3;
        int flag = 1;

        for (int i = 0; i < ratio.length - 1; i++) {
            for (int j = 0; j < ratio.length-i-1; j++) {
                if (ratio[j] > ratio[j + 1]) {
                    temp1 = ratio[j];
                    ratio[j] = ratio[j + 1];
                    ratio[j + 1] = temp1;

                    temp2 = weights[j];
                    weights[j] = weights[j + 1];
                    weights[j + 1] = temp2;

                    temp3 = profits[j];
                    profits[j] = profits[j + 1];
                    profits[j + 1] = temp3;

                    flag=0;
                }
            }
            if (flag == 1) {
                break;
            }
        }
    }
}

