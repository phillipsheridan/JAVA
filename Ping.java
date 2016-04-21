
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author phillip
 */
public class Ping {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter any amount of lines of 1's and 0's and end "
                + "input with a line with a single 0: ");
        TreeSet<Integer> set = new TreeSet<>();
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            
            set = new TreeSet<>();
            String s = input.nextLine();
            s.trim();
            if (s.equals("0")) {
                break;
            }
            char[] array = s.toCharArray();
            if (array[1] == '1') {
                set.add(1);
            }
            for (int i = 2; i < array.length; i++) {
                int count = 0;
                for (int e : set) {
                    if (i % e == 0) {
                        count++;
                    }

                }
                if (array[i] == '0' && count % 2 != 0) {
                    set.add(i);
                } else if (array[i] == '1' && count % 2 == 0) {
                    set.add(i);
                }
            }
            
            StringBuilder sb = new StringBuilder();
            for (int e : set) {
                sb.append(e).append(" ");
            }
            list.add(sb.toString());
        }
        
        System.out.println("The intervals of the satellites are: ");
        for (String e: list) {
            System.out.println(e);
        }
        
        

    }
}
