package me.landervanlaer.javaFx.oef8;

import javafx.scene.control.TableView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Leerling {
    private final String naam;
    private File bestand;

    public Leerling(String naam) {
        this.naam = naam;
        this.bestand = new File("src/resources/puntenOef8/punten_" + this.getNaam() + ".txt");
    }

    public void addToTable(TableView<Punten> table) {
        try {
            Scanner scan = new Scanner(this.getBestand());
            scan.nextLine();
            while(scan.hasNextLine()) {
                final String line = scan.nextLine();
                final String vakNaam = line.split(": ")[0];
                final double vakPunt = Double.parseDouble(line.split(": ")[1]);

                table.getItems().add(new Punten(vakNaam, vakPunt));
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private boolean canUseBestand() {
        return this.getBestand().isFile() && this.getBestand().exists() && this.getBestand().canRead();
    }


    public String getNaam() {
        return naam;
    }

    public File getBestand() {
        return bestand;
    }

    public void setBestand(File bestand) {
        this.bestand = bestand;
    }
}