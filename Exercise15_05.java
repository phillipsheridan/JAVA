/*
Phillip Sheridan
CSCI 1302
due: 4/22/15
*/


import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Exercise15_05 extends Application {
    private TextField tfInvestmentAmount = new TextField();
    private TextField tfNumberOfYears = new TextField();
    private TextField tfAnnualInterestRate = new TextField();
    private TextField tfFutureValue = new TextField();
    private Button btCalculate = new Button("Calculate");
    
    public void start(Stage primaryStage) {
       GridPane gridPane = new GridPane();
       gridPane.setHgap(5);
       gridPane.setVgap(5);
       gridPane.add(new Label("Investment Amount:"), 0, 0);
       gridPane.add(tfInvestmentAmount, 1, 0);
       gridPane.add(new Label("Number Of Years:"), 0, 1);
       gridPane.add(tfNumberOfYears, 1, 1);
       gridPane.add(new Label("Annual Interest Rate:"), 0, 2);
       gridPane.add(tfAnnualInterestRate, 1, 2);
       gridPane.add(new Label("Future Value:"), 0, 3);
       gridPane.add(tfFutureValue, 1, 3);
       gridPane.add(btCalculate, 1, 4);
       
       gridPane.setAlignment(Pos.CENTER);
       tfInvestmentAmount.setAlignment(Pos.BOTTOM_RIGHT);
       tfNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
       tfAnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
       tfFutureValue.setAlignment(Pos.BOTTOM_RIGHT);
       GridPane.setHalignment(btCalculate, HPos.RIGHT);
       tfFutureValue.setEditable(false);
       
       btCalculate.setOnAction(e -> calculateFutureValue());
       
       Scene scene = new Scene(gridPane, 400, 400);
       
       primaryStage.setTitle("Exercise15_05");
       primaryStage.setScene(scene);
       primaryStage.show();
       
       
       
    }
    public static void main(String[] args) {
        launch(args);
        
    }
    public void calculateFutureValue() {
        double investmentAmount = Double.parseDouble(tfInvestmentAmount.getText());
        double monthlyInterestRate = (Double.parseDouble(tfAnnualInterestRate.getText())/100) / 12;
        double futureValue = investmentAmount * Math.pow((1 + monthlyInterestRate), 
                Double.parseDouble(tfNumberOfYears.getText()) * 12);
        
        tfFutureValue.setText(String.format("$%.2f", futureValue));
        
    }
    
}
