package me.landervanlaer.school.informatica6.subEnSuper.oef11;

import java.util.Date;

public class Rund extends Zoogdier {
    private int aantalHorens;

    public Rund(String naam, Date geboorteDatum, int gewicht, int aantalTanden, int aantalHorens) {
        super(naam, geboorteDatum, gewicht, aantalTanden);
        this.aantalHorens = aantalHorens;
    }

    public int getAantalHorens() {
        return aantalHorens;
    }

    public void setAantalHorens(int aantalHorens) {
        this.aantalHorens = aantalHorens;
    }

    @Override
    public int getPortie() {
        return (int) (getGewicht() * .015);
    }
}
