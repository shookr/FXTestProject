package j.combobox;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

  Stage window;
  Button button;
  ComboBox<String> comboBox;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    window.setTitle(Main.class.getName());
    button = new Button("Click me");


    comboBox = new ComboBox<>();
    comboBox.getItems().addAll(
        "Good Will Hunting",
        "St.Vincent",
        "Blackhat"
    );

    comboBox.setPromptText("your favorite Movie?");

    button.setOnAction(e->printMovie());

    comboBox.setOnAction( e -> System.out.println("User selected: " + comboBox.getValue()));

    comboBox.setEditable(true);

    VBox layout = new VBox(10);
    layout.setPadding(new Insets(20,20,20,20));
    layout.getChildren().addAll(button, comboBox);


    Scene scene = new Scene(layout, 300, 250);
    window.setScene(scene);
    window.show();
  }

  private void printMovie() {
    System.out.println(comboBox.getValue());
  }

}