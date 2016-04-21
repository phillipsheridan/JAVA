
import java.util.*;

/*
 Phillip Sheridan
 CSCI 2070
 due: 4/11/16
 HW4
 */
public class DoubleTransposition {

    public static void main(String[] args) {
        DoubleTransposition d = new DoubleTransposition();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter \"exit\" to end: ");
        System.out.println("Enter the index of the columns you want to swap with whitespace between them: ");
        String c = input.nextLine().trim();
        System.out.println("Enter the index of the rows you want to swap with whitespace between them: ");
        String r = input.nextLine().trim();
        while (true) {
            if (c.equals("exit")) {
                System.exit(0);
            }
            if (r.equals("exit")) {
                System.exit(1);
            }
            String[] cols = c.split(" ");
            String[] rows = r.split(" ");
            d.swapColumns(Integer.parseInt(cols[0]), Integer.parseInt(cols[1]));
            d.swapRows(Integer.parseInt(rows[0]), Integer.parseInt(rows[1]));
            printIt();
            System.out.println("Enter \"exit\" to end: ");
            System.out.println("Ente ir thendex of the columns you want to swap with whitespace between them: ");
            c = input.nextLine().trim();
            System.out.println("Enter the index of the rows you want to swap with whitespace between them: ");
            r = input.nextLine().trim();

        }

    }

    DoubleTransposition() {
        System.out.println("Columns: ");
        for (int x : columnTracker) {
            System.out.print(x + " ");
        }
        System.out.println("\nRows:");
        for (int x : rowTracker) {
            System.out.print(x + " ");
        }
        System.out.println();
        int t = 0;
        for (Character[] e : array) {
            for (Character ch : e) {
                t++;
                System.out.print(ch);
                if (t == 10) {
                    System.out.println();
                    t = 0;
                }

            }
        }
        System.out.println();
    }

    int numberOfColumns = 10;
    int numberOfRows = 10;
    static int[] rowTracker = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int[] columnTracker = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    static Character[][] array = {{' ', 'E', 'N', 'E', 'V', 'I', 'G', 'R', 'E', 'G'},
    {'I', 'E', 'E', 'E', 'N', 'E', ' ', 'R', 'C', 'P'},
    {'S', ' ', ' ', 'I', 'O', 'S', 'E', 'E', 'F', 'R'},
    {'G', 'H', 'O', 'O', ' ', ' ', 'T', 'U', 'S', 'H'},
    {'H', 'I', ' ', ' ', 'C', ' ', 'O', 'W', 'H', 'F'},
    {'E', 'S', 'T', 'I', ' ', 'M', 'E', 'M', 'I', 'T'},
    {'I', 'S', ' ', 'E', ' ', 'L', 'I', ' ', 'A', 'F'},
    {'H', ' ', 'E', 'A', 'O', 'S', ' ', 'C', 'N', 'E'},
    {' ', 'U', 'B', 'E', 'S', 'M', 'A', 'S', ' ', 'K'},
    {'A', 'R', 'O', ' ', 'D', ' ', 'I', 'H', 'T', 'S'}};

    

    public static void printIt() {
        System.out.println("Columns: ");
        for (int x : columnTracker) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("Rows:");
        for (int x : rowTracker) {
            System.out.print(x + " ");
        }
        System.out.println();
        for (Character[] e : array) {

            int t = 0;
            for (Character ch : e) {

                t++;
                System.out.print(ch);
                if (t == 10) {
                    System.out.println();
                    t = 0;
                }

            }

        }

    }

    public void swapColumns(int index1, int index2) {

        int temp1 = columnTracker[index2];
        columnTracker[index2] = columnTracker[index1];
        columnTracker[index1] = temp1;

        char[] temp = new char[10];
        for (int i = 0; i < numberOfColumns; i++) {
            temp[i] = array[i][index1];
        }
        for (int i = 0; i < numberOfColumns; i++) {
            array[i][index1] = array[i][index2];
        }
        for (int i = 0; i < numberOfColumns; i++) {
            array[i][index2] = temp[i];
        }

    }

    public void swapRows(int index1, int index2) {

        int temp1 = rowTracker[index2];
        rowTracker[index2] = rowTracker[index1];
        rowTracker[index1] = temp1;

        char[] temp = new char[10];
        for (int i = 0; i < numberOfColumns; i++) {
            temp[i] = array[index1][i];
        }
        for (int i = 0; i < numberOfColumns; i++) {
            array[index1][i] = array[index2][i];
        }
        for (int i = 0; i < numberOfColumns; i++) {
            array[index2][i] = temp[i];
        }

    }
}
