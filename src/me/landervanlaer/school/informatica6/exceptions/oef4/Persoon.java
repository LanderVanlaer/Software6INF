package me.landervanlaer.school.informatica6.exceptions.oef4;

import java.text.MessageFormat;
import java.util.ArrayList;

public class Persoon {
    public static final int MAX_AANTAL_BOEKEN = 5;
    private final String naam;
    private final Geslacht geslacht;
    private boolean lidgeldBetaald;
    private int leeftijd;
    private ArrayList<Boek> boeken = new ArrayList<>();

    public Persoon(String naam, Geslacht geslacht, int leeftijd) {
        this(naam, geslacht, false, leeftijd);
    }

    public Persoon(String naam, Geslacht geslacht, boolean lidgeldBetaald, int leeftijd) {
        this.naam = naam;
        this.geslacht = geslacht;
        this.lidgeldBetaald = lidgeldBetaald;
        this.leeftijd = leeftijd;
    }

    public static boolean isValidAantalBoeken(int aantal) {
        return aantal >= 0 && aantal <= MAX_AANTAL_BOEKEN;
    }

    public static boolean isValidUitleenbaarBoek(Boek boek) {
        return !boek.isUitgeleend();
    }

    public void leenBoek(Boek boek) throws NullPointerException, LidgeldNietBetaaldException, TeVeelBoekenException, Boek.AlreadyUitgeleend {
        if(boek == null)
            throw new NullPointerException("Boek can not be null");
        if(!isLidgeldBetaald())
            throw new LidgeldNietBetaaldException();
        if(!isValidAantalBoeken(1 + getBoeken().size()))
            throw new TeVeelBoekenException();
        if(!isValidUitleenbaarBoek(boek))
            throw new Boek.AlreadyUitgeleend(boek);

        boek.setUitgeleend(true);
        getBoeken().add(boek);
    }

    public void leverInBoek(Boek boek) throws NullPointerException, IllegalAccessException {
        if(boek == null)
            throw new NullPointerException("Boek can not be null");

        final int i = getBoeken().indexOf(boek);
        if(i == -1)
            throw new IllegalAccessException(MessageFormat.format("Persoon'{'{0}'}' heeft het Boek'{'{1}'}' niet", getNaam(), boek.getISBN()));

        leverInBoek(getBoeken().indexOf(boek));
    }

    public Boek leverInBoek(int i) {
        final Boek boek = getBoeken().remove(i);
        boek.setUitgeleend(false);
        return boek;
    }

    public String getNaam() {
        return naam;
    }

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public boolean isLidgeldBetaald() {
        return lidgeldBetaald;
    }

    public void setLidgeldBetaald(boolean lidgeldBetaald) {
        this.lidgeldBetaald = lidgeldBetaald;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    public ArrayList<Boek> getBoeken() {
        return boeken;
    }

    public void setBoeken(ArrayList<Boek> boeken) {
        this.boeken = boeken;
    }

    public static class LidgeldNietBetaaldException extends RuntimeException {
        private LidgeldNietBetaaldException() {
            super("Lidgeld nog niet betaald");
        }
    }

    public static class TeVeelBoekenException extends RuntimeException {
        private TeVeelBoekenException() {
            super("U wilt te veel Boeken lenen, een Persoon mag max " + Persoon.MAX_AANTAL_BOEKEN + " Boeken");
        }
    }
}
