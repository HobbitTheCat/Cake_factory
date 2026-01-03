package fr.ufrsciencestech.panier.Model;

import fr.ufrsciencestech.panier.Model.fruit.Banana;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kelian
 */

public class BananaTest {

    @Test
    public void testIsSeedless() {
        Banana b = new Banana();
        assertTrue(b.isSeedless()); // Une banane n'a pas de pépins
    }
    
    @Test
    public void testDefaults() {
        Banana b = new Banana();
        assertEquals(0.5, b.getPricePerKilogram(), 0.001);
        assertEquals("Cameroun", b.getOriginCountry());
    }
}