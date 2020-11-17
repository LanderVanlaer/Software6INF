package me.landervanlaer.javaFx.eindproject6INF;

public class Held {
    private final static double STRENGTH_AVARAGE = 10.0;
    private String name;
    private int hitpoints;
    private double strength = STRENGTH_AVARAGE;
    private int capicity;
    private int protection;
    private int anchors = 3;

    public static double getStrengthAvarage() {
        return STRENGTH_AVARAGE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public int getCapicity() {
        return capicity;
    }

    public void setCapicity(int capicity) {
        this.capicity = capicity;
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
