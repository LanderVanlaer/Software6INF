package me.landervanlaer.school.informatica6.subEnSuper.oef11;

import java.util.Date;

public abstract class Dier {
    private String naam;
    private Date geboorteDatum;
    private int gewicht;
    private boolean ziek;

    public Dier(String naam, Date geboorteDatum, int gewicht) {
        this(naam, geboorteDatum, gewicht, false);
    }

    public Dier(String naam, Date geboorteDatum, int gewicht, boolean ziek) {
        this.naam = naam;
        this.geboorteDatum = geboorteDatum;
        this.gewicht = gewicht;
        this.ziek = ziek;
    }

    public abstract void eetEenPortie();

    public abstract int getPortie();

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Date getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(Date geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    public boolean isZiek() {
        return ziek;
    }

    public void setZiek(boolean ziek) {
        this.ziek = ziek;
    }
}
