/*
 Phillip Sheridan
 CSCI 1302
 due: 4/20/15
 
 */
import java.util.ArrayList;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercise15_01 extends Application {

    @Override
    public void start(Stage primaryStage) {
        HBox pane = new HBox();
        Pane mainPane = new VBox();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 52; i++) {
            list.add(i);
        }
        java.util.Collections.shuffle(list);

        pane.getChildren().addAll(new ImageView(new Image("phillip/card/"
                + list.get(0).toString() + ".png")), new ImageView(new Image("phillip/card/"
                                + list.get(1).toString() + ".png")), new ImageView(new Image("phillip/card/"
                                + list.get(2).toString() + ".png")), new ImageView(new Image("phillip/card/"
                                + list.get(3).toString() + ".png")));

        Button btRefresh = new Button("Refresh");
        mainPane.getChildren().addAll(pane, btRefresh);

        btRefresh.setOnAction(e -> {
            pane.getChildren().clear();
            java.util.Collections.shuffle(list);

            pane.getChildren().addAll(new ImageView(new Image("phillip/card/"
                    + list.get(0).toString() + ".png")), new ImageView(new Image("phillip/card/"
                                    + list.get(1).toString() + ".png")), new ImageView(new Image("phillip/card/"
                                    + list.get(2).toString() + ".png")), new ImageView(new Image("phillip/card/"
                                    + list.get(3).toString() + ".png")));

        });

        Scene scene = new Scene(mainPane, 400, 150);
        primaryStage.setTitle("Exercise15_01");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
