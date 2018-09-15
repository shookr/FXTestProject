package d.communication;

import b.sceneswitching.SwitchScene;
import c.alerting.AlertBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    Button button = new Button("Go");
    button.setOnAction(e -> {
      boolean result = ConfirmBox.display("Question", "You want to send this?");
      System.out.println("clicked " +  result);
    });

    StackPane layout = new StackPane();
    layout.getChildren().add(button);
    Scene scene = new Scene(layout, 300, 250);
    window.setScene(scene);
    window.show();
  }
}
