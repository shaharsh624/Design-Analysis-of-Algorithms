import java.util.*;

class MergeSort {
	void merge(int arr[], int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i){
			L[i] = arr[p + i];
        }
		for (int j = 0; j < n2; ++j){
			R[j] = arr[q + 1 + j];
        }

		int i = 0, j = 0;

		int k = p;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	void sort(int arr[], int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2;

			sort(arr, l, m);
			sort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i){
			System.out.print(arr[i] + " ");
        }
		System.out.println();
	}

	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int length = sc.nextInt();

        int[] array = new int[length];

        for(int k = 0; k < length; k++) {
            System.out.printf("Enter element %d: ", k+1);
            array[k] = sc.nextInt();
        }

		System.out.println("Given Array");
		printArray(array);

		MergeSort ob = new MergeSort();
		ob.sort(array, 0, array.length - 1);

		System.out.println("\nSorted array");
		printArray(array);
	}
}