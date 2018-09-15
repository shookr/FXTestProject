package m.tableview;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.ParseException;

public class Main extends Application {

  Stage window;
  TableView<Product> table;
  TextField nameInput;
  TextField priceInput;
  TextField quantityInput;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    window.setTitle(Main.class.getName());


    TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
    nameColumn.setMinWidth(200);
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

    TableColumn<Product, Double> priceColumn = new TableColumn<>("Preis");
    priceColumn.setMinWidth(100);
    priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

    TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Anzahl");
    quantityColumn.setMinWidth(100);
    quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));



    //input
    nameInput = new TextField();
    nameInput.setPromptText("Name");
    nameInput.setMinWidth(100);

    priceInput= new TextField();
    priceInput.setPromptText("Preis");

    quantityInput = new TextField();
    quantityInput.setPromptText("Anzahl");

    Button addButton = new Button("hinzufügen");
    addButton.setOnAction(e -> addItem());
    Button deleteButton = new Button("löschen");
    deleteButton.setOnAction(e -> deleteItem());

    HBox hBox = new HBox();
    hBox.setPadding(new Insets(10,10,10,10));
    hBox.setSpacing(10);
    hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);




    table = new TableView<>();
    table.setItems(getProduct());
    table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);
    table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);



    VBox layout = new VBox();
    layout.getChildren().addAll(table, hBox);

    Scene scene = new Scene(layout);
    window.setScene(scene);
    window.show();
  }

  private void addItem() {
    Product product = new Product();
    String name;
    double price;
    int quantity;
    try {
      name = nameInput.getText();
      price = Double.parseDouble(priceInput.getText());
      quantity = Integer.parseInt(quantityInput.getText());
    } catch (NumberFormatException e) {
      System.out.println("Error while parsing");
      return;
    }
    product.setName(name);
    product.setPrice(price);
    product.setQuantity(quantity);
    table.getItems().add(product);

    nameInput.clear();
    priceInput.clear();
    quantityInput.clear();
  }

  private void deleteItem() {
    ObservableList<Product> productSelected;
    ObservableList<Product> allProducts;

    allProducts = table.getItems();
    productSelected = table.getSelectionModel().getSelectedItems();

    allProducts.removeAll(productSelected);
  }

  public ObservableList<Product> getProduct() {
    ObservableList<Product> products = FXCollections.observableArrayList();
    products.add(new Product("Laptop", 895.00, 20));
    products.add(new Product("Ball", 5.00, 198));
    products.add(new Product("Toilette", 303.00, 74));
    products.add(new Product("DVD", 12.99, 450));
    products.add(new Product("Mais", 1.49, 120));
    return products;
  }
}