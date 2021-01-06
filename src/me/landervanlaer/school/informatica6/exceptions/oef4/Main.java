package me.landervanlaer.school.informatica6.exceptions.oef4;

public class Main {
    public static void main(String[] args) {
        Bibliotheek bibliotheek = new Bibliotheek();
        bibliotheek.getBoeken().add(new Boek("bdf66a17-352e-4788-a45d-53f3e560ae64", "De nachtegaal", "Franske Oei"));
        bibliotheek.getBoeken().add(new Boek("b408e87c-5b4b-44ca-ae03-743679c847b2", "prevent", "Joske Jansens"));
        bibliotheek.getBoeken().add(new Boek("45e1b21e-c39f-4454-bea3-a2c16961f72d", "onto", "Robin Goot"));

        bibliotheek.getPersonen().add(new Persoon("Frans", Geslacht.Man, true, 20));
        bibliotheek.getPersonen().add(new Persoon("Celine", Geslacht.Vrouw, true, 50));
        bibliotheek.getPersonen().add(new Persoon("Karelke", Geslacht.Man, false, 12));

        bibliotheek.getPersonen().get(0).leenBoek(bibliotheek.getBoeken().get(1));
        bibliotheek.getPersonen().get(1).leenBoek(bibliotheek.getBoeken().get(2));
        bibliotheek.getPersonen().get(1).leenBoek(bibliotheek.getBoeken().get(0));
        try {
            bibliotheek.getPersonen().get(2).leenBoek(bibliotheek.getBoeken().get(1));
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            bibliotheek.getPersonen().get(0).leenBoek(null);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            bibliotheek.getPersonen().get(0).leverInBoek(bibliotheek.getBoeken().get(1));
        } catch(IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        try {
            bibliotheek.getPersonen().get(1).leverInBoek(bibliotheek.getBoeken().get(2));
        } catch(IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        try {
            bibliotheek.getPersonen().get(1).leverInBoek(bibliotheek.getBoeken().get(1));
        } catch(IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        try {
            bibliotheek.getPersonen().get(2).leverInBoek(bibliotheek.getBoeken().get(0));
        } catch(IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }
}
