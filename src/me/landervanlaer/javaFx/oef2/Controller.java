package me.landervanlaer.javaFx.oef2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    public Label label;
    public TextField firstName;
    public TextField lastName;
    public Label warning;

    public void handleButtonAction(ActionEvent event) {
        warning.setText("");
        label.setText("");

        if(firstName.getText().isEmpty())
            warning.setText("Gelieve een voornaam in te geven");
        else if(lastName.getText().isEmpty())
            warning.setText("Gelieve een achternaam in te geven");
        else
            label.setText(firstName.getText().toLowerCase().charAt(0) +
                    lastName.getText().toLowerCase().replaceAll(" ", "")
                            .substring(0, Math.min(lastName.getText().length(), 6)));
    }
}
