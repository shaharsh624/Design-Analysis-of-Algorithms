import java.util.*;
public class SelectionSort {
    static void selectionSort(int array[]) {
        for (int i = 0 ; i < array.length ; i++) {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int j=i ; j<array.length ; j++){
                if (min > array[j]){
                    min = array[j];
                    index = j;
                }
            }
            array[index] = array[i];
            array[i] = min;
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

        selectionSort(array);

        System.out.print("\nAfter Sorting array: ");
        for(int k = 0; k < length; k ++) {
            System.out.print(array[k] + " ");
        }
        sc.close();
    }
}