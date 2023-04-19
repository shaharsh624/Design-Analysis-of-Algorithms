public class Main {
    public static void main(String[] args) {
        int[] A = {1, 3, 5, 7, 8, 6, 4, 2};
            int n = A.length;
            int left = 0, right = n - 1;

            // Continue until left and right indices become same
            while (left < right) {
                int mid = (left + right) / 2; // Middle index
                if (A[mid] > A[mid + 1]) {
                    right = mid; // Discard right half of array & use left half
                } else {
                    left = mid + 1; // Discard left half of array & use right half
                }
            }
            System.out.printf("Peak Element is %d at index %d",A[left] , left); // return the index of the peak element
        }
}



/*

// Dynamic Input
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter length of array: ");
        int n = sc.nextInt();

        int[] A = new int [n];

        for (int i=0 ; i<n ; i++) {
            System.out.printf("Enter Element %d : ", i);
            A[i] = sc.nextInt();
        }
            int left = 0, right = n - 1;

            // Continue until left and right indices become same
            while (left < right) {
                int mid = (left + right) / 2; // Middle index
                if (A[mid] > A[mid + 1]) {
                    right = mid; // Discard right half of array & use left half
                } else {
                    left = mid + 1; // Discard left half of array & use right half
                }
            }
            System.out.printf("Peak Element is %d at index %d",A[left] , left); // return the index of the peak element
        }
}


*/