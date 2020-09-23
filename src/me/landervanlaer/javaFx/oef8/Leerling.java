package me.landervanlaer.javaFx.oef8;

import java.io.File;

public class Leerling extends me.landervanlaer.javaFx.oef7.Leerling {
    private File bestand;

    public Leerling(String naam, double gemiddelde) {
        super(naam, gemiddelde);
        this.setBestand(new File("src/resources/puntenOef8/" + this.getNaam() + ".txt"));
    }

    public File getBestand() {
        return bestand;
    }

    public void setBestand(File bestand) {
        this.bestand = bestand;
    }
}
