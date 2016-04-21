
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise15_04 extends Application {

    BorderPane pane = new BorderPane();
    HBox hBox1 = new HBox();
    HBox hBox2 = new HBox();
    TextField tfNumber1 = new TextField();
    TextField tfNumber2 = new TextField();
    TextField tfResult = new TextField();
    Button btAdd = new Button("Add");
    Button btSubtract = new Button("Subtract");
    Button btMultiply = new Button("Multiply");
    Button btDivide = new Button("Divide");

    public void start(Stage primaryStage) {
        

        tfNumber1.setMaxWidth(60);

        tfNumber2.setMaxWidth(60);

        tfResult.setMaxWidth(60);
        tfResult.setEditable(false);
        hBox1.getChildren().addAll(new Label("Number 1: "), tfNumber1,
                new Label("Number 2: "), tfNumber2, new Label("Result: "),
                tfResult);

        hBox2.getChildren().addAll(btAdd, btSubtract, btMultiply, btDivide);
        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
        pane.setTop(hBox1);
        pane.setBottom(hBox2);

        Scene scene = new Scene(pane, 400, 70);

        btAdd.setOnAction(e -> {
            add();
        });
        btSubtract.setOnAction(e -> {
            subtract();
        });
        btMultiply.setOnAction(e -> {
            multiply();
        });
        btDivide.setOnAction(e -> {
            divide();
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise15_04");
        primaryStage.show();

    }

    public void add() {

        double result = Double.parseDouble(tfNumber1.getText()) + Double.parseDouble(tfNumber2.getText());
        tfResult.setText(String.valueOf(result));

    }

    public void subtract() {
        double result = Double.parseDouble(tfNumber1.getText()) - Double.parseDouble(tfNumber2.getText());
        tfResult.setText(String.valueOf(result));

    }

    public void multiply() {
        double result = Double.parseDouble(tfNumber1.getText()) * Double.parseDouble(tfNumber2.getText());
        tfResult.setText(String.valueOf(result));

    }

    public void divide() {
        double result = Double.parseDouble(tfNumber1.getText()) / Double.parseDouble(tfNumber2.getText());
        tfResult.setText(String.valueOf(result));

    }

    public static void main(String[] args) {
        launch(args);
    }

}
