import java.util.Scanner;
 
/**
 * @author Daniel Swain Jr
 */
public class prob6 {
 
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
 
    int lines = Integer.parseInt(input.nextLine().trim());
    String[] answers = new String[lines];
 
    for (int i = 0; i < lines; i++) {
      answers[i] = input.nextLine();
      String[] numbers = answers[i].split(" ");
 
      if (numbers.length > 24) {
        System.out.println("Too much input.");
        System.exit(0);
      }
 
      boolean[] juggler = new boolean[numbers.length];
      int[] count = new int[numbers.length];
 
      for (int j = 0; j < juggler.length; j++) {
        int index = (j + Integer.parseInt(numbers[j]) - 1) % juggler.length;
        if (!juggler[index] && count[index] < 1) {
          juggler[index] = true;
          count[index]++;
        } else {
          juggler[index] = false;
        }
      }
 
      if (checkJuggler(juggler)) {
        answers[i] += " - can be juggled.";
      } else {
        answers[i] += " - cannot be juggled.";
      }
    }
 
    for (String s : answers) {
      System.out.println(s);
    }
  }
 
  static boolean checkJuggler(boolean[] juggler) {
    for (int i = 0; i < juggler.length; i++) {
      if (!juggler[i]) {
        return false;
      }
    }
    return true;
  }
}