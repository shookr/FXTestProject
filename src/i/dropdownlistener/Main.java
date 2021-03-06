package i.dropdownlistener;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
    button = new Button("Click me");


    ChoiceBox<String> choiceBox = new ChoiceBox<>();

    choiceBox.getItems().addAll("Apples", "Bananas", "Bacon", "Ham", "Meatballs");
    choiceBox.setValue("Apples");


    choiceBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> System.out.println(oldValue + " -> " + newValue) );



    VBox layout = new VBox(10);
    layout.setPadding(new Insets(20,20,20,20));
    layout.getChildren().addAll(button, choiceBox);

    Scene scene = new Scene(layout, 300, 250);
    window.setScene(scene);
    window.show();
  }

}