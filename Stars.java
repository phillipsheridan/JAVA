
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import javafx.geometry.Point3D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author phillip
 */
public class Stars {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of stars and "
                + "the desired length: ");
        ArrayList<Integer> answer = new ArrayList<>();
        HashSet<Star> set;
        HashSet<HashSet> closeStars;
        HashSet<Star> closeSet;
        while (true) {
            String[] s = input.nextLine().trim().split(" ");
            if (s[0].equals("0") && s[1].equals("0")) {
                break;
            }
            
            int k = Integer.parseInt(s[1]);
            int numberOfStars = Integer.parseInt(s[0]);

            set = new HashSet();
            closeStars = new HashSet<>();
            for (int j = 0; j < numberOfStars; j++) {
                String[] x = input.nextLine().trim().split(" ");
                set.add(new Star(Float.parseFloat(x[0]), 
                        Float.parseFloat(x[1]), Float.parseFloat(x[2])));

            }
            for (Star e : set) {
                for (Star f : set) {
                    if (e.distance(f) != 0) {
                        if (e.distance(f) < k) {
                            closeSet = new HashSet<>();
                            closeSet.add(e);
                            closeSet.add(f);
                            closeStars.add(closeSet);
                        }
                    }
                }
            }
            answer.add(closeStars.size());

        }
        for (Integer e : answer) {
            System.out.println(e);
        }
    }

}

class Star {

    Point3D position;

    Star(float x, float y, float z) {
        this.position = new Point3D(x, y, z);
    }

    public double distance(Star b) {
        return this.position.distance(b.position);
    }

}
