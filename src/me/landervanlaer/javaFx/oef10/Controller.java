package me.landervanlaer.javaFx.oef10;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Controller {
    public ImageView dobbelsteen1;
    public ImageView dobbelsteen2;
    public ImageView dobbelsteen3;
    public Button start;
    public Button stop;
    public Label counter;
    public Label win;

    protected Doos doos = new Doos(3);
    private Timeline timeline;
    private int count = 60;

    public void initialize() {
        update();
    }

    public void update() {
        dobbelsteen1.setImage(doos.getDobbelsteen(0).getImage());
        dobbelsteen2.setImage(doos.getDobbelsteen(1).getImage());
        dobbelsteen3.setImage(doos.getDobbelsteen(2).getImage());
    }

    public void schudden(ActionEvent actionEvent) {
        doos.schudden();
        update();
    }

    public void start(ActionEvent actionEvent) {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1.0), this::pulse));
        timeline.setCycleCount(count);
        timeline.playFromStart();
        start.setVisible(false);
        stop.setVisible(true);
    }

    private void pulse(ActionEvent actionEvent) {
        counter.setText(String.valueOf(--count));
        if(count == 0) {
            stop.setVisible(false);
            timeline.stop();
            counter.setVisible(false);
        }
        update();
    }

    public void stop(ActionEvent actionEvent) {
        if(!doos.dobbelstenenEquals()) return;
        timeline.stop();
        stop.setVisible(false);
        counter.setVisible(false);

        win.setText("Proficiat, u hebt 3 keer " + doos.getDobbelsteen(0).getBovenLiggendNummer() + " gegooid en u heeft nog " + count + " seconden over");
    }
}
