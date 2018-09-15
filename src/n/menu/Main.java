package n.menu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

  Stage window;
  BorderPane layout;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    window.setTitle(Main.class.getName());


    // file menu
    Menu fileMenu = new Menu("_File");

    // file menu items
    MenuItem newFile = new MenuItem("New...");
    newFile.setOnAction(e -> System.out.println("New..."));
    fileMenu.getItems().add(newFile);
    fileMenu.getItems().add(new MenuItem("Open..."));
    fileMenu.getItems().add(new MenuItem("Save..."));
    fileMenu.getItems().add(new SeparatorMenuItem());
    fileMenu.getItems().add(new MenuItem("Settings..."));
    fileMenu.getItems().add(new SeparatorMenuItem());
    fileMenu.getItems().add(new MenuItem("Exit"));


    // edit menu
    Menu editMenu = new Menu("_Edit");

    // edit menu items
    editMenu.getItems().add(new MenuItem("Cut"));
    editMenu.getItems().add(new MenuItem("Copy"));
    MenuItem paste = new MenuItem("Paste");
    paste.setOnAction(e-> System.out.println("Paste"));
    paste.setDisable(true);
    editMenu.getItems().add(paste);


    // help menu
    Menu helpMenu = new Menu("_Help");

    // help menu items
    CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
    showLines.setOnAction(e -> {
      if(showLines.isSelected()) {
        System.out.println("Show lines now enabled");
      } else {
        System.out.println("Show lines now disabled");
      }
    });
    CheckMenuItem autoSave = new CheckMenuItem("Enable Autosave");
    autoSave.setSelected(true);
    helpMenu.getItems().addAll(showLines, autoSave);


    // difficulty menu
    Menu difficultyMenu = new Menu("Difficulty");

    // difficulty menu items
    ToggleGroup difficultyToggle = new ToggleGroup();
    RadioMenuItem easy = new RadioMenuItem("Easy");
    easy.setToggleGroup(difficultyToggle);
    RadioMenuItem medium = new RadioMenuItem("Medium");
    medium.setToggleGroup(difficultyToggle);
    RadioMenuItem hard = new RadioMenuItem("Hard");
    hard.setToggleGroup(difficultyToggle);

    difficultyMenu.getItems().addAll(easy, medium, hard);

    medium.setSelected(true);


    // Menubar
    MenuBar menuBar = new MenuBar();
    menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu, difficultyMenu);


    layout = new BorderPane();
    layout.setTop(menuBar);

    Scene scene = new Scene(layout, 400, 300);
    window.setScene(scene);
    window.show();
  }
}
