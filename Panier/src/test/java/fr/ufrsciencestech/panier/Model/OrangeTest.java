package fr.ufrsciencestech.panier.Model;

import fr.ufrsciencestech.panier.Model.fruit.Orange;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kelian
 */

public class OrangeTest {

    @Test
    public void testConstructeurDefaut() {
        Orange o = new Orange();
        assertEquals(0.5, o.getPricePerKilogram(), 0.001);
        assertEquals("Espagne", o.getOriginCountry());
    }

    @Test
    public void testConstructeurParametre() {
        Orange o = new Orange(2.0, "Italie");
        assertEquals(2.0, o.getPricePerKilogram(), 0.001);
        assertEquals("Italie", o.getOriginCountry());
    }

    @Test
    public void testPrixNegatif() {
        // SimpleFruit convertit le prix négatif en positif (valeur absolue) selon ton code
        Orange o = new Orange(-1.5, "France");
        assertEquals(1.5, o.getPricePerKilogram(), 0.001);
    }

    @Test
    public void testIsSeedless() {
        Orange o = new Orange();
        assertFalse(o.isSeedless()); // Une orange a des pépins
    }

    @Test
    public void testEquals() {
        Orange o1 = new Orange(1.0, "France");
        Orange o2 = new Orange(1.0, "France");
        Orange o3 = new Orange(1.0, "Espagne");
        
        assertTrue(o1.equals(o2));  // Même prix, même origine
        assertFalse(o1.equals(o3)); // Origine différente
    }

    @Test
    public void testToString() {
        Orange o = new Orange(1.0, "France");
        // Vérifie que le toString contient bien les infos clés
        String s = o.toString();
        assertTrue(s.contains("Orange"));
        assertTrue(s.contains("France"));
        assertTrue(s.contains("1.0"));
    }
}