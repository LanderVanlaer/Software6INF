package me.landervanlaer.school.informatica6.javaFx.eindproject6INF;

public class Held {
    private final static double STRENGTH_AVARAGE = 10.0;
    private String name;
    private int hitpoints;
    private double strength = STRENGTH_AVARAGE;
    private int capacity;
    private int protection;
    private int anchors = 3;

    public static double getStrengthAvarage() {
        return STRENGTH_AVARAGE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.matches("[A-Z][a-zA-Z ]+'?[a-zA-Z ]*'?[a-zA-Z ]*"))
            this.name = name;
        else
            throw new IllegalArgumentException("Naam moet beginnen met een hoofdletter en mag alleen hoofdletters, kleine letters, spaties en ' bevatten");
    }

    public int getHitpoints() {
        return hitpoints;
    }

    //TODO: 1/12/2020 Als de held stopt met vechten... afronden naar beneden naar primary number
    //TODO: 1/12/2020 Niet meer dan maximale raakpunten
    public void setHitpoints(int hitpoints) {
        if(hitpoints <= 0)
            this.hitpoints = hitpoints;
        this.hitpoints = hitpoints;
    }

    public double getStrength() {
        return strength;
    }

    // TODO: 1/12/2020 De kracht van een held kan gedurende het spel wijzingen, maar dit kan enkel door vermenigvuldigingen of delingen met gehele getallen
    public void setStrength(double strength) {
        this.strength = strength;
    }

    public int getCapacity() {
        return capacity;
    }

    /**
     * De kracht van een held bepaald ook de draagcapaciteit van een held. Dit gebeurt als volgt:
     * -	Helden zonder kracht kunnen niets met zich meedragen
     * -	Voor helden met een kracht tussen 1.00 en 10.00 is de draagcapaciteit gelijk aan de kracht van de held, vermenigvuldigd met 10 kg.
     * -	Voor helden met een kracht tussen 11.00 en 20.00 gelden de volgende waarden voor draagcapaciteit: {115kg, 130kg, 150kg, 175kg, 200kg, 230kg, 260kg, 300kg, 350kg, 400kg}
     * -	Voor helden met een kracht vanaf 21 is de maximale draagcapaciteit gelijk aan 4 keer de maximale draagcapaciteit van een kracht die 10 eenheden lager ligt.
     *
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public int getAnchors() {
        return anchors;
    }

    public void setAnchors(int anchors) {
        this.anchors = anchors;
    }
}
