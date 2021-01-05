package me.landervanlaer.school.informatica6.javaFx.oef11;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;

public class YahtzeeOptie {
    private final Label label;
    private final BooleanSupplier booleanSupplier;
    private final IntSupplier intSupplier;
    private final Button button;
    private int punten = -1;
    private boolean nullPossible = false;

    public YahtzeeOptie(Label label, Button button, BooleanSupplier booleanSupplier, IntSupplier intSupplier) {
        this.label = label;
        this.booleanSupplier = booleanSupplier;
        this.intSupplier = intSupplier;
        this.button = button;
        this.button.setVisible(false);
        this.button.setOnAction(this::buttonClick);
    }

    public void buttonClick(ActionEvent event) {
        setPunten(nullPossible ? 0 : intSupplier.getAsInt());
    }

    public void makeNullPossible() {
        if(alreadyFilledIn()) return;
        nullPossible = true;
        button.setVisible(true);
    }

    public boolean alreadyFilledIn() {
        return (punten != -1);
    }

    public boolean isPossible() {
        return !alreadyFilledIn() && booleanSupplier.getAsBoolean();
    }

    public void checkIfPossible() {
        nullPossible = false;
        button.setVisible(isPossible());
    }

    public int getPunten() {
        return punten;
    }

    private void setPunten(int punten) {
        this.punten = punten;
        label.setText(String.valueOf(getPunten()));
        Build.runnable.run();
    }
}