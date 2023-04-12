import java.util.*;

public class MatrixMultiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i,j,k;

        System.out.print("Enter no. of rows of 1st array: ");
        int row1 = sc.nextInt();
        System.out.print("Enter no. of columns of 1st array: ");
        int col1 = sc.nextInt();
        System.out.print("Enter no. of rows of 2nd array: ");
        int row2 = sc.nextInt();
        System.out.print("Enter no. of columns of 2nd array: ");
        int col2 = sc.nextInt();

        if (col1 == row2){
            // First Array
            // System.out.println("\nEnter elements of 1st array");
            int[][] a = new int[row1][col1];
            for (i=0; i<row1; i++){
                for (j=0; j<col1; j++){
                    a[i][j] = (int)(Math.random()*(10-5+1)+1);
                }
            }
            System.out.println("1st Array: "+Arrays.deepToString(a));

            // Second Array
            // System.out.println("\nEnter elements of 2nd array");
            int[][] b = new int[row2][col2];
            for (i=0; i<row2; i++){
                for (j=0; j<col2; j++){
                    b[i][j] = (int)(Math.random()*(10-5+1)+1);
                }
            }
            System.out.println("2nd Array: "+Arrays.deepToString(b));

            // Multiplying Array
            int[][] c = new int[row1][col2];
            for (i = 0; i < row1; i++) {
                for (j = 0; j < col2; j++) {
                    for (k = 0; k < col1; k++){
                        c[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
            System.out.print("\nThe Multiplied array is ");
            System.out.println(Arrays.deepToString(c));
        }

        else {
            System.out.println("\nArrays can't be multiplied!!");
        }
        sc.close();
    }
}
