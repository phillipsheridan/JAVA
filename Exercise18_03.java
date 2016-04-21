/*
Phillip Sheridan
CSCI 2410
due: 8/21/15
 */
import java.util.Scanner;

public class Exercise18_03 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        int first = input.nextInt();
        int second = input.nextInt();
        System.out.println("The GCD of " + first + " and " + second + " is: "
                + gcd(first, second));

    }

    public static int gcd(int first, int second) {
        if (first % second == 0) {
            return second;
        } else {
            return gcd(second, first % second);
        }
    }

}
