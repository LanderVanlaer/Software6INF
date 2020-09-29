package me.landervanlaer.javaFx.oef8;

import javafx.scene.control.TableView;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Leerling {
    private final String naam;
    private File bestand;
    private final ArrayList<Punten> list = new ArrayList<>();

    public Leerling(String naam) throws IOException {
        this.naam = naam;
        this.bestand = new File("src/resources/puntenOef8/punten_" + this.getNaam() + ".txt");
        getBestand().createNewFile();
    }

    public void initializePunten(TableView<Punten> table) throws FileNotFoundException {
        Scanner scan = new Scanner(this.getBestand());
        if(!scan.hasNextLine()) return;
        scan.nextLine();
        while(scan.hasNextLine()) {
            final String line = scan.nextLine();
            list.add(new Punten(
                            line.split(": ")[0],
                            Double.parseDouble(line.split(": ")[1])
                    )
            );
        }
        updateTable(table);
    }

    public void updateTable(TableView<Punten> table) {
        table.getItems().clear();
        list.forEach(punten -> table.getItems().add(punten));
        write();
    }

    public void addVak(Punten punt) {
        if(punt == null) return;
        for(Punten p : list)
            if(punt.getVak().toLowerCase().equals(p.getVak().toLowerCase())) {
                p.setPunt(punt.getPunt());
                return;
            }
        list.add(punt);
    }

    public void write() {
        try {
            FileWriter writer = new FileWriter(this.getBestand(), false);
            writer.append(this.getNaam()).append("\n");
            list.forEach(punten -> {
                try {
                    writer.write(punten.getVak() + ": " + punten.getPunt() + "\n");
                } catch(IOException e) {
                    e.printStackTrace();
                }
            });
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

//    private boolean canUseBestand() {
//        return this.getBestand().isFile() && this.getBestand().exists() && this.getBestand().canRead();
//    }


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