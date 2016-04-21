/*
Phillip Sheridan
CSCI 1302
due: 4/15/15
 */


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import static javafx.application.Application.launch;

public class Exercise14_01 extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);

        pane.setHgap(5.5);
        pane.setVgap(5.5);

        Image image1 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/US_flag_48_stars.svg/220px-US_flag_48_stars.svg.png");
        Image image2 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/US_flag_48_stars.svg/220px-US_flag_48_stars.svg.png");
        Image image3 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/US_flag_48_stars.svg/220px-US_flag_48_stars.svg.png");
        Image image4 = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/US_flag_48_stars.svg/220px-US_flag_48_stars.svg.png");

        pane.add(new ImageView(image1), 0, 0);
        pane.add(new ImageView(image2), 1, 0);
        pane.add(new ImageView(image3), 0, 1);
        pane.add(new ImageView(image4), 1, 1);

        Scene scene = new Scene(pane);

        primaryStage.setTitle("Exercise14_01");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
