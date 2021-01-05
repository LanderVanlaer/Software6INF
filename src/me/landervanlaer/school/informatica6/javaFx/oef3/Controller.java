package me.landervanlaer.school.informatica6.javaFx.oef3;

import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class Controller {

    public ChoiceBox<Integer> choiseBox;
    public Label label;

    static final int min = 48;
    static final int max = 90;

    public void handleButtonAction(ActionEvent event) {
        if(choiseBox.getValue() == null) throw new Error("Value is not an instance of Integer");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < (Integer) choiseBox.getValue(); i++)
            stringBuilder.append((char) (Math.random() * (max - min) + min));
        label.setText(stringBuilder.toString());
    }

}
