package me.landervanlaer.javaFx.oef10;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    public TextField naam;
    public TextField leeftijd;
    public Label errorNaam;
    public Label errorLeeftijd;

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
            win.setText("U hebt gefaald!");
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

    public void naamEnLeeftijdValideren(ActionEvent actionEvent) {
        String naamString = naam.getText();
        if(!naamString.substring(0, 1).equals(naamString.substring(0, 1).toUpperCase())) {
            errorNaam.setText("Naam moet met hoofdletter beginnen");
        }

        errorLeeftijd.setText(null);
        int leeftijdInt;
        try {
            leeftijdInt = Integer.parseInt(leeftijd.getText());
        } catch(NumberFormatException ignored) {
            errorLeeftijd.setText("Gelieve een nummer in te geven");
            return;
        }
        if(leeftijdInt < 18) {
            errorLeeftijd.setText("U bent te jong, 18+");
        }

    }
}
