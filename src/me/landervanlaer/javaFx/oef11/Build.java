package me.landervanlaer.javaFx.oef11;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import me.landervanlaer.javaFx.oef10.Doos;

public class Build {
    private final Doos doos = new Doos(5);
    public TextField naam;
    public Label kind3;
    public Label kind4;
    public Label fullHouse;
    public Label smallStraight;
    public Label largeStraight;
    public Label yahtzee;
    public Label chance;
    public Label scoreTotalBottom;
    public Label scoreAces;
    public Label scoreTwos;
    public Label scoreThrees;
    public Label scoreFours;
    public Label scoreFives;
    public Label scoreSixes;
    public Label scoreTotalTop;
    public Button sixesButton;
    public Button fivesButton;
    public Button foursButton;
    public Button threesButton;
    public Button twosButton;
    public Button acesButton;
    public GridPane gridPaneTop;
    public Button kind3Button;
    public Button kind4Button;
    public Button fullHouseButton;
    public Button smallStraightButton;
    public Button largeStraightButton;
    public Button yahtzeeButton;
    public Button chanceButton;
    public Label total;
    public ImageView imageViewDobbelsteen1;
    public ImageView imageViewDobbelsteen2;
    public ImageView imageViewDobbelsteen3;
    public ImageView imageViewDobbelsteen4;
    public ImageView imageViewDobbelsteen5;

    //Full house: 25 punten voor 3 gelijke en één paar. (5 gelijke telt niet als Full House, tenzij het vak Yahtzee reeds ingevuld is).

    public void initialize() {
    }
}
