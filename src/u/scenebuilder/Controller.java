package u.scenebuilder;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

  @FXML
  TextField loginInput;

  public void loginButtonClicked() {
    String login = loginInput.getText();
    System.out.println(login + " logged in");
  }
}
