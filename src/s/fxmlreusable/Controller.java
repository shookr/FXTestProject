package s.fxmlreusable;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    System.out.println("loading User data...");
  }
}
