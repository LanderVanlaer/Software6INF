package me.landervanlaer.school.informatica6.exceptions.oef4;

import java.util.ArrayList;

public class Bibliotheek {
    private ArrayList<Persoon> personen = new ArrayList<>();
    private ArrayList<Boek> boeken = new ArrayList<>();

    public Bibliotheek() {
    }

    public ArrayList<Persoon> getPersonen() {
        return personen;
    }

    public void setPersonen(ArrayList<Persoon> personen) {
        this.personen = personen;
    }

    public ArrayList<Boek> getBoeken() {
        return boeken;
    }

    public void setBoeken(ArrayList<Boek> boeken) {
        this.boeken = boeken;
    }
}
