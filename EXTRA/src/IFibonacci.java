import java.util.*;
public class IFibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int fib1 = 1;
        int fib2 = 1;
        int fib3 = 1;

        System.out.print("Enter the number of terms : ");
        int n = sc.nextInt();
        System.out.print("1 1 ");
        for(int j=2 ; j<n ; j++){
            fib1 = fib2;
            fib2 = fib3;
            fib3 = fib1 + fib2;
            System.out.print(fib3 + " ");
        }
    }
}
