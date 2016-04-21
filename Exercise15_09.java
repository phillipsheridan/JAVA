import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/*
 Phillip Sheridan
CSCI 1302
due: 4/24/15
 */


public class Exercise15_09 extends Application {
    private int x = 100;
    private int y = 100;
    public void start(Stage primaryStage) {
        
        Pane pane = new Pane();
        
        pane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                pane.getChildren().add(new Line(x, y, x, y -= 1));
            }
            else if(e.getCode() == KeyCode.DOWN) {
                pane.getChildren().add(new Line(x, y, x, y += 1));
            }
            else if(e.getCode() == KeyCode.LEFT) {
                pane.getChildren().add(new Line(x, y, x -= 1, y));
                
            }
            else if(e.getCode() == KeyCode.RIGHT) {
                pane.getChildren().add(new Line(x, y, x += 1, y));
                
            }
            
                
        });
        
        Scene scene = new Scene(pane, 400, 400);
        
        primaryStage.setTitle("Exercise15_09");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        pane.requestFocus();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
