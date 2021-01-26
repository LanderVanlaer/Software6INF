package me.landervanlaer.school.informatica6.subEnSuper.oef11;

import java.util.Date;

public class Vogel extends Dier {
    private int spanwijdte;
    private int actieradius;

    public Vogel(String naam, Date geboorteDatum, int gewicht, int spanwijdte, int actieradius) {
        super(naam, geboorteDatum, gewicht);
        this.spanwijdte = spanwijdte;
        this.actieradius = actieradius;
    }

    @Override
    public void eetEenPortie() {
        setGewicht((int) (getGewicht() + getPortie() * .03));
    }

    @Override
    public int getPortie() {
        return (int) (getGewicht() * .015);
    }

    public int getSpanwijdte() {
        return spanwijdte;
    }

    public void setSpanwijdte(int spanwijdte) {
        this.spanwijdte = spanwijdte;
    }

    public int getActieradius() {
        return actieradius;
    }

    public void setActieradius(int actieradius) {
        this.actieradius = actieradius;
    }
}
