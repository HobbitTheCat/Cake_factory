package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.Model.fruit.Apple;
import fr.ufrsciencestech.panier.Model.fruit.SimpleFruit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppleTest extends SimpleFruitTest {
    @Override
    protected SimpleFruit createFruit(double price, String origin) {
        return new Apple(price, origin);
    }

    @Test
    void testAppleIsSeedless() {
        Apple a = new Apple();
        assertFalse(a.isSeedless(), "Apple should always have seeds");
    }

    @Test
    void testToStringFormat() {
        Apple a = new Apple(1.4, "France");
        assertEquals("Apple from France cost 1.4 euros/kg", a.toString());
    }
}
