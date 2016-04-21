
/*
 Phillip Sheridan
 CSCI 2410
 due: 8/21/15
 */
import java.util.Scanner;

public class Exercise18_02 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int value = input.nextInt();
        System.out.println("The fibonnaci number for " + value + " is "
                + fib(value));
    }

    public static long fib(int n) {
        int f0 = 0, f1 = 1, currentFib;

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        for (int i = 2; i <= n; i++) {
            currentFib = f0 + f1;
            f0 = f1;
            f1 = currentFib;
        }

        return f1;
    }
}
