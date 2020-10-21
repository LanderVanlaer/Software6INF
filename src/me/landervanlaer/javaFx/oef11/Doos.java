package me.landervanlaer.javaFx.oef11;


import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Doos {
    private Dobbelsteen[] dobbelstenen;

    public Doos(ImageView... imageViews) {
        this.initializeDobbelstenen(imageViews);
    }

    private static int[] removeDupplicates(int[] ints) {
        List<Integer> integers = new ArrayList<>();
        for(int i : ints)
            if(!integers.contains(i))
                integers.add(i);
        ints = new int[integers.size()];
        for(int i = 0; i < ints.length; i++)
            ints[i] = integers.get(i);
        return ints;
    }

    public boolean isFullHouse(boolean yahtzeeIngevuld) {
        if(yahtzeeIngevuld && dobbelstenenEquals())
            return true;
        boolean has3 = false;
        boolean has2 = false;
        for(int i : new int[]{
                getAantal(1),
                getAantal(2),
                getAantal(3),
                getAantal(4),
                getAantal(5),
                getAantal(6)}
        )
            if(i == 3)
                has3 = true;
            else if(i == 2)
                has2 = true;
        return has3 && has2;
    }

    public boolean aantalOpeenvolgendeOgen(int i) {
        if(i <= 1) return true;
        int[] ints = this.toArrayOfInt();
        Arrays.sort(ints);
        ints = removeDupplicates(ints);
        for(int j = 0; j <= ints.length - i; j++) {
            int prev = ints[j];
            int k;
            for(k = 1; k < i; k++)
                if(++prev != ints[k + j])
                    break;
            if(k == i) return true;
        }
        return false;
    }

    public int getAantal(int n) {
        int aantal = 0;
        for(Dobbelsteen dobbelsteen : getDobbelstenen())
            if(dobbelsteen.getBovenLiggendNummer() == n) ++aantal;
        return aantal;
    }

    public boolean aantalDezelfde(int i) {
        for(int j = 1; j <= Dobbelsteen.MAX; j++)
            if(getAantal(j) >= i) return true;
        return false;
    }

    public int totaal() {
        int totaal = 0;
        for(Dobbelsteen dobbelsteen : getDobbelstenen())
            totaal += dobbelsteen.getBovenLiggendNummer();
        return totaal;
    }

    public int[] toArrayOfInt() {
        int[] ints = new int[getAantalDobbelstenen()];
        for(int i = 0; i < ints.length; i++) ints[i] = getDobbelsteen(i).getBovenLiggendNummer();
        return ints;
    }

    public boolean has(int nummer) {
        for(Dobbelsteen d : dobbelstenen)
            if(d.getBovenLiggendNummer() == nummer) return true;
        return false;
    }

    public void initializeDobbelstenen(ImageView[] imageViews) {
        this.dobbelstenen = new Dobbelsteen[imageViews.length];
        for(int i = 0; i < imageViews.length; i++) {
            this.setDobbelsteen(i, new Dobbelsteen(imageViews[i]));
        }
    }

    public void showOnScreen() {
        for(Dobbelsteen dobbelsteen : getDobbelstenen())
            dobbelsteen.showOnScreen();
    }

    public boolean dobbelstenenEquals() {
        return aantalDezelfde(getDobbelstenen().length);
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