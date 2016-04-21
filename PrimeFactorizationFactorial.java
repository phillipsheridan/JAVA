
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author phillip
 */
public class PrimeFactorizationFactorial {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of test cases: ");
        int cases = Integer.parseInt(input.nextLine().trim());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < cases; i++) {
            String s = input.nextLine().trim();
            int number = Integer.parseInt(s);
            list.add(number);
        }
        for (Integer e : list) {
            int d = 0;
            int t = 0;
            for (int i = 2; i <= e; i++) {
                if (isPrime(i)) {
                    d++;
                    t++;

                } else {
                    int k = i;
                    int j = 2;
                    while (k != 1 || j != i / 2) {

                        if (k % j == 0 && isPrime(j)) {
                            k /= j;

                            t++;
                        } else {
                            j++;
                        }
                    }

                }

            }
            System.out.println("Total: " + t + "  Distinct:" + d);
        }
    }

    static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }
        if (n == 3) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        if (n % 3 == 0) {
            return false;
        }

        int i = 5;
        int w = 2;
        while (i * i <= n) {
            if (n % i == 0) {
                return false;
            }
            i += w;
            w = 6 - w;
        }
        return true;
    }
    
    
}
