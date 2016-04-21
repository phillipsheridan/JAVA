
import java.math.BigInteger;
import java.util.Scanner;

/*
Phillip Sheridan
CSCI 2410
due: 8/21/15
 */
public class Exercise18_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a number: ");
        String value = input.next();
        
        BigInteger number = new BigInteger(value);
        
        System.out.println("The factorial of " + value + " is: " + 
                fact(number));
        
    }
public static BigInteger fact(BigInteger n) {
    if (n == BigInteger.ZERO)
        return BigInteger.ONE;
    else
        return n.multiply(fact(n.subtract(BigInteger.ONE)));
            
}
    
}
