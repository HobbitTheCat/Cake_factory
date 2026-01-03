package fr.ufrsciencestech.panier.Model;

import fr.ufrsciencestech.panier.Model.fruit.Pineapple;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kelian
 */

public class PineappleTest {

    @Test
    public void testConstructeurDefaut() {
        Pineapple p = new Pineapple();
        // Vérification des valeurs par défaut définies dans Pineapple.java
        assertEquals(2.0, p.getPricePerKilogram(), 0.001);
        assertEquals("Bresil", p.getOriginCountry()); // "Bresil" sans accent dans ta classe
    }

    @Test
    public void testConstructeurParametre() {
        Pineapple p = new Pineapple(3.5, "Reunion");
        assertEquals(3.5, p.getPricePerKilogram(), 0.001);
        assertEquals("Reunion", p.getOriginCountry());
    }

    @Test
    public void testIsSeedless() {
        Pineapple p = new Pineapple();
        // Dans ton code, Pineapple renvoie true pour isSeedless
        assertTrue(p.isSeedless());
    }

    @Test
    public void testToString() {
        Pineapple p = new Pineapple();
        String s = p.toString();
        assertTrue(s.contains("Pineapple"));
        assertTrue(s.contains("Bresil"));
        assertTrue(s.contains("2.0"));
    }
    
    @Test
    public void testEquals() {
        Pineapple p1 = new Pineapple(2.0, "Bresil");
        Pineapple p2 = new Pineapple(2.0, "Bresil");
        assertTrue(p1.equals(p2));
    }
}