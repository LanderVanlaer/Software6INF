package me.landervanlaer.javaFx.oef10;

import javafx.scene.image.Image;

public class Dobbelsteen {
    protected static final Image[] images = new Image[]{
            new Image("file:src/resources/dobbelsteen/1.gif"),
            new Image("file:src/resources/dobbelsteen/2.gif"),
            new Image("file:src/resources/dobbelsteen/3.gif"),
            new Image("file:src/resources/dobbelsteen/4.gif"),
            new Image("file:src/resources/dobbelsteen/5.gif"),
            new Image("file:src/resources/dobbelsteen/6.gif")
    };
    private int bovenLiggendNummer;

    public Dobbelsteen() {
        this.bovenLiggendNummer = this.randomGetal();
    }

    public Image getImage() {
        return Dobbelsteen.images[getBovenLiggendNummer() - 1];
    }

    public int draaiOm() {
        this.setBovenLiggendNummer(7 - this.getBovenLiggendNummer());
        return this.getBovenLiggendNummer();
    }

    public int gooi() {
        this.setBovenLiggendNummer(this.randomGetal());
        return this.getBovenLiggendNummer();
    }

    private int randomGetal() {
        return (int) ((Math.random() * 6) + 1);
    }

    public int getBovenLiggendNummer() {
        return this.bovenLiggendNummer;
    }

    public void setBovenLiggendNummer(int bovenLiggendNummer) {
        if(bovenLiggendNummer <= 6 && bovenLiggendNummer >= 1)
            this.bovenLiggendNummer = bovenLiggendNummer;
    }
}