import java.util.Stack;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author phillip
 */
public class Project8 extends Application {
    public void start(Stage primaryStage) {
        
        BorderPane pane = new BorderPane();
        Label inputLabel = new Label("Input:");
        
        Label stackLabel = new Label("Stack:");
        
        Label outputLabel = new Label("Output:");
        
        TextField tfInput = new TextField();
        tfInput.setMinWidth(500.0);
        tfInput.setEditable(false);
        TextField tfStack = new TextField();
        tfStack.setMinWidth(498.0);
        tfStack.setEditable(false);
        TextField tfOutput = new TextField();
        tfOutput.setMinWidth(490.0);
        tfOutput.setEditable(false);
        VBox vBox = new VBox();
        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(inputLabel, tfInput);
        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(stackLabel, tfStack);
        HBox hBox3 = new HBox();
        hBox3.getChildren().addAll(outputLabel, tfOutput);
        vBox.getChildren().addAll(hBox1, hBox2, hBox3);
        pane.setTop(vBox);
        Button btA = new Button("a");
        btA.setMinHeight(30);
        btA.setMinWidth(100);
        btA.setOnMouseReleased(e -> {
            if (tfInput.getCharacters().length() > 0) {
            tfInput.insertText(tfInput.getCharacters().length(), "a");
            }
            else {
                tfInput.insertText(0, "a");
            }
            
        });
        Button btB = new Button("b");
        btB.setMinHeight(30);
        btB.setMinWidth(100);
        btB.setOnMouseReleased(e -> {
            if (tfInput.getCharacters().length() > 0) {
            tfInput.insertText(tfInput.getCharacters().length(), "b");
            }
            else {
                tfInput.insertText(0, "b");
            }
            
        });
        Button btC = new Button("c");
        btC.setMinHeight(30);
        btC.setMinWidth(100);
        btC.setOnMouseReleased(e -> {
            if (tfInput.getCharacters().length() > 0) {
            tfInput.insertText(tfInput.getCharacters().length(), "c");
            }
            else {
                tfInput.insertText(0, "c");
            }
            
        });
        Button btD = new Button("d");
        btD.setMinHeight(30);
        btD.setMinWidth(100);
        btD.setOnMouseReleased(e -> {
            if (tfInput.getCharacters().length() > 0) {
            tfInput.insertText(tfInput.getCharacters().length(), "d");
            }
            else {
                tfInput.insertText(0, "d");
            }
            
        });
        Button btPlus = new Button("+");
        btPlus.setMinHeight(30);
        btPlus.setMinWidth(100);
        btPlus.setOnMouseReleased(e -> {
            if (tfInput.getCharacters().length() > 0) {
            tfInput.insertText(tfInput.getCharacters().length(), "+");
            }
            else {
                tfInput.insertText(0, "+");
            }
            
        });
        Button btMinus = new Button("-");
        btMinus.setMinHeight(30);
        btMinus.setMinWidth(100);
        btMinus.setOnMouseReleased(e -> {
            if (tfInput.getCharacters().length() > 0) {
            tfInput.insertText(tfInput.getCharacters().length(), "-");
            }
            else {
                tfInput.insertText(0, "-");
            }
            
        });
        Button btMult = new Button("*");
        btMult.setMinHeight(30);
        btMult.setMinWidth(100);
        btMult.setOnMouseReleased(e -> {
            if (tfInput.getCharacters().length() > 0) {
            tfInput.insertText(tfInput.getCharacters().length(), "*");
            }
            else {
                tfInput.insertText(0, "*");
            }
            
        });
        Button btDiv = new Button("/");
        btDiv.setMinHeight(30);
        btDiv.setMinWidth(100);
        btDiv.setOnMouseReleased(e -> {
            if (tfInput.getCharacters().length() > 0) {
            tfInput.insertText(tfInput.getCharacters().length(), "/");
            }
            else {
                tfInput.insertText(0, "/");
            }
            
        });
        Button btLeftPar = new Button("(");
        btLeftPar.setMinHeight(30);
        btLeftPar.setMinWidth(100);
        btLeftPar.setOnMouseReleased(e -> {
            if (tfInput.getCharacters().length() > 0) {
            tfInput.insertText(tfInput.getCharacters().length(), "(");
            }
            else {
                tfInput.insertText(0, "(");
            }
            
        });
        Button btRightPar = new Button(")");
        btRightPar.setMinHeight(30);
        btRightPar.setMinWidth(100);
        btRightPar.setOnMouseReleased(e -> {
            if (tfInput.getCharacters().length() > 0) {
            tfInput.insertText(tfInput.getCharacters().length(), ")");
            }
            else {
                tfInput.insertText(0, ")");
            }
            
        });
        Button btClear = new Button("Clear");
        btClear.setMinHeight(30);
        btClear.setMinWidth(100);
        btClear.setOnMouseReleased(e -> {
            tfInput.clear();
            tfStack.clear();
            tfOutput.clear();
        });
        Button btExit = new Button("Exit");
        btExit.setMinHeight(30);
        btExit.setMinWidth(100);
        btExit.setOnMouseReleased(e -> {
            System.exit(0);
            
        });
        GridPane grid = new GridPane();
        grid.addRow(0, btA, btB, btC, btD);
        grid.addRow(1, btPlus, btMinus, btMult, btDiv);
        grid.addRow(2, btLeftPar, btRightPar, btClear, btExit);
        
        pane.setCenter(grid);
        
        Scene scene = new Scene(pane, 700, 200);
        primaryStage.setTitle("Project8"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
        
        while (true) {
            InfixToPostFixEvaluation eval = new InfixToPostFixEvaluation();
            InfixToPostFixEvaluation.convertToPostfix(tfInput.getCharacters().toString());
            
            
            
        }
    }
    public static void main(String[] args) {
    launch(args);
  }
    

/*
 * 
Algorithm
1. Scan the infix expression from left to right.
2. If the scanned character is an operand, output it.
3. Else,
…..3.1 If the precedence of the scanned operator is greater than the precedence of the operator in the stack(or the stack is empty), push it.
…..3.2 Else, Pop the operator from the stack until the precedence of the scanned operator is less-equal to the precedence of the operator residing on the top of the stack. Push the scanned operator to the stack.
4. If the scanned character is an ‘(‘, push it to the stack.
5. If the scanned character is an ‘)’, pop and output from the stack until an ‘(‘ is encountered.
6. Repeat steps 2-6 until infix expression is scanned.
7. Pop and output from the stack until it is not empty.

 */
public static class InfixToPostFixEvaluation {

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' || c == ')';
    }

    private static int getPrecedence(char ch) {
        switch (ch) {
        case '+':
        case '-':
            return 1;

        case '*':
        case '/':
            return 2;

        case '^':
            return 3;
        }
        return -1;
    }

    // A utility function to check if the given character is operand
    private static boolean isOperand(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    public static String convertToPostfix(String infix) {
        Stack<Character> stack = new Stack<Character>();
        StringBuffer postfix = new StringBuffer(infix.length());
        char c;

        for (int i = 0; i < infix.length(); i++) {
            c = infix.charAt(i);

            if (isOperand(c)) {
                postfix.append(c);
                
            } else if (c == '(') {
                stack.push(c);
            }
            // If the scanned character is an ‘)’, pop and output from the stack
            // until an ‘(‘ is encountered.
            else if (c == ')') {

                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(')
                    return null;
                else if(!stack.isEmpty())
                    stack.pop();
            }
            else if (isOperator(c)) // operator encountered
            {
                if (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

}
}
