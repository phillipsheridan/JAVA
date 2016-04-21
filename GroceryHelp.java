
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
public class GroceryHelp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of days: ");
        int days = Integer.parseInt(input.nextLine().trim());
        int[] answer = new int[days];
        for (int i = 0; i < days; i++) {

            System.out.println("Enter the number of transactions: ");
            int numberOfTransactions = Integer.parseInt(input.nextLine().trim());
            int revenue = 0;

            for (int j = 0; j < numberOfTransactions; j++) {
                String[] s = input.nextLine().trim().split(" ");
                revenue += getValue(s);
            }
            answer[i] = revenue;

        }
        for (int i = 0; i < days; i++) {
            System.out.println("Day " + i + ": $" + answer[i]);
        }
    }

    static int getValue(String[] s) {
        int temp;
        if (s[0].equals("1")) {
            temp = Integer.parseInt(s[1]) * Integer.parseInt(s[2]);
            return temp;
        }
        if (s[0].equals("2")) {
            temp = Integer.parseInt(s[1]);
            return temp;
        }
        if (s[0].equals("3")) {
            temp = Integer.parseInt(s[1]);
            return temp;
        }
        return 0;
    }

}
