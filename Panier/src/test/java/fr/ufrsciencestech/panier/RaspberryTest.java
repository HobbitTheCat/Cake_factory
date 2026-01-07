package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.Model.fruit.Raspberry;
import fr.ufrsciencestech.panier.Model.fruit.SimpleFruit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RaspberryTest extends SimpleFruitTest {
    @Override
    protected SimpleFruit createFruit(double price, String origin) {
        return new Raspberry(price, origin);
    }

    @Test
    void testRaspberryIsSeedless() {
        Raspberry r = new Raspberry();
        assertTrue(r.isSeedless(), "Raspberry should always be seedless");
    }

    @Test
    void testToStringFormat() {
        Raspberry r = new Raspberry(2.0, "Germany");
        assertEquals("Raspberry from Germany cost 2.0 euros/kg", r.toString());
    }
}
