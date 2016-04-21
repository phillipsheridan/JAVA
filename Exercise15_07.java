/*
 Phillip Sheridan
CSCI 1302
due: 4/24/15
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Exercise15_07 extends Application {
    public void start(Stage primaryStage) {
        StackPane stackPane = new StackPane();
        Circle circle = new Circle(40, 40, 30);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        
        stackPane.getChildren().add(circle);
        
        circle.setOnMousePressed(e -> {
            circle.setFill(Color.PINK);
        });
        circle.setOnMouseReleased(e -> {
            circle.setFill(Color.WHITE);
        });
        
        Scene scene = new Scene(stackPane, 400, 400);
        
        primaryStage.setTitle("Exercise15_07");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
