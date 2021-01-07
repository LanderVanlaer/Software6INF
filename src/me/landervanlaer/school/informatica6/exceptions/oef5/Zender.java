package me.landervanlaer.school.informatica6.exceptions.oef5;

public class Zender {
    private final String naam;
    private final int nummer;
    private final boolean betalend;
    private final boolean safeForKids;

    public Zender(String naam, int nummer, boolean betalend, boolean safeForKids) {
        this.naam = naam;
        this.nummer = nummer;
        this.betalend = betalend;
        this.safeForKids = safeForKids;
    }

    public String getNaam() {
        return naam;
    }

    public int getNummer() {
        return nummer;
    }

    public boolean isSafeForKids() {
        return safeForKids;
    }

    public boolean isBetalend() {
        return betalend;
    }
}
