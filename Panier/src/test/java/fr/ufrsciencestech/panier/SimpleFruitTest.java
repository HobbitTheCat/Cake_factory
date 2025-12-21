package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.Model.SimpleFruit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public abstract class SimpleFruitTest {
    protected abstract SimpleFruit createFruit(double price, String origin);

    @ParameterizedTest
    @ValueSource(doubles = {1.0, 0.5, 10, 150.5})
    public void testGetPrice(double price) {
        SimpleFruit fruit = this.createFruit(price, "France");
        assertEquals(Math.abs(price), fruit.getPricePerKilogram(), 1e-9);
    }

    @ParameterizedTest
    @CsvSource({"-1.0, 1.0", "-0.5, 0.5", "-10, 10", "-150.5, 150.5"})
    public void testNegativePriceCorrection(double input, double expected) {
        SimpleFruit fruit = this.createFruit(1.0, "France");
        fruit.setPrice(input);
        assertEquals(expected, fruit.getPricePerKilogram(), 1e-9);
    }

    @Test
    public void testGetOrigin() {
        SimpleFruit fruit = this.createFruit(0.5, "France");
        assertEquals("Frane", fruit.getOriginCountry());
    }

    @Test
    public void testSetOrigin() {
        SimpleFruit fruit = this.createFruit(0.5, "France");
        fruit.setOrigin("Spain");
        assertEquals("Spain", fruit.getOriginCountry());
    }

    @Test
    public void testEquals() {
        SimpleFruit f1 = createFruit(1.0, "Spain");
        SimpleFruit f2 = createFruit(1.0, "Spain");
        SimpleFruit f3 = createFruit(2.0, "France");

        assertEquals(f1, f2);
        assertNotEquals(f1, f3);
        assertNotNull(f3);
    }
}