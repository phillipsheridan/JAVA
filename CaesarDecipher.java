
import java.util.*;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author keele
 */
// 65-90 UpperCase
//97-122 lowerCase
//48-57 0-9
public class CaesarDecipher {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Decode (D) or Encode(E): ");
        char function = input.nextLine().charAt(0);
        System.out.println("Enter a line to decode: ");
        String s1 = input.nextLine();
        System.out.println("Enter the key: ");
        int n1 = input.nextInt();
        if(function == 'E'){
        System.out.println(encrypt(s1, n1));
        }
        else if(function == 'D'){
             System.out.println(decrypt(s1, n1));
        }
        else{
            System.out.println("Wrong input for decode or encode :(");
        }
    }
    
    
    
    public static String encrypt(String s1, int n){
        String s2 = "";
        int newCharacter = 0;
        for(int i = 0; i < s1.length(); i ++){
            char c = s1.charAt(i);
            int character = (int) c;
            int mod = 0;
            //upperCase Check
            if(character >= 65 && character <= 90){
                if(n > 26){
                    mod = n % 26;
                    newCharacter = character+mod;
                }
                else{
                    newCharacter = character+n;
                }
                if(newCharacter >= 65 && newCharacter <= 90){
                s2 += (char)newCharacter;
            }
                else{
                    newCharacter -= 26;
                    s2 += (char)newCharacter;
                }
            }
            
            //lowerCase
            else if(character >= 97 && character <= 122){
                if(n > 26){
                    mod = n % 26;
                    newCharacter = character+mod;
                }
                else{
                    newCharacter = character+n;
                }
                if(newCharacter >= 97 && newCharacter <= 122){
                s2 += (char)newCharacter;
            }
                else{
                    newCharacter -= 26;
                    s2 += (char)newCharacter;
                }
            }
            
            //numbers
            else if(character >= 48 && character <= 57){
                if(n > 10){
                    mod = n % 10;
                    newCharacter = character+mod;
                }
                else{
                    newCharacter = character+n;
                }
 
                if(newCharacter >= 48 && newCharacter <= 57){
                s2 += (char)newCharacter;
            }
                else{
                    
                    newCharacter -= 10;
                    s2 += (char)newCharacter;
                }
            }
            else if (c == ' '){
                s2 += " ";
            }
        }
        return s2;
    }
    ////////////////////////////////////////////////////////////////////////////
    public static String decrypt(String s1, int n){
        int mod = 0;
        String s2 = "";
        int newCharacter = 0;
        for(int i = 0; i < s1.length(); i ++){
            char c = s1.charAt(i);
            int character = (int) c;
            
            //upperCase Check
            if(character >= 65 && character <= 90){
                if(n > 26){
                    mod = n % 26;
                    newCharacter = character-mod;
                }
                else{
                    newCharacter = character-n;
                }
                if(newCharacter >= 65 && newCharacter <= 90){
                s2 += (char)newCharacter;
            }
                else{
                    newCharacter += 26;
                    s2 += (char)newCharacter;
                }
            }
            
            //lowerCase
            else if(character >= 97 && character <= 122){
                if(n > 26){
                    mod = n % 26;
                    newCharacter = character-mod;
                }
                else{
                    newCharacter = character-n;
                }
                if(newCharacter >= 97 && newCharacter <= 122){
                s2 += (char)newCharacter;
            }
                else{
                    newCharacter += 26;
                    s2 += (char)newCharacter;
                }
            }
            
            //numbers
            else if(character >= 48 && character <= 57){
                if(n > 10){
                    mod = n % 10;
                    newCharacter = character-mod;
                }
                else{
                    newCharacter = character-n;
                }
                if(newCharacter >= 48 && newCharacter <= 57){
                s2 += (char)newCharacter;
            }
                else{
                    newCharacter += 9;
                    s2 += (char)newCharacter;
                }
            }
            else if (c == ' '){
                s2 += " ";
            }
        }
        return s2;
    }
    public static String shuffle(String s, int key) {
    String[] temp = s.split(" ");
    for (int i = 0; i < temp.length; i++) {
        temp[i] = 
    }
}
}
