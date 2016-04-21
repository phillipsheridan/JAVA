
import java.util.ArrayList;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        char ch = 'A';
        int k = (int)ch;
        k %= 5;
        if (k < 65) {
            k += 64;
        }
        char temp = (char)k;
        System.out.println(temp);
        
    }

}

