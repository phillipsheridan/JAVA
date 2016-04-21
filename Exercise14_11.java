/*
Phillip Sheridan
CSCI 1302
due: 4/17/15
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 *
 * @author phillip1
 */
public class Exercise14_11 extends Application{
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        
        Circle head = new Circle();
        head.setStroke(Color.BLACK);
        head.setRadius(100);
        head.setCenterX(100);
        head.setCenterY(100);
        head.setFill(null);
        
        Ellipse eye1 = new Ellipse(140, 50, 30, 20);
        
        eye1.setFill(null);
        eye1.setStroke(Color.BLACK);
        
        Ellipse eye2 = new Ellipse(60, 50, 30, 20);
        
        eye2.setStroke(Color.BLACK);
        eye2.setFill(null);
        
        Circle eyeball1 = new Circle(140, 50, 10);
        eyeball1.setStroke(Color.BLACK);
        eyeball1.setFill(Color.BLACK);
        
        Circle eyeball2 = new Circle(60, 50, 10);
        eyeball1.setStroke(Color.BLACK);
        eyeball1.setFill(Color.BLACK); 
        
        Arc mouth = new Arc(100, 160, 30, 20, 0, -180);
        mouth.setStroke(Color.BLACK);
        mouth.setFill(null);
        
        Polygon nose = new Polygon(100, 80, 80, 120 , 120, 120);
        nose.setStroke(Color.BLACK);
        nose.setFill(Color.BLACK);
        
        pane.getChildren().addAll(head, eye1, eye2, eyeball1, eyeball2, mouth,
                nose);
        
        
        
        Scene scene = new Scene(pane, 200, 200);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise14_11");
        primaryStage.show();
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
