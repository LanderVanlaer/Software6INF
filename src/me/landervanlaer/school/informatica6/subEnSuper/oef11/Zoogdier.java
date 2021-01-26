package me.landervanlaer.school.informatica6.subEnSuper.oef11;

import java.util.Date;

public abstract class Zoogdier extends Dier {
    private int aantalTanden;

    public Zoogdier(String naam, Date geboorteDatum, int gewicht, int aantalTanden) {
        super(naam, geboorteDatum, gewicht);
        this.aantalTanden = aantalTanden;
    }

    public Zoogdier(String naam, Date geboorteDatum, int gewicht, int aantalTanden, boolean ziek) {
        super(naam, geboorteDatum, gewicht, ziek);
        this.aantalTanden = aantalTanden;
    }

    @Override
    public void eetEenPortie() {
        setGewicht((int) (getGewicht() + getPortie() * .05));
        if(isZiek())
            setAantalTanden(getAantalTanden() - 1);
    }

    public int getAantalTanden() {
        return aantalTanden;
    }

    public void setAantalTanden(int aantalTanden) {
        this.aantalTanden = aantalTanden;
    }
}
