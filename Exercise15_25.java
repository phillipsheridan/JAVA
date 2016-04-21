
/*
 Phillip Sheridan
 CSCI 1302
 due: 4/27/15
 */
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise15_25 extends Application {

    @Override
    public void start(Stage primaryStage) {

        Polyline polyline = new Polyline();
        for (double angle = -380; angle <= 380; angle++) {
            polyline.getPoints().addAll(
                    angle, -Math.sin(Math.toRadians(1.5 * angle)));
        }
        polyline.setTranslateY(100);
        polyline.setTranslateX(200);
        polyline.setScaleX(0.5);
        polyline.setScaleY(50);
        polyline.setStrokeWidth(1.0 / 25);

        Line line1 = new Line(10, 100, 420, 100);
        Line line2 = new Line(420, 100, 400, 90);
        Line line3 = new Line(420, 100, 400, 110);

        Line line4 = new Line(200, 10, 200, 200);
        Line line5 = new Line(200, 10, 190, 30);
        Line line6 = new Line(200, 10, 210, 30);

        Text text1 = new Text(380, 70, "X");
        Text text2 = new Text(220, 20, "Y");
        Text text0 = new Text(205, 110, "0");
        Text textPi = new Text(260, 110, "\u03C0");
        Text text2Pi = new Text(315, 110, "2\u03C0");
        Text textNegPi = new Text(137, 110, "-\u03C0");
        Text textNeg2Pi = new Text(70, 110, "-2\u03C0");

        Circle circle = new Circle(40, 40, 5);
        circle.setStroke(Color.ORANGE);
        circle.setFill(Color.ORANGE);

        PathTransition pt = new PathTransition();
        pt.setAutoReverse(true);
        pt.setNode(circle);
        pt.setDuration(Duration.millis(4000));
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setPath(polyline);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play();

        Pane pane = new Pane();
        pane.getChildren().addAll(polyline, line1, line2, line3, line4,
                line5, line6, text1, text2, circle, text0, textPi, text2Pi, textNegPi,
                textNeg2Pi);

        pane.setOnMouseReleased(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                pt.play();
            } else if (e.getButton() == MouseButton.SECONDARY) {
                pt.pause();
            }
        });

        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("Exercise15_25");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
