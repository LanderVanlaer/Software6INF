package me.landervanlaer.javaFx.oef11;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Build {

    public static Runnable runnable;
    public Label kind3,
            kind4,
            fullHouse,
            smallStraight,
            largeStraight,
            yahtzee,
            chance,
            scoreTotalBottom,
            scoreAces,
            scoreTwos,
            scoreThrees,
            scoreFours,
            scoreFives,
            scoreSixes,
            scoreTotalTop,
            total;
    public Button sixesButton,
            fivesButton,
            foursButton,
            threesButton,
            twosButton,
            acesButton,
            kind3Button,
            kind4Button,
            fullHouseButton,
            smallStraightButton,
            largeStraightButton,
            yahtzeeButton,
            chanceButton;
    public ImageView imageViewDobbelsteen1,
            imageViewDobbelsteen2,
            imageViewDobbelsteen3,
            imageViewDobbelsteen4,
            imageViewDobbelsteen5;
    public GridPane gridPaneTop;
    public TextField naam;
    public Label noPossibilities, nameError;
    private Doos doos;

    private YahtzeeOptie[] yahtzeeOpties;

    private TotalCounter[] totalCounters;

    private boolean gameOver = false;

    private int count = 0;

    //Full house: 25 punten voor 3 gelijke en één paar. (5 gelijke telt niet als Full House, tenzij het vak Yahtzee reeds ingevuld is).

    public void initialize() {
        doos = new Doos(
                imageViewDobbelsteen1,
                imageViewDobbelsteen2,
                imageViewDobbelsteen3,
                imageViewDobbelsteen4,
                imageViewDobbelsteen5);

        yahtzeeOpties = new YahtzeeOptie[]{
                new YahtzeeOptie(scoreAces, acesButton, () -> doos.getAantal(1) >= 1, () -> doos.getAantal(1)),
                new YahtzeeOptie(scoreTwos, twosButton, () -> doos.getAantal(2) >= 1, () -> doos.getAantal(2) * 2),
                new YahtzeeOptie(scoreThrees, threesButton, () -> doos.getAantal(3) >= 1, () -> doos.getAantal(3) * 3),
                new YahtzeeOptie(scoreFours, foursButton, () -> doos.getAantal(4) >= 1, () -> doos.getAantal(4) * 4),
                new YahtzeeOptie(scoreFives, fivesButton, () -> doos.getAantal(5) >= 1, () -> doos.getAantal(5) * 5),
                new YahtzeeOptie(scoreSixes, sixesButton, () -> doos.getAantal(6) >= 1, () -> doos.getAantal(6) * 6),

                new YahtzeeOptie(kind3, kind3Button, () -> doos.aantalDezelfde(3), () -> doos.totaal()),
                new YahtzeeOptie(kind4, kind4Button, () -> doos.aantalDezelfde(4), () -> doos.totaal()),

                new YahtzeeOptie(fullHouse, fullHouseButton, () -> doos.isFullHouse(yahtzeeOpties[11].getPunten() != 0), () -> 25),

                new YahtzeeOptie(smallStraight, smallStraightButton, () -> doos.aantalOpeenvolgendeOgen(4), () -> 30),
                new YahtzeeOptie(largeStraight, largeStraightButton, () -> doos.aantalOpeenvolgendeOgen(5), () -> 40),

                new YahtzeeOptie(yahtzee, yahtzeeButton, () -> doos.dobbelstenenEquals(), () -> 50),

                new YahtzeeOptie(chance, chanceButton, () -> true, () -> doos.totaal())
        };

        totalCounters = new TotalCounter[]{
                new TotalCounter(scoreTotalBottom, kind3, kind4, fullHouse, smallStraight, largeStraight, yahtzee, chance),
                new TotalCounter(scoreTotalTop, scoreAces, scoreTwos, scoreThrees, scoreFours, scoreFives, scoreSixes),
                new TotalCounter(total, scoreTotalBottom, scoreTotalTop)
        };

        runnable = this::volgendeRonde;
        volgendeRonde();
    }

    public void nieuweDobbelstenen() {
        if(isGameOver() || !doos.atLeastOneNonActive() || ++count > 3) return;

        noPossibilities.setVisible(false);

        doos.schudden();
        doos.showOnScreen();
        for(YahtzeeOptie o : yahtzeeOpties)
            o.checkIfPossible();

        if(!checkAllPossible()) {
            noPossibilities.setVisible(true);
            for(YahtzeeOptie o : yahtzeeOpties)
                o.makeNullPossible();
        }

    }

    public boolean checkAllPossible() {
        for(YahtzeeOptie o : yahtzeeOpties)
            if(o.isPossible())
                return true;
        return false;
    }

    public void volgendeRonde() {
        count = 0;
        for(TotalCounter c : totalCounters) c.update();
        if(isGameOver()) {
            gameOver();
            return;
        }
        doos.volgendeRonde();
        nieuweDobbelstenen();
    }

    private boolean isGameOver() {
        if(gameOver) return true;
        for(YahtzeeOptie optie : yahtzeeOpties)
            if(!optie.alreadyFilledIn()) return false;
        return true;
    }

    private void gameOver() {
        gameOver = true;
        naam.setVisible(true);
        naam.setOnAction(this::writeFileForPlayer);

        for(YahtzeeOptie optie : yahtzeeOpties)
            optie.checkIfPossible();
    }

    private void writeFileForPlayer(ActionEvent event) {
        nameError.setVisible(false);
        String naam = this.naam.getText().trim();
        if(!isNamePossible(naam)) {
            nameError.setVisible(true);
            return;
        }
        try {
            File file = new File("src/resources/yahtzee/punten_" + naam + ".txt");
            FileWriter writer = new FileWriter(file, false);
            writer
                    .append(naam)
                    .append("\n")
                    .append(total.getText());
            writer.close();
            Platform.exit();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isNamePossible(String name) {
        if(name.isBlank()) return false;
        final char[] chars = name.toCharArray();
        for(char c : chars)
            if(!Character.isAlphabetic(c)) return false;
        return true;
    }
}
