package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.Model.fruit.Cherry;
import fr.ufrsciencestech.panier.Model.fruit.SimpleFruit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CherryTest extends SimpleFruitTest {
    @Override
    protected SimpleFruit createFruit(double price, String origin) {
        return new Cherry(price, origin);
    }

    @Test
    void testCherryIsSeedless() {
        Cherry c = new Cherry();
        assertFalse(c.isSeedless(), "Cherry should always have seeds");
    }

    @Test
    void testToStringFormat() {
        Cherry c = new Cherry(0.8, "Japan");
        assertEquals("Cherry from Japan cost 0.8 euros/kg", c.toString());
    }
}
