package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.Model.Banana;
import fr.ufrsciencestech.panier.Model.SimpleFruit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BananaTest extends SimpleFruitTest {
    @Override
    protected SimpleFruit createFruit(double price, String origin) {
        return new Banana(price, origin);
    }

    @Test
    void testBananaIsSeedless() {
        Banana b = new Banana();
        assertTrue(b.isSeedless(), "Banana should always be seedless");
    }

    @Test
    void testToStringFormat() {
        Banana b = new Banana(0.5, "Cameroun");
        assertEquals("Banana from Cameroun cost 0.5 euros/kg", b.toString());
    }
}
