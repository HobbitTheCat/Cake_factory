package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.Model.Orange;
import fr.ufrsciencestech.panier.Model.SimpleFruit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class  OrangeTest extends SimpleFruitTest {
    @Override
    protected SimpleFruit createFruit(double price, String origin) {
        return new Orange(price, origin);
    }

    @Test
    void testBananaIsSeedless() {
        Orange o = new Orange();
        assertFalse(o.isSeedless(), "Orange should always have seeds");
    }

    @Test
    void testToStringFormat() {
        Orange b = new Orange(0.5, "Spain");
        assertEquals("Orange from Spain cost 0.5 euros/kg", b.toString());
    }
}
