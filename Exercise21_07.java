import java.util.*;

public class Exercise21_07 {
  public static void main(String[] args) {
    // Set text in a string
    String text = "Good morning. Have a good class. " +
      "Have a good visit. Have fun!";

    // Create a TreeMap to hold words as key and count as value
    Map<String, Integer> map = new TreeMap<>();

    String[] words = text.split("[\\s+\\p{P}]");
    for (int i = 0; i < words.length; i++) {
      String key = words[i].toLowerCase();
      
      if (key.length() > 0) {
        if (!map.containsKey(key)) {
          map.put(key, 1);
        }
        else {
          int value = map.get(key);
          value++;
          map.put(key, value);
        }
      }
    }

    // Display key and value for each entry
    //map.forEach((k, v) -> System.out.println(k + "\t" + v));
    ArrayList<WordOccurence> list = new ArrayList<>();
    map.forEach((k,v) -> list.add(new WordOccurence(k,v)));
    Collections.sort(list);
    for (WordOccurence e: list) {
      System.out.println(e.word + ": " + e.count);
    }
  }
}
class WordOccurence implements Comparable<WordOccurence> {
    String word;
    int count;
    WordOccurence(String word, int count) {
        this.count = count;
        this.word = word;
    }
    @Override
    public int compareTo(WordOccurence a) {
        if (this.count > a.count)
            return 1;
        else if (this.count == a.count)
            return 0;
        else 
            return -1;
                    
    }
   
    
}