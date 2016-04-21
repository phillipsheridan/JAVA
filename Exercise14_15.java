/*
Phillip Sheridan
CSCI 1302
due: 4/17/15
*/


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author phillip1
 */
public class Exercise14_15 extends Application {
    public void start(Stage primaryStage) {
        Pane pane = new StackPane();
        Polygon octagon = new Polygon();
        Text stop = new Text(100, 100, "STOP");
        pane.getChildren().addAll(octagon, stop);
        octagon.setStroke(Color.RED);
        octagon.setFill(Color.RED);
        stop.setStroke(Color.WHITE);
        stop.setFill(Color.WHITE);
        stop.setFont(Font.font(50));
        ObservableList<Double> list = octagon.getPoints();
        
        final double WIDTH = 200, HEIGHT = 200;
        double centerX = WIDTH / 2, centerY = WIDTH / 2;
        double radius = Math.min(WIDTH, HEIGHT) * 0.4;
        
        for (int i = 0; i < 8; i++) {
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / 8));
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / 8));
        }
        octagon.setRotate(23);
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle("Exercise 14_15");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }
    public static void main(String[] args) {
        launch(args);
    }
}
