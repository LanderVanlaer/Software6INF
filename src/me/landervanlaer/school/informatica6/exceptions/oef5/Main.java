package me.landervanlaer.school.informatica6.exceptions.oef5;

public class Main {
    public static void main(String[] args) {
        Verdeler verdeler1 = new Verdeler(Stad.antwerpen);
        Verdeler verdeler2 = new Verdeler(Stad.oostende);

        Zender vrt = new Zender("VRT", 1, false, true);
        Zender vtm = new Zender("VTM", 0, false, true);
        Zender nas = new Zender("NAS", 3, true, false);

        verdeler1.getZenders().add(vrt);
        verdeler1.getZenders().add(vtm);
        verdeler1.getZenders().add(nas);
        verdeler2.getZenders().add(vrt);
        verdeler2.getZenders().add(vtm);
        verdeler2.getZenders().add(nas);

        Klant klant1 = new Klant("Jos", Stad.antwerpen, true);
        Klant klant2 = new Klant("Frank", Stad.antwerpen, false);

        try {
            verdeler1.letKlantHuurZender(1, klant1);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            verdeler2.letKlantHuurZender(1, klant1);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            verdeler1.letKlantHuurZender(3, klant1);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            verdeler1.letKlantHuurZender(3, klant2);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }


        try {
            verdeler1.letKlantStopHuur(1, klant1);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            verdeler2.letKlantStopHuur(1, klant1);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            verdeler1.letKlantStopHuur(3, klant1);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
        try {
            verdeler1.letKlantStopHuur(3, klant2);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
