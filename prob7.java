import java.util.Scanner;
 
/**
 * @author Daniel Swain Jr
 */
public class prob7 {
 
  static int count;
  static int[][] adj;
 
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int times = Integer.parseInt(input.nextLine().trim());
    int[] answers = new int[times];
 
    for (int i = 0; i < times; i++) {
      String[] dim = input.nextLine().split(" ");
      int[][] matrix
              = new int[Integer.parseInt(dim[0])][Integer.parseInt(dim[1])];
      for (int row = 0; row < matrix.length; row++) {
        String[] inputRow = input.nextLine().split(" ");
        for (int col = 0; col < matrix[0].length; col++) {
          matrix[row][col] = Integer.parseInt(inputRow[col]);
        }
      }
 
      adj = new int[matrix.length * matrix[0].length][matrix.length * matrix[0].length];
      for (int row = 0; row < matrix.length; row++) {
        for (int col = 0; col < matrix[0].length; col++) {
          if (row != matrix.length - 1
                  && matrix[row][col] > matrix[row + 1][col]) {
            adj[row * matrix.length + col][(row + 1) * matrix.length + col] = 1;
          }
          if (row != 0
                  && matrix[row][col] > matrix[row - 1][col]) {
            adj[row * matrix.length + col][(row - 1) * matrix.length + col] = 1;
          }
          if (col != matrix[0].length - 1
                  && matrix[row][col] > matrix[row][col + 1]) {
            adj[row * matrix.length + col][row * matrix.length + (col + 1)] = 1;
          }
          if (col != 0
                  && matrix[row][col] > matrix[row][col - 1]) {
            adj[row * matrix.length + col][row * matrix.length + (col - 1)] = 1;
          }
        }
      }
      check(0);
      answers[i] = count;
      count = 0;
    }
   
    for(int i: answers) {
      System.out.println(i);
    }
  }
 
  static void check(int row) {
    if (row + 1 == adj[0].length) {
      count++;
      return;
    }
    for (int col = 0; col < adj[0].length; col++) {
      if (adj[row][col] == 1) {
        check(col);
      }
    }
  }
 
}