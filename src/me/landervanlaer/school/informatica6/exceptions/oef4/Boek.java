package me.landervanlaer.school.informatica6.exceptions.oef4;

import java.text.MessageFormat;

public class Boek {
    private final String ISBN;
    private final String titel;
    private final String Autheur;
    private boolean uitgeleend = false;

    public Boek(String ISBN, String titel, String autheur) {
        this.ISBN = ISBN;
        this.titel = titel;
        Autheur = autheur;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitel() {
        return titel;
    }

    public String getAutheur() {
        return Autheur;
    }

    public boolean isUitgeleend() {
        return uitgeleend;
    }

    public void setUitgeleend(boolean uitgeleend) {
        this.uitgeleend = uitgeleend;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Boek'{'ISBN=''{0}'', titel=''{1}'', Autheur=''{2}'', uitgeleend={3}'}'", ISBN, titel, Autheur, uitgeleend);
    }

    public static class AlreadyUitgeleend extends RuntimeException {
        public AlreadyUitgeleend(Boek boek) {
            super("Het " + boek.toString() + " is al uitgeleend");
        }
    }
}
