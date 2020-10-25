package me.landervanlaer.javaFx.oef11;

import javafx.scene.layout.GridPane;

import java.awt.*;

public class PuntRow {
    private final Label label;
    private final Label punten;
    private Button button;

    public PuntRow(Label label, Label punten, GridPane gridPane) {
        this.label = label;
        this.punten = punten;
        this.button = new Button();
        getButton().setLabel("✔");
        getButton().setVisible(false);
    }

    public Label getLabel() {
        return label;
    }

    public Label getPunten() {
        return punten;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
