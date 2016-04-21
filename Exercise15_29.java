/*
Phillip Sheridan
CSCI 1302
due: 4/29/15
*/
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Exercise15_29 extends Application {

    PathTransition animation = new PathTransition();

    public void start(Stage primaryStage) {

        Pane pane = new Pane();

        Scene scene = new Scene(pane, 400, 400);

        Line line = new Line(0, scene.getHeight(), scene.getWidth(), scene.getHeight());
        line.setStroke(Color.WHITE);
        Car car = new Car();

        animation.setCycleCount(Timeline.INDEFINITE);
        animation.setDuration(Duration.millis(3000));
        animation.setPath(line);
        animation.setNode(car);
        animation.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        animation.setInterpolator(Interpolator.LINEAR);
        animation.play();

        pane.getChildren().addAll(car, line);
        
        pane.setOnMouseReleased(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                animation.pause();
            } else if (e.getButton() == MouseButton.SECONDARY) {
                animation.play();
            }
            
        });
        pane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                animation.setRate(animation.getRate() * 2);
            } else if (e.getCode() == KeyCode.DOWN) {
                animation.setRate(animation.getRate() / 2);
            }
        });

        
        

        primaryStage.setTitle("Exercise15_29");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        pane.requestFocus();

        
        

    }

    public static void main(String[] args) {
        launch(args);
    }

    class Car extends Pane {

        double x = 5;
        double y = 12;

        public Car() {
            Circle wheel1 = new Circle(x + 27, y - 2, 2);
            Circle wheel2 = new Circle(x + 47, y - 2, 2);
            Rectangle body1 = new Rectangle(x + 25, y - 15, 25, 10);
            Polygon body2 = new Polygon(x + 28, y - 15, x + 30, y - 25, x + 38, y - 25, x + 45, y - 15);

            wheel1.setStroke(Color.BLACK);
            wheel1.setFill(Color.BLACK);

            wheel2.setStroke(Color.BLACK);
            wheel2.setFill(Color.BLACK);

            body1.setStroke(Color.LIGHTGREEN);
            body1.setFill(Color.LIGHTGREEN);

            body2.setFill(Color.GREEN);
            body2.setStroke(Color.GREEN);

            this.getChildren().addAll(wheel1, wheel2, body1, body2);
        }
    }

}
