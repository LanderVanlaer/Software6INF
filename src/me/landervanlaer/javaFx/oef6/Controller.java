package me.landervanlaer.javaFx.oef6;

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

    public void initialize() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1.0), this::puls));
        timeline.setCycleCount(10);
    }

    public void startCounter(ActionEvent e) {
        timeline.playFromStart();
    }

    private void puls(ActionEvent actionEvent) {

    }
}

















