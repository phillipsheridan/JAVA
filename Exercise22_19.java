/*
 Phillip Sheridan
 CSCI 2410
 due: 9/30/15
 */

import java.util.Random;
import java.util.Stack;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise22_19 extends Application {

    final int SIZE = 10;
    TextField[][] tf = new TextField[SIZE][SIZE];

    @Override // Override start method in the Application class
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);

        // Initialize the text fields and add to the TextField array
        refresh();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                gridPane.add(tf[i][j], j, i);
            }
        }

        // Create buttons and add to gridPane
        Button btRefresh = new Button("Refresh");
        Button btFindLargestBlock = new Button("Find Largest Block");
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(btRefresh, btFindLargestBlock);
        hBox.setAlignment(Pos.CENTER);
        borderPane.setBottom(hBox);

        // Handler for refresh button
        btRefresh.setOnAction((ActionEvent e) -> {
            // Remove tf each time the refresh button is clicked, add refreshed tf
            gridPane.getChildren().remove(tf);
            refresh();
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    gridPane.add(tf[i][j], j, i);
                }
            }
        });
        btFindLargestBlock.setOnAction(e -> search2());

        // Create a scene and place the pane in the stage
        Scene scene = new Scene(borderPane, 500, 500);
        primaryStage.setTitle("Exercise 22_19"); // Set the stage title
        primaryStage.setScene(scene);            // Place the scene in the stage
        primaryStage.show();                     // Display the stage

    }

    /**
     * Convert boolean (from random boolean distribution) to int
     */
    public int booleanToInt(boolean bool) {
        if (bool) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Fill pane with 0's and 1's obtained from Boolean distribution
     */
    public void refresh() {
        Random rand = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                tf[i][j] = new TextField();
                tf[i][j].setText(String.valueOf(booleanToInt(rand.nextBoolean())));
                tf[i][j].setStyle("-fx-background-color: white");
            }
        }
    }

    public void search2() {
        int[][] result = new int[SIZE][SIZE];
        int max = 0;
        int a = 0;
        int b = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (j == 0 || i == 0) {
                    result[i][j] = Integer.valueOf(tf[i][j].getText());
                } else if (Integer.valueOf(tf[i][j].getText()) == 0) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = Math.min(result[i - 1][j - 1], Math.min(result[i - 1][j], result[i][j - 1])) + 1;
                    if (max < result[i][j]) {
                        max = result[i][j];
                        a = i;
                        b = j;
                    }
                }
            }
        }

        for (int i = a; i > a - max; i--) {
            for (int j = b; j > b - max; j--) {
                tf[i][j].setStyle("-fx-background-color: red;");
            }
        }

    }

    public int min(int a, int b, int c) {
        int m = a;
        if (m > b) {
            m = b;
        }
        if (m > c) {
            m = c;
        }
        return m;
    }

    /**
     * The main method is only needed for the IDE with limited JavaFX support.
     * Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }

}
