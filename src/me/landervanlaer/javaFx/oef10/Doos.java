package me.landervanlaer.javaFx.oef10;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Doos {
    private Dobbelsteen[] dobbelstenen;

    public Doos(int aantalDobbelstenen) {
        this.initializeDobbelstenen(aantalDobbelstenen);
    }

    public int getAantalZessen() {
        int aantalZessen = 0;
        for(int i = 0; i < this.getAantalDobbelstenen(); i++)
            if(this.getDobbelsteen(i).getBovenLiggendNummer() == 6) ++aantalZessen;
        return aantalZessen;
    }

    public void initializeDobbelstenen(int aantalDobbelstenen) {
        this.dobbelstenen = new Dobbelsteen[aantalDobbelstenen];
        for(int i = 0; i < aantalDobbelstenen; i++) this.setDobbelsteen(i, new Dobbelsteen());
    }

    public boolean dobbelstenenEquals() {
        final int n = this.getDobbelsteen(0).getBovenLiggendNummer();
        for(Dobbelsteen d : this.getDobbelstenen()) {
            if(d.getBovenLiggendNummer() != n) return false;
        }
        return true;
    }

    private void setDobbelsteen(int i, Dobbelsteen db) {
        this.dobbelstenen[i] = db;
    }

    public void schudden() {
        for(int i = 0; i < this.getAantalDobbelstenen(); i++)
            this.schudDobbelsteen(i);
    }

    public void schudDobbelsteen(int i) {
        this.getDobbelsteen(i).gooi();
    }

    public void toonDobbelstenen() {
        for(int i = 0; i < this.getAantalDobbelstenen(); i++)
            System.out.println(i + " :\t" + this.getDobbelsteen(i).getBovenLiggendNummer());
    }

    public Dobbelsteen getDobbelsteen(int i) {
        return this.getDobbelstenen()[i];
    }

    public int getAantalDobbelstenen() {
        return this.getDobbelstenen().length;
    }

    public Dobbelsteen[] getDobbelstenen() {
        return this.dobbelstenen;
    }
}