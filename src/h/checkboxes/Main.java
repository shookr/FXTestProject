package h.checkboxes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

  Stage window;
  Button button;
  Label label;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    window.setTitle(Main.class.getName());


    CheckBox box1 = new CheckBox("Bacon");
    CheckBox box2 = new CheckBox("Tuna");
    box2.setSelected(true);

    button = new Button("Order now");
    button.setOnAction(e -> handleOptions(box1, box2));

    label = new Label("");


    VBox layout = new VBox(10);
    layout.setPadding(new Insets(20,20,20,20));
    layout.getChildren().addAll(box1, box2, button, label);

    Scene scene = new Scene(layout, 300, 250);
    window.setScene(scene);
    window.show();
  }

  private void handleOptions(CheckBox box1, CheckBox box2) {
    String message = "User order: ";

    if (box1.isSelected()) {
      message += "Bacon";
    }

    if (box2.isSelected()) {
      message += "Tuna";
    }

    System.out.println(message);
    label.setText(message);
  }

}