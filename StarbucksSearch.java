
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StarbucksSearch {

    protected static ArrayList<StarBucks> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine().trim();
        while (!s.equals("END")) {
            String[] str = s.split(",");
            if (Double.parseDouble(str[2]) <= 2.0) {
                list.add(new StarBucks(str[0], Double.parseDouble(str[1]), Double.parseDouble(str[2])));
            }
            s = input.nextLine().trim();
        }
        Collections.sort(list);
        for (StarBucks e : list) {
            System.out.println(e.name + ", Exit " + e.distanceFromHome);
        }
    }

}

class StarBucks implements Comparable<StarBucks> {

    String name;

    double distanceFromHome;

    double distanceFromExit;

    StarBucks(String name, double distanceFromHome, double distanceFromExit) {
        this.name = name;
        this.distanceFromHome = distanceFromHome;
        this.distanceFromExit = distanceFromExit;
    }

    public int compareTo(StarBucks s) {
        if (this.distanceFromHome == s.distanceFromHome) {
            if (this.distanceFromExit > s.distanceFromExit) {
                return 1;
            } else if (this.distanceFromExit == s.distanceFromExit) {
                return 0;
            } else {
                return -1;
            }
        } else {
            if (this.distanceFromHome > s.distanceFromHome) {
                return 1;
            } else if (this.distanceFromHome < s.distanceFromHome) {
                return -1;
            }
        }

        return 0;
    }

}
