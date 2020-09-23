package me.landervanlaer.javaFx.oef7;

import java.util.ArrayList;

public class Klas {
    private final ArrayList<Leerling> leerlingen = new ArrayList<>();

    public Klas(Leerling... leerlingen) {
        if(leerlingen == null || leerlingen.length == 0) return;
        for(Leerling leerling : leerlingen) {
            if(!(leerling == null))
                this.getLeerlingen().add(leerling);
        }
    }

    public ArrayList<Leerling> getLeerlingen() {
        return this.leerlingen;
    }
}
