package me.landervanlaer.javaFx.oef8;

public class Punten {
    private String vak;
    private double punt;

    public Punten(String vak, double punt) {
        this.vak = vak;
        this.punt = punt;
    }

    public String getVak() {
        return vak;
    }

    public void setVak(String vak) {
        this.vak = vak;
    }

    public double getPunt() {
        return punt;
    }

    public void setPunt(double punt) {
        this.punt = punt;
    }
}
