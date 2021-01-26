package me.landervanlaer.school.informatica6.subEnSuper.oef11;

import java.util.Date;

public class Schaap extends Zoogdier {
    private int lengteVacht;

    public Schaap(String naam, Date geboorteDatum, int gewicht, int aantalTanden, int lengteVacht) {
        super(naam, geboorteDatum, gewicht, aantalTanden);
        this.lengteVacht = lengteVacht;
    }

    public int getLengteVacht() {
        return lengteVacht;
    }

    public void setLengteVacht(int lengteVacht) {
        this.lengteVacht = lengteVacht;
    }

    @Override
    public int getPortie() {
        return (int) (getGewicht() * .015);
    }
}
