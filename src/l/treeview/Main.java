package l.treeview;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

  Stage window;
  TreeView<String> tree;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    window.setTitle(Main.class.getName());

    TreeItem<String> root;
    TreeItem<String> alex;
    TreeItem<String> felix;

    // Root
    root = new TreeItem<>();
    root.setExpanded(true);

    // alex
    alex = makeBranch("Alex", root);
    makeBranch("Memes", alex);
    makeBranch("Mate", alex);
    makeBranch("Java", alex);

    // felix
    felix = makeBranch("Felix", root);
    makeBranch("Japanisch", felix);
    makeBranch("Modelle", felix);


    //create tree
    tree = new TreeView<>(root);
    // hides the empty root:
    tree.setShowRoot(false);
    tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
      if (newValue != null) {
        System.out.println(oldValue + " to " + newValue);
      }
    });


    VBox layout = new VBox(10);
    layout.setPadding(new Insets(20,20,20,20));
    layout.getChildren().add(tree);

    Scene scene = new Scene(layout, 300, 250);
    window.setScene(scene);
    window.show();
  }

  private TreeItem<String> makeBranch(String name, TreeItem<String> parent) {
    TreeItem<String> item = new TreeItem<String>(name);
    item.setExpanded(true);
    parent.getChildren().add(item);
    return item;
  }

}