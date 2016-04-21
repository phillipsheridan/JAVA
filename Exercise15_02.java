/*
 Phillip Sheridan
 CSCI 1302
 due: 4/20/15
 
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise15_02 extends Application {

    private double angle = 0;

    @Override
    public void start(Stage primaryStage) {

        BorderPane pane = new BorderPane();
        Rectangle rectangle = new Rectangle(10, 10, 75, 100);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);

        Button btRotate = new Button("Rotate");

        btRotate.setOnAction(e -> {
            angle += 15;
            rectangle.setRotate(angle);
        });

        pane.setCenter(rectangle);
        pane.setBottom(btRotate);

        Scene scene = new Scene(pane, 200, 200);

        primaryStage.setTitle("Exercise 15_02");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);

    }

}
