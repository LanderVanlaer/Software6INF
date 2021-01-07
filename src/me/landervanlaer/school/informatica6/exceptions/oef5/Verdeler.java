package me.landervanlaer.school.informatica6.exceptions.oef5;

import java.util.ArrayList;
import java.util.List;

public class Verdeler {
    private final Stad stad;
    private final List<Zender> zenders = new ArrayList<>();

    public Verdeler(Stad stad) {
        this.stad = stad;
    }

    public void letKlantHuurZender(int zenderNummer, Klant klant) throws NullPointerException, IllegalArgumentException {
        if(klant == null)
            throw new NullPointerException("Klant cannot be null");

        if(klant.getWooplaats() != getStad())
            throw new IllegalArgumentException(String.format("Klant met woonplaats %s kan niet van Verdeler met stad %s een Zender huren", klant.getWooplaats(), getStad()));

        klant.huurZender(getZenderByNummer(zenderNummer));
    }

    public Zender getZenderByNummer(int nummer) throws IllegalArgumentException {
        for(Zender zender : getZenders()) {
            if(zender.getNummer() == nummer)
                return zender;
        }
        throw new IllegalArgumentException(String.format("Verdeler bezit geen Zender met nummer %d", nummer));
    }

    public void letKlantStopHuur(int zenderNummer, Klant klant) throws NullPointerException {
        if(klant == null)
            throw new NullPointerException("Klant cannot be null");

        klant.stopHuur(getZenderByNummer(zenderNummer));
    }

    public Stad getStad() {
        return stad;
    }

    public List<Zender> getZenders() {
        return zenders;
    }
}
