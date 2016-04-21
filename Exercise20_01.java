/*
 Phillip Sheridan
 CSCI 2410
 due: 8/31/15
 */
import java.io.*;
import java.util.*;
public class Exercise20_01 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("File not found");
        } else {
            ArrayList<String> list;
            try (Scanner input = new Scanner(file)) {

                list = new ArrayList<>();
                while (input.hasNext()) {
                    {
                        list.add(input.next());

                    }
                    Iterator<String> iterator = list.listIterator();
                    while (iterator.hasNext()) {
                        if (!Character.isLetter(iterator.next().charAt(0))) {
                            iterator.remove();
                        }

                    }

                }
            }

            Collections.sort(list);
           
            System.out.println(list);
        }
    }
}
