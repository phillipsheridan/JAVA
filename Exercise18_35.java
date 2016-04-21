/*
 Phillip Sheridan
 CSCI 2410
 due: 8/26/15
 */

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Exercise18_35 extends Application {

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        HTreePane hPane = new HTreePane();
        TextField tfOrder = new TextField();
        tfOrder.setOnAction(
                e -> hPane.setOrder(Integer.parseInt(tfOrder.getText())));
        tfOrder.setPrefColumnCount(4);
        tfOrder.setAlignment(Pos.BOTTOM_RIGHT);

        // Pane to hold label, text field, and a button
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(new Label("Enter an order: "), tfOrder);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(hPane);
        borderPane.setBottom(hBox);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 400, 400);
        primaryStage.setTitle("Exercise18_35"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        scene.widthProperty().addListener(ov -> hPane.paint());
        scene.heightProperty().addListener(ov -> hPane.paint());
    }

    /**
     * Pane for displaying triangles
     */
    static class HTreePane extends Pane {

        private int order = 0;

        /**
         * Set a new order
         */
        public void setOrder(int order) {
            this.order = order;
            paint();

        }

        HTreePane() {
        }

        protected void paint() {
            // Select center of panel
            Point2D center = new Point2D(getWidth() / 2, getHeight() / 2);
            double size = 30;

            this.getChildren().clear(); // Clear the pane before redisplay
            displayH(order, center, size);
        }

        private void displayH(int order, Point2D center, double size) {
            Line line1 = new Line(center.getX() - size, center.getY()
                    - size, center.getX() - size, center.getY() + size);
            Line line2 = new Line(center.getX() + size, center.getY()
                    - size, center.getX() + size, center.getY() + size);
            Line line3 = new Line(center.getX() - size, center.getY(),
                    center.getX() + size, center.getY());
            if (order == 0) {

                this.getChildren().addAll(line1, line2, line3);

            } else {
                this.getChildren().addAll(line1, line2, line3);

                // Get the tips on each H
                Point2D center1 = new Point2D(center.getX() - size,
                        center.getY() - size);
                Point2D center2 = new Point2D(center.getX() - size,
                        center.getY() + size);
                Point2D center3 = new Point2D(center.getX() + size,
                        center.getY() - size);
                Point2D center4 = new Point2D(center.getX() + size,
                        center.getY() + size);

                // Recursively display four H's
                displayH(order - 1, center1, size / 2.0);
                displayH(order - 1, center2, size / 2.0);
                displayH(order - 1, center3, size / 2.0);
                displayH(order - 1, center4, size / 2.0);
            }
        }
    }

    /**
     * The main method is only needed for the IDE with limited JavaFX support.
     * Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
