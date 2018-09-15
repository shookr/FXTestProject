package c.alerting;

import b.sceneswitching.SwitchScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AlertScene extends Application {

  Stage window;
  Button button;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    window.setTitle(AlertScene.class.getName());

    Button button = new Button("Go to Scene2");
    button.setOnAction(e -> AlertBox.display("You fucked up", "fuck"));

    StackPane layout = new StackPane();
    layout.getChildren().add(button);
    Scene scene = new Scene(layout, 300, 250);
    window.setScene(scene);
    window.show();
  }
}
