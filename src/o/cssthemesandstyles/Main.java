package o.cssthemesandstyles;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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

    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10,10,10,10));
    grid.setVgap(8);
    grid.setHgap(10);

    Label nameLabel = new Label("Username:");
    nameLabel.setId("bold-label");
    GridPane.setConstraints(nameLabel, 0, 0);

    TextField nameInput = new TextField("Default");
    GridPane.setConstraints(nameInput, 1, 0);

    Label passwordLabel = new Label("Password:");
    GridPane.setConstraints(passwordLabel, 0, 1);

    TextField passwordInput = new TextField();
    passwordInput.setPromptText("hint");
    GridPane.setConstraints(passwordInput, 1, 1);

    Button loginButton = new Button("login");
    loginButton.setId("bold-label");
    GridPane.setConstraints(loginButton, 1,2);

    Button signUpButton = new Button("sign up");
    GridPane.setConstraints(signUpButton, 1,3);
    signUpButton.getStyleClass().add("button-blue");

    grid.getChildren().addAll(nameLabel, nameInput, passwordLabel, passwordInput, loginButton,signUpButton);


    Scene scene = new Scene(grid, 300, 250);

    scene.getStylesheets().add("o/cssthemesandstyles/style.css");

    window.setScene(scene);
    window.show();
  }

}