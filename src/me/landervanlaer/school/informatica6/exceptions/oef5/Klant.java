package me.landervanlaer.school.informatica6.exceptions.oef5;

import java.util.ArrayList;

public class Klant {
    private final String naam;
    private final Stad wooplaats;
    private final boolean kinderen;
    private final ArrayList<Zender> zenders = new ArrayList<>();

    public Klant(String naam, Stad wooplaats, boolean hasKinderen) {
        this.naam = naam;
        this.wooplaats = wooplaats;
        this.kinderen = hasKinderen;
    }

    protected void stopHuur(Zender zender) throws NullPointerException {
        if(zender == null)
            throw new NullPointerException("Zender cannot be null");

        if(!getZenders().remove(zender))
            throw new IllegalArgumentException("De Klant heeft geen abonnement op de gegeven Zender");
    }

    protected void huurZender(Zender zender) throws IllegalArgumentException, NullPointerException {
        if(zender == null)
            throw new NullPointerException("Zender cannot be null");

        if(!zender.isSafeForKids() && hasKinderen())
            throw new IllegalArgumentException("De Klant kan de gegeven zender niet huren.\n" +
                    "Zender is niet voor kinderen bedoelt en Klant heeft kinderen");

        getZenders().add(zender);
    }

    public ArrayList<Zender> getZenders() {
        return zenders;
    }

    public boolean hasKinderen() {
        return kinderen;
    }

    public String getNaam() {
        return naam;
    }

    public Stad getWooplaats() {
        return wooplaats;
    }
}
