
import java.util.ArrayList;
import java.util.Scanner;
import javafx.geometry.Point2D;

public class Exercise22_09 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of points: ");
        final int n = input.nextInt();
        System.out.println("Enter a list of points separated by white space: ");
        double[][] points = new double[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = input.nextDouble();
            points[i][1] = input.nextDouble();
            
        }

        System.out.println("The points in the convex hull are: " + getConvexHull(points));

    }

    public static ArrayList<Point2D> getConvexHull(double[][] x) {

        ArrayList<Point2D> list = new ArrayList<>();

        Point2D[] checkList = new Point2D[x.length];
        for (int i = 0; i < x.length; i++) {
            checkList[i] = new Point2D(x[i][0], x[i][1]);
        }
        Point2D h0 = findRightMostPoint(checkList);
        list.add(h0);

        Point2D startingPoint = h0;
        

        while (true) {
            Point2D currentPoint = checkList[0];
            for (int i = 1; i < checkList.length; i++) {
                double number = leftOrRight(startingPoint, currentPoint, checkList[i]);

                if (number > 0) { //right side of the line

                    currentPoint = checkList[i];

                } else if (number == 0) {
                    if (startingPoint.distance(checkList[i]) > startingPoint.distance(currentPoint)) {
                        currentPoint = checkList[i];
                    }

                } 

            }

            if (currentPoint.equals(h0)) {
                break;
            } else {
            list.add(currentPoint);
            startingPoint = currentPoint;
            }

        }
        return list;
    }

    public static Point2D findRightMostPoint(Point2D[] x) {
        double rightMostX = x[0].getX();
        double rightMostY = x[0].getY();
        int rightMostIndex = 0;
        Point2D rightMost = x[0];
        for (int i = 1; i < x.length; i++) {
            if (x[i].getY() > rightMost.getY()) {
                rightMostX = x[i].getX();
                rightMostY = x[i].getY();
                rightMostIndex = i;
            }
                else if (rightMostY == x[i].getY() && rightMostX < x[i].getX()) {
            rightMostX = x[i].getX();
            rightMostIndex = i;
          }


            
        }
        
        return x[rightMostIndex];
    }

    public static double leftOrRight(Point2D a, Point2D b, Point2D c) {
        return ((b.getX() - a.getX()) * (c.getY() - a.getY())) - ((b.getY() - a.getY()) * (c.getX() - a.getX()));

    }

}
