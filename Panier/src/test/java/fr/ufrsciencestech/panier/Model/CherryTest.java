package fr.ufrsciencestech.panier.Model;

import fr.ufrsciencestech.panier.Model.fruit.Cherry;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kelian
 */

public class CherryTest {

    @Test
    public void testConstructeurDefaut() {
        Cherry c = new Cherry();
        // Vérification des valeurs par défaut définies dans Cherry.java
        assertEquals(1.0, c.getPricePerKilogram(), 0.001);
        assertEquals("France", c.getOriginCountry());
    }

    @Test
    public void testConstructeurParametre() {
        // Test d'une cerise "de luxe" importée
        Cherry c = new Cherry(5.0, "Japon");
        assertEquals(5.0, c.getPricePerKilogram(), 0.001);
        assertEquals("Japon", c.getOriginCountry());
    }

    @Test
    public void testIsSeedless() {
        Cherry c = new Cherry();
        // Une cerise a un noyau, donc isSeedless doit retourner faux
        assertFalse(c.isSeedless());
    }

    @Test
    public void testToString() {
        Cherry c = new Cherry();
        String s = c.toString();
        // On vérifie que le nom de la classe et les valeurs par défaut sont bien affichés
        assertTrue(s.contains("Cherry"));
        assertTrue(s.contains("France"));
        assertTrue(s.contains("1.0"));
    }
    
    @Test
    public void testEquals() {
        Cherry c1 = new Cherry(1.0, "France");
        Cherry c2 = new Cherry(1.0, "France");
        assertTrue(c1.equals(c2));
    }
}