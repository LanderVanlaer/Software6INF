package me.landervanlaer.school.informatica6.javaFx.oef6;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Controller {
    public Label label;
    public Button button;

    private Timeline timeline;
    private int counter = 120;

    public void initialize() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1.0), this::puls));
        timeline.setCycleCount(counter);
        label.setText(String.valueOf(counter));
    }

    public void startCounter(ActionEvent e) {
        timeline.playFromStart();
        label.getStyleClass().remove("alarm");
    }

    private void puls(ActionEvent actionEvent) {
        label.setText(String.valueOf(--counter));
        if(counter <= 0) {
            timeline.stop();

        } else if(counter <= 10)
            label.getStyleClass().add("alarm");

    }
}

















