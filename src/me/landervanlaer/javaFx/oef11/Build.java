package me.landervanlaer.javaFx.oef11;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

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
    public Label noPossibilities;
    private Doos doos;

    private YahtzeeOptie[] yahtzeeOpties;

    private TotalCounter[] totalCounters;

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
        if(++count > 3)
            return;

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
        nieuweDobbelstenen();
    }
}
