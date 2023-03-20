import java.util.*;

public class InsertionSort {
    static void insertionSort(int array[]) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            for (int j=i-1 ; j>-1 ; j--){
                if ( array [j] > key ){
                    array [j+1] = array [j];
                    array[j] = key;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int length = sc.nextInt();

        int[] array = new int[length];

        for(int k = 0; k < length; k++) {
            System.out.printf("Enter element %d: ", k+1);
            array[k] = sc.nextInt();
        }
        System.out.print("Data you entered: ");
        for(int k = 0; k < length; k ++) {
            System.out.print(array[k] + " ");
        }

        insertionSort(array);

        System.out.print("\nAfter Sorting array: ");
        for(int k = 0; k < length; k ++) {
            System.out.print(array[k] + " ");
        }
    }
}