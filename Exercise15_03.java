/*
 Phillip Sheridan
 CSCI 1302
 due: 4/22/15
 */
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Exercise15_03 extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane mainPane = new BorderPane();
        BorderPane.setAlignment(mainPane, Pos.CENTER);
        HBox hBox = new HBox();
        BallPane ballPane = new BallPane();
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");
        Button btUp = new Button("Up");
        Button btDown = new Button("Down");

        hBox.getChildren().addAll(btLeft, btRight, btUp, btDown);
        mainPane.setBottom(hBox);
        mainPane.setCenter(ballPane);
        hBox.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(ballPane, Pos.CENTER);

        btLeft.setOnAction(e -> {
            if (ballPane.x > 0) {
                ballPane.left();
            } else {

            }

        });

        btRight.setOnAction(e -> {
            if (ballPane.x < ballPane.getWidth()) {
                ballPane.right();
            } else {

            }

        });

        btUp.setOnAction(e -> {
            if (ballPane.y > 0) {
                ballPane.up();
            } else {
            }

        });

        btDown.setOnAction(e -> {
            if (ballPane.y < ballPane.getHeight() - 90) {
                ballPane.down();
            } else {

            }
        });

        Scene scene = new Scene(mainPane, 400, 400);

        primaryStage.setTitle("Exercise15_03");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}

class BallPane extends Pane {

    double x = 100;
    double y = 100;
    private Circle circle = new Circle(x, y, 50);

    public BallPane() {
        getChildren().add(circle);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
    }

    public void left() {
        x -= 30;
        circle.setCenterX(x);
    }

    public void right() {
        x += 30;
        circle.setCenterX(x);
    }

    public void up() {
        y -= 30;
        circle.setCenterY(y);
    }

    public void down() {
        y += 30;
        circle.setCenterY(y);
    }
}
