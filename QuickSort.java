
import java.util.ArrayList;




public class QuickSort {
  

  /** A test method */
  public static void main(String[] args) {
    int[] list = {2, 3, 2, 5, 6, 1, 2, 3, 14, 12};
    radixSort(list);
    for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + " ");
  }
  public static void radixSort(int[] list) {
    ArrayList<Integer>[] bucket = new ArrayList[10];
    for (int i = 0; i < bucket.length; i++) {
        bucket[i] = new ArrayList<Integer>();
    }
        boolean maxLength = false;
        int temp = -1, placement = 1;
        while (!maxLength) {
            maxLength = true;
            for (Integer i: list) {
                temp = i / placement;
                bucket[temp%10].add(i);
                if (maxLength && temp > 0) {
                    maxLength = false;
                }
                
            }
            int a = 0;
            for (int b = 0; b < 10; b++) {
                for (Integer i: bucket[b]) {
                    list[a++] = i;
                }
                bucket[b].clear();
            }
            placement *= 10;
        
    }
}
}
