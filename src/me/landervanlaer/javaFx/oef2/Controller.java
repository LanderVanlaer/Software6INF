package me.landervanlaer.javaFx.oef2;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    public Label label;
    public TextField firstName;
    public TextField lastName;

    public void handleButtonAction(ActionEvent event) {
        label.getText();
    }

}
