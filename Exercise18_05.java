/*
Phillip Sheridan
CSCI 2410
due: 8/21/15
 */
public class Exercise18_05 {

    public static void main(String[] args) {
        
        
        for (int i = 1; i <= 10; i++) {
            System.out.println("The sum of the series m(i)= i / 2i+1 with i = "+ i +" is: " + sumSeries(i));
        }
        

    }

    public static double sumSeries(int index) {

        if (index == 1) {
            return index / (2.0 * index + 1);
        } else {
            return (index / (2.0 * index + 1)) + sumSeries(index - 1);
            
        }

    }

}
