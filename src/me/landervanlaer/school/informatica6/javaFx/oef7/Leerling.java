package me.landervanlaer.school.informatica6.javaFx.oef7;

public class Leerling {
    private String naam;
    private double gemiddelde;

    public Leerling(String naam, double gemiddelde) {
        this.naam = naam;
        this.gemiddelde = gemiddelde;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public double getGemiddelde() {
        return gemiddelde;
    }

    public void setGemiddelde(double gemiddelde) {
        this.gemiddelde = gemiddelde;
    }
}
