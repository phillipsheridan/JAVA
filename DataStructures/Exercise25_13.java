
package DataStructures;
/*
Phillip Sheridan
CSCI 2410
due: 10/26/15
*/
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author phillip
 */
public class Exercise25_13 extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    BST<Integer> tree = new BST<>(); // Create a tree

    BorderPane pane = new BorderPane();
    BTview view = new BTview(tree); // Create a View
    pane.setCenter(view);

    TextField tfKey = new TextField();
    tfKey.setPrefColumnCount(3);
    tfKey.setAlignment(Pos.BASELINE_RIGHT);
    Button btInsert = new Button("Insert");
    Button btDelete = new Button("Delete");
    Button btInorder = new Button("Show Inorder");
    Button btPreorder = new Button("Show Preorder");
    Button btPostorder = new Button("Show Postorder");
    HBox hBox = new HBox(5);
    hBox.getChildren().addAll(new Label("Enter a key: "),
      tfKey, btInsert, btDelete, btInorder, btPreorder, btPostorder);
    hBox.setAlignment(Pos.CENTER);
    pane.setBottom(hBox);

    btInsert.setOnAction(e -> {
      int key = Integer.parseInt(tfKey.getText());
      if (tree.search(key)) { // key is in the tree already
        view.displayTree();
        view.setStatus(key + " is already in the tree");
      } 
      else {
        tree.insert(key); // Insert a new key
        view.displayTree();
        view.setStatus(key + " is inserted in the tree");
      }
    });

    btDelete.setOnAction(e -> {
      int key = Integer.parseInt(tfKey.getText());
      if (!tree.search(key)) { // key is not in the tree
        view.displayTree();
        view.setStatus(key + " is not in the tree");
      } 
      else {
        tree.delete(key); // Delete a key
        view.displayTree();
        view.setStatus(key + " is deleted from the tree");
      }
    });
    btInorder.setOnAction(e -> {
        Label label = new Label(tree.inOrderList().toString());
        label.setTranslateX(300);
        
       view.displayLabel(label);
    });
    btPreorder.setOnAction(e -> {
        Label label = new Label(tree.preOrderList().toString());
        label.setTranslateX(300);
        
       view.displayLabel(label);
    });
    btPostorder.setOnAction(e -> {
        Label label = new Label(tree.postOrderList().toString());
        label.setTranslateX(300);
        
       view.displayLabel(label);
    });

    // Create a scene and place the pane in the stage
    Scene scene = new Scene(pane, 450, 250);
    primaryStage.setTitle("Exercise25_13"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
class BTview extends Pane {
  private BST<Integer> tree = new BST<>();
  private double radius = 15; // Tree node radius
  private double vGap = 50; // Gap between two levels in a tree

  BTview(BST<Integer> tree) {
    this.tree = tree;
    setStatus("Tree is empty");
  }

  public void setStatus(String msg) {
    getChildren().add(new Text(20, 20, msg));
  }
  public void displayLabel(Label msg) {
      getChildren().remove(getChildren().size() - 1);
      getChildren().add(msg);
  }

  public void displayTree() {
    this.getChildren().clear(); // Clear the pane
    if (tree.getRoot() != null) {
      // Display tree recursively    
      displayTree(tree.getRoot(), getWidth() / 2, vGap,
        getWidth() / 4);
    }
  }

  /** Display a subtree rooted at position (x, y) */
  private void displayTree(BST.TreeNode<Integer> root,
      double x, double y, double hGap) {
    if (root.left != null) {
      // Draw a line to the left node
      getChildren().add(new Line(x - hGap, y + vGap, x, y));
      // Draw the left subtree recursively
      displayTree(root.left, x - hGap, y + vGap, hGap / 2);
    }

    if (root.right != null) {
      // Draw a line to the right node
      getChildren().add(new Line(x + hGap, y + vGap, x, y));
      // Draw the right subtree recursively
      displayTree(root.right, x + hGap, y + vGap, hGap / 2);
    }
    
    // Display a node
    Circle circle = new Circle(x, y, radius);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.BLACK);
    getChildren().addAll(circle,
      new Text(x - 4, y + 4, root.element + ""));
  }
}
