package a.scenecreation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CreateScene extends Application {

  Button button;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle(CreateScene.class.getName());

    button = new Button();
    button.setText("Click me");
    button.setOnAction(e -> {
      System.out.println("I love it when you touch me there.");
      System.out.println("lol");
    });


    StackPane layout = new StackPane();
    layout.getChildren().add(button);

    Scene scene = new Scene(layout, 300, 250);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

}
