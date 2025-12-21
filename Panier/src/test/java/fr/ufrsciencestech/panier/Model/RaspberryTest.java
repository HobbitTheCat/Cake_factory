package fr.ufrsciencestech.panier.Model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kelian
 */

public class RaspberryTest {

    @Test
    public void testConstructeurDefaut() {
        Raspberry r = new Raspberry();
        // Vérification des valeurs par défaut définies dans Raspberry.java
        assertEquals(1.0, r.getPricePerKilogram(), 0.001);
        assertEquals("France", r.getOriginCountry());
    }

    @Test
    public void testConstructeurParametre() {
        // Test d'une framboise personnalisée
        Raspberry r = new Raspberry(3.5, "Espagne");
        assertEquals(3.5, r.getPricePerKilogram(), 0.001);
        assertEquals("Espagne", r.getOriginCountry());
    }

    @Test
    public void testIsSeedless() {
        Raspberry r = new Raspberry();
        // Dans ta classe, isSeedless retourne true
        assertTrue(r.isSeedless());
    }

    @Test
    public void testToString() {
        Raspberry r = new Raspberry();
        String s = r.toString();
        // Vérifie que la chaîne contient le nom et les infos par défaut
        assertTrue(s.contains("Raspberry"));
        assertTrue(s.contains("France"));
        assertTrue(s.contains("1.0"));
    }

    @Test
    public void testEquals() {
        Raspberry r1 = new Raspberry(1.0, "France");
        Raspberry r2 = new Raspberry(1.0, "France");
        assertTrue(r1.equals(r2));
        
        Raspberry r3 = new Raspberry(2.0, "France");
        assertFalse(r1.equals(r3));
    }
}