package g.inputoutput;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    window.setTitle(Main.class.getName());


    TextField nameInput = new TextField();

    button = new Button("Click me");
    button.setOnAction(e -> {
      if(isInt(nameInput, nameInput.getText())) {
        System.out.println(nameInput.getText());
      }
    });


    VBox layout = new VBox(10);
    layout.setPadding(new Insets(20,20,20,20));
    layout.getChildren().addAll(nameInput, button);

    Scene scene = new Scene(layout, 300, 250);
    window.setScene(scene);
    window.show();
  }

  private boolean isInt(TextField input, String message) {
    try {
      int age = Integer.parseInt(message);
      System.out.println("User is " + age);
      return true;
    } catch (NumberFormatException e) {
      System.out.println("Error: " + message + " is not a valid number");
      return false;
    }

  }


}