package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.Model.FruitSimple;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author kelian
 */
public abstract class FruitSimpleTest {

    /*
     * The Factory Method.
     */
    abstract FruitSimple createFruit(double prix, String origine);
    abstract FruitSimple createFruitNull();

    /**
     * Test de getPrix().
     */
    @Test
    public void testGetPrix() {
        FruitSimple fs = createFruit(0.5, "France");
        double expected = 0.5;
        double result = fs.getPrix();
        assertEquals(expected, result, 1e-9);
    }

    /**
     * Test de getOrigine().
     */
    @Test
    public void testGetOrigine() {
        FruitSimple fs = createFruit(0.5, "France");
        String expected = "France";
        String result = fs.getOrigine();
        assertEquals(expected, result);
    }

    /**
     * Test de setPrix() : doit gérer les prix négatifs.
     */
    @Test
    public void testSetPrix() {
        FruitSimple fs = createFruit(1.0, "Espagne");
        fs.setPrix(2.0);
        assertEquals(2.0, fs.getPrix(), 1e-9);

        // Test prix négatif : doit être converti en positif
        fs.setPrix(-3.0);
        assertEquals(3.0, fs.getPrix(), 1e-9);
    }

    /**
     * Test de setOrigine().
     */
    @Test
    public void testSetOrigine() {
        FruitSimple fs = createFruit(1.0, "Espagne");
        fs.setOrigine("Italie");
        assertEquals("Italie", fs.getOrigine());
    }

    /**
     * Test de initAttributs() (indirect via constructeur / factory)
     */
    @Test
    public void testInitAttributs() {
        FruitSimple fs = createFruit(-2.0, "Italie");
        // Le prix doit être positif même si négatif en entrée
        assertTrue(fs.getPrix() > 0);
        assertEquals("Italie", fs.getOrigine());
    }

    /**
     * Test de equals().
     */
    @Test
    public void testEquals() {
        FruitSimple a = createFruit(1.0, "Espagne");
        FruitSimple b = createFruit(2.0, "Espagne");
        FruitSimple c = createFruit(1.0, "France");
        FruitSimple d = createFruit(1.0, "Espagne");

        assertFalse(a.equals(b)); // prix différent
        assertFalse(a.equals(c)); // origine différente
        assertTrue(a.equals(d));  // mêmes attributs
        assertTrue(a.equals(a));  // même objet
    }

    /**
     * Test de toString() : doit retourner le nom de la classe simple.
     */
    @Test
    public void testToString() {
        FruitSimple fs = createFruit(1.0, "Espagne");
        String expected = fs.getClass().getSimpleName();
        assertEquals(expected, fs.toString());
    }
}
