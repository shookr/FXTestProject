package e.closing;

import b.sceneswitching.SwitchScene;
import d.communication.ConfirmBox;
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
    window.setOnCloseRequest(e -> {
      e.consume();
      closeProperly();
    });

    Button button = new Button("Close properly");
    button.setOnAction(e ->  closeProperly());

    StackPane layout = new StackPane();
    layout.getChildren().add(button);
    Scene scene = new Scene(layout, 300, 250);
    window.setScene(scene);
    window.show();
  }

  private void closeProperly() {
    if (ConfirmBox.display("sure?", "are you sure?")) {
      System.out.println("saving...");
      System.out.println("saved");
      window.close();
    }
  }
}