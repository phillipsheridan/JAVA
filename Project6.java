/*
 Phillip Sheridan
 CSCI 3510
 due: 2/29/16
 
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Project6 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        System.out.println("Regular expression: ");
        String re = input.nextLine();
        System.out.println("n: ");
        int n = Integer.parseInt(input.nextLine());
        Pattern p = Pattern.compile(re);

        String s = "";
        Matcher m = p.matcher(s);
        System.out.println("------- Strings in the language -------");
        if (m.matches()) {
            System.out.println("\u03B5");
        }
        for (int i = 1; i <= n; i++) {
            makeStrings(list, i);
        }
        for (String e : list) {
            m = p.matcher(e);
            if (m.matches()) {
                System.out.println(e);
            }
        }

    }

    public static void makeStrings(ArrayList<String> list, int size) {
        boolean contains = false;

        StringBuilder start = new StringBuilder();
        StringBuilder end;
        for (int i = 0; i < size; i++) {
            start.append("0");
        }
        list.add(start.toString());
        char ch = start.charAt(0);
        end = new StringBuilder(start.toString());
        end.deleteCharAt(0);
        for (int i = 0; i < Math.pow(2, size) - 1; i++) {
            contains = false;
            for (int j = 0; j < end.length() - 1; j++) {
                //System.out.println();
                if (end.charAt(j) == '1' && end.charAt(j + 1) == '0') {
                    end.insert(j + 2, ch);
                    contains = true;
                    list.add(end.toString());
                    ch = end.charAt(0);
                    end.deleteCharAt(0);
                    break;

                }
            }
            if (contains == false) {

                if (ch == '1') {
                    end.append("0");
                } else if (ch == '0') {
                    end.append("1");
                }
                list.add(end.toString());
                ch = end.charAt(0);
                end.deleteCharAt(0);
            }

        }

    }
}
