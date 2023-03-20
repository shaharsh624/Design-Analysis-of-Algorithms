import java.util.*;

public class BinaryCounter {
    static void decToBinary(int n) {
        int[] binaryNum = new int[32];

        int i = 0;
        while (n > 0) {
            binaryNum[i] = n % 2;
            n = n / 2;
            i++;
        }

        for (int j = i - 1; j >= 0; j--) {
            System.out.print(binaryNum[j]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Binary Counter Implementation");
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        for(int i=1 ; i<n ; i++){
            System.out.print("Decimal: " + i);
            System.out.print(" -> Binary: ");
            decToBinary(i);
            System.out.println();
        }
    }
}
