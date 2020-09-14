package me.landervanlaer.javaFx.oef3;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    public ChoiceBox choiseBox;
    public Label label;

    static final int min = 48;
    static final int max = 90;

    public void handleButtonAction(ActionEvent event) {
        if(!(choiseBox.getValue() instanceof Integer)) throw new Error("Value is not an instance of Integer");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < (Integer) choiseBox.getValue(); i++)
            stringBuilder.append((char) (Math.random() * (max - min) + min));
        label.setText(stringBuilder.toString());
    }

}
