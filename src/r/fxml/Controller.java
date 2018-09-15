package r.fxml;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

  Button button;

  public void handleButtonClick() {
    System.out.println("clicked");
    button.setText("Stop touching me!");
  }

}
