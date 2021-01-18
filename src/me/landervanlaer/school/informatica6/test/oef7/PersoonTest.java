package me.landervanlaer.school.informatica6.test.oef7;

import me.landervanlaer.school.informatica6.exceptions.oef4.Boek;
import me.landervanlaer.school.informatica6.exceptions.oef4.Geslacht;
import me.landervanlaer.school.informatica6.exceptions.oef4.Persoon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PersoonTest {
    private Persoon persoon;
    private Boek boek0;
    private Boek boek1;

    @Before
    public void setUp() {
        persoon = new Persoon("Jan", Geslacht.Man, true, 18);
        boek0 = new Boek("5286d869-4b8c-48fc-878a-a60d4c98a2e8", "Carry", "Franske Jong");
        boek0 = new Boek("38e0ee3a-8929-4bc6-8ca6-9fd6ba5068c4", "Where", "Ding Bing");
    }

    @Test
    public void constructors() {
        Persoon persoon = new Persoon("Jos Jansens", Geslacht.Man, false, 20);
        assertEquals("Jos Jansens", persoon.getNaam());
        assertEquals(Geslacht.Man, persoon.getGeslacht());
        assertFalse(persoon.isLidgeldBetaald());
        assertEquals(20, persoon.getLeeftijd());
    }

    @Test
    public void leenBoek_Effective() {
        persoon.leenBoek(boek0);
    }

    @Test
    public void leenBoek_InEffective() {
    }
}
