package p.properties;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
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

    Person bucky = new Person();

    bucky.firstNameProperty().addListener((v, oldValue, newValue) -> {
      System.out.println(oldValue + " becomes " + newValue);
      System.out.println(bucky.firstNameProperty());
      System.out.println(bucky.getFirstName());
    });

    button = new Button("Submit");
    button.setOnAction(e -> bucky.setFirstName("Bucky"));


    StackPane layout = new StackPane();
    layout.getChildren().add(button);
    Scene scene = new Scene(layout, 300, 250);
    window.setScene(scene);
    window.show();
  }

}