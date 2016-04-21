
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author phillip
 */
public class Survivor {

    static TreeMap<Character, Survivor> map = new TreeMap<>();
    ArrayList<String> messages = new ArrayList<>();
    static String message;

    static boolean[][] visible = new boolean[26][26];

    Survivor() {

    }

    void addMessage(String s) {
        this.messages.add(s);
    }

    void makeVisible(char sa, char sb) {
        visible[sa - 'A'][sb - 'A'] = true;
    }

    

    void makeObstructed(char sa, char sb) {
        visible[sa - 'A'][sb - 'A'] = false;
    }

    void printMessage() {
        System.out.println(messages);
    }

    boolean hasMessage() {
        return !messages.isEmpty();
    }
    static void sendMessage(char sa) {
        for (int col = 0; col < 26; col++) {
            if (visible[sa-'A'][col]) {
                map.get((char)(col + 'A')).addMessage(message);
                sendMessage((char)(col + 'A'));
            }
        }
    }
    

    public static void main(String args[]) {
        ArrayList<String> answers = new ArrayList<>();
        ArrayList<Survivor> currentSurvivors;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of test cases: ");
        int cases = Integer.parseInt(input.nextLine().trim());

        for (int i = 0; i < cases; i++) {
            currentSurvivors = new ArrayList<>();
            System.out.println("Enter the number of lines: ");
            int numOfLines = Integer.parseInt(input.nextLine().trim());

            for (int j = 0; j < 26; j++) {
                map.put((char) (j + 'A'), new Survivor());
            }

            for (int j = 0; j < numOfLines; j++) {

                String s = input.nextLine().trim();
                Scanner stringScanner = new Scanner(s);
                ArrayList<String> list = new ArrayList();
                while (stringScanner.hasNext()) {
                    list.add(stringScanner.next());
                }

                switch (list.get(0)) {
                    case "VISIBLE":
                        map.get(list.get(1).charAt(0)).
                                makeVisible(list.get(2).charAt(0), list.get(1).charAt(0));
                        map.get(list.get(2).charAt(0)).
                                makeVisible(list.get(1).charAt(0), list.get(2).charAt(0));
                        break;
                    case "MESSAGE":
                        message = list.get(2);
                        sendMessage(list.get(1).charAt(0));
                        break;

                    case "OBSTACLE":
                        map.get(list.get(1).charAt(0)).
                                makeObstructed(list.get(2).charAt(0), list.get(1).charAt(0));
                        map.get(list.get(2).charAt(0)).
                                makeObstructed(list.get(1).charAt(0), list.get(2).charAt(0));
                        break;
                    case "WEATHER":
                        map.get(list.get(1).charAt(0)).
                                makeObstructed(list.get(2).charAt(0), list.get(1).charAt(0));
                        map.get(list.get(2).charAt(0)).
                                makeObstructed(list.get(1).charAt(0), list.get(2).charAt(0));
                        break;
                }

            }
            for (Map.Entry<Character, Survivor> k : map.entrySet()) {
                if (k.getValue().hasMessage()) {
                    String s = k.getKey() + ": " +
                            k.getValue().messages.toString();
                    answers.add(s);
                }
            }
            answers.add("\n");
           visible = new boolean[26][26];
        }
        System.out.println();
        for (String s : answers) {
            System.out.println(s);
        }
    }
}
