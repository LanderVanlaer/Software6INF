package me.landervanlaer.school.informatica6.subEnSuper.oef12;

import me.landervanlaer.school.informatica6.subEnSuper.oef11.Dier;
import me.landervanlaer.school.informatica6.subEnSuper.oef11.Rund;
import me.landervanlaer.school.informatica6.subEnSuper.oef11.Vogel;

import java.util.Calendar;
import java.util.Date;

public class Zoo {
    Dier[] dieren = new Dier[20];

    public Zoo(Dier... dieren) {
        for(int i = 0; i < dieren.length && i < this.dieren.length; i++) {
            this.dieren[i] = dieren[i];
        }
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo(
                new Rund("Berta", new Date(), 350, 32, 2),
                new Vogel("Vly", new Date(2000, Calendar.FEBRUARY, 1), 10, 2, 500)
        );
        System.out.println(zoo.getHoeveelheidEtenNodig());
        zoo.geefEten();
        System.out.println(zoo.getHoeveelheidEtenNodig());
    }

    public int getHoeveelheidEtenNodig() {
        int sum = 0;
        for(Dier dier : getDieren()) {
            if(dier != null)
                sum += dier.getPortie();
        }
        return sum;
    }

    public void geefEten() {
        for(Dier dier : getDieren())
            if(dier != null)
                dier.eetEenPortie();
    }

    public Dier[] getDieren() {
        return dieren;
    }

    public void setDieren(Dier[] dieren) {
        this.dieren = dieren;
    }
}
