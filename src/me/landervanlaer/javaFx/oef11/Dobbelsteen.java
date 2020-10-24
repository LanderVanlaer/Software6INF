package me.landervanlaer.javaFx.oef11;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Dobbelsteen {
    public static final int MAX = 6;
    protected static final Image[] images = new Image[]{
            new Image("file:src/resources/dobbelsteen/1.gif"),
            new Image("file:src/resources/dobbelsteen/2.gif"),
            new Image("file:src/resources/dobbelsteen/3.gif"),
            new Image("file:src/resources/dobbelsteen/4.gif"),
            new Image("file:src/resources/dobbelsteen/5.gif"),
            new Image("file:src/resources/dobbelsteen/6.gif")
    };
    private final ImageView imageView;
    private int bovenLiggendNummer;
    private boolean active = false;

    public Dobbelsteen(ImageView imageView) {
        this.bovenLiggendNummer = this.randomGetal();
        this.imageView = imageView;
        this.imageView.setOnMouseClicked(this::clickActionHold);
    }

    private void clickActionHold(MouseEvent mouseEvent) {
        toggleActive();
    }

    public Image getImage() {
        return Dobbelsteen.images[getBovenLiggendNummer() - 1];
    }

    public int draaiOm() {
        this.setBovenLiggendNummer(7 - this.getBovenLiggendNummer());
        return this.getBovenLiggendNummer();
    }

    public int gooi() {
        if(!isActive())
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

    public void showOnScreen() {
        this.imageView.setImage(getImage());
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
        if(active)
            imageView.getStyleClass().add("active");
        else
            imageView.getStyleClass().remove("active");
    }

    public void volgendeRonde() {
        setActive(false);
    }

    public void toggleActive() {
        setActive(!isActive());
    }
}