/*
Phillip Sheridan
CSCI 2410
due: 9/21/15
*/

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise22_01Extra {
  /** Main method */
  public static void main(String args[]) {
    // Create a Scanner
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an index for the Fibonacci number: ");
    int index = input.nextInt();
    
    // Find and display the Fibonacci number
    System.out.println(
      "Fibonacci number at index " + index + " is " + fib(index));
  }
  
  /** The method for finding the Fibonacci number */
  public static BigInteger fib(long n) {   
    BigInteger f0 = new BigInteger("0"); // For fib(0)
    BigInteger f1 = new BigInteger("1"); // For fib(1)
    BigInteger f2 = new BigInteger("1"); // For fib(2)
    
    if (n == 0) 
      return f0;
    else if (n == 1) 
      return f1;
    else if (n == 2) 
      return f2;

    for (int i = 3; i <= n; i++) {
      f0 = f1;
      f1 = f2;
      f2 = f0.add(f1);
    }
    
    return f2;
  }
}