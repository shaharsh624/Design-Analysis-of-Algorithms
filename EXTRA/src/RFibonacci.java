import java.util.*;

public class RFibonacci {
    public static int genFib(int n){
        if (n<=1){
            return n;
        }
        return (genFib(n-1) + genFib(n-2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of terms : ");
        int n = sc.nextInt();
        for(int j=1 ; j<n ; j++){
            System.out.print(genFib(j) + " ");
        }
    }
}
