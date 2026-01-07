package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.Model.fruit.Pineapple;
import fr.ufrsciencestech.panier.Model.fruit.SimpleFruit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PineappleTest extends SimpleFruitTest {
    @Override
    protected SimpleFruit createFruit(double price, String origin) {
        return new Pineapple(price, origin);
    }

    @Test
    void testPineappleIsSeedless() {
        Pineapple p = new Pineapple();
        assertTrue(p.isSeedless(), "Pineapple should always be seedless");
    }

    @Test
    void testToStringFormat() {
        Pineapple p = new Pineapple(3.2, "Brazil");
        assertEquals("Pineapple from Brazil cost 3.2 euros/kg", p.toString());
    }
}
