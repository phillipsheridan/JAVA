
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
public class Circuits {
   
    public static void main(String[] args) {
        System.out.println("Enter the number of lines: ");
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine().trim());
        ArrayList<Circuit> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            
            String[] arr = input.nextLine().trim().split(" ");
            list.add(new Circuit(arr[0].charAt(0),arr[1].charAt(0),Double.parseDouble(arr[2])));
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(i).startingChar.equals(list.get(j).startingChar)
                        && list.get(i).endingChar.equals(list.get(j).endingChar)){
                    Circuit.parellelAdd(list.get(i), list.get(j), list);
                    
                }
                else if(list.get(i).startingChar.equals(list.get(j).endingChar) &&
                        list.get(i).endingChar.equals(list.get(j).startingChar)) {
                    Circuit.parellelAdd(list.get(i), list.get(j), list);
                    
                }
                
            }
            
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(i).endingChar.equals(list.get(j).startingChar)
                        ){
                    Circuit.seriesAdd(list.get(i), list.get(j), list, list.get(i).startingChar, list.get(j).endingChar);
                    
                }
                else if (list.get(i).startingChar.equals(list.get(j).startingChar)
                        ){
                    Circuit.seriesAdd(list.get(i), list.get(j), list, list.get(i).endingChar, list.get(j).endingChar);
                    
                }
                else if (list.get(i).endingChar.equals(list.get(j).endingChar)
                        ){
                    Circuit.seriesAdd(list.get(i), list.get(j), list, list.get(i).startingChar, list.get(j).startingChar);
                    
                }
                else if (list.get(i).startingChar.equals(list.get(j).endingChar)
                        ){
                    Circuit.seriesAdd(list.get(i), list.get(j), list, list.get(i).endingChar, list.get(j).startingChar);
                    
                }
            }
        }
        System.out.println(list);
    }
    
}
class Circuit {
    Character startingChar;
    Character endingChar;
    double value;
    
    Circuit(char a, char b, double v) {
        startingChar = a;
        value = v;
        endingChar = b;
    }
    public static void seriesAdd(Circuit cir1, Circuit cir2, ArrayList list, Character a, Character b) {
       double result  = cir1.value + cir2.value;
       list.remove(cir1);
       cir2.value = result;
       cir2.startingChar = a;
       cir2.endingChar = b;
       list.trimToSize();
       
       
       
       
        
    }
    public static void parellelAdd(Circuit cir1, Circuit cir2, ArrayList list) {
        double result = 1 / ((1/ cir1.value) + (1/ cir2.value));
        list.remove(cir1);
        cir2.value = result;
        list.trimToSize();
        
    }
    @Override
    public String toString() {
        return "start: " + startingChar + " end: " + endingChar + " value: " + value;
        
    }
    
        }
