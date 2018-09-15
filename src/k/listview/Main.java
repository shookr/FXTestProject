package k.listview;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

  Stage window;
  Button button;
  ListView<String> listView;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    window.setTitle(Main.class.getName());
    button = new Button("Click me");


    listView = new ListView<>();
    listView.getItems().addAll("Iron Man", "Avenger1", "Avengers2","Contact");
    listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


    button.setOnAction(e -> buttonClicked());


    VBox layout = new VBox(10);
    layout.setPadding(new Insets(20,20,20,20));
    layout.getChildren().addAll(button, listView);
    

    Scene scene = new Scene(layout, 300, 250);
    window.setScene(scene);
    window.show();
  }

  private void buttonClicked() {

    String message ="";

    ObservableList<String> movies;
    movies = listView.getSelectionModel().getSelectedItems();

    for (String movie : movies) {
      message += movie + "\n";
    }

    System.out.println(message);

  }

}