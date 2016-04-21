/*
Phillip Sheridan
CSCI 1302
due: 4/15/15
 */

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Exercise14_03 extends Application {

    public void start(Stage primaryStage) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 52; i++) {
            list.add(i);
        }
        java.util.Collections.shuffle(list);

        Pane pane = new HBox();
        pane.autosize();

        pane.getChildren().addAll(new ImageView(new Image("phillip/card/"
                + list.get(0).toString() + ".png")), new ImageView(new Image("phillip/card/"
                                + list.get(1).toString() + ".png")), new ImageView(new Image("phillip/card/"
                                + list.get(2).toString() + ".png")));

        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("Exercise14_03");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }

}
