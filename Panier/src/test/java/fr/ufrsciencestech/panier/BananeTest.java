package fr.ufrsciencestech.panier;

import junit.framework.TestCase;

public class BananeTest extends TestCase {

    public void testSetOrigine() {
        Banane b1 = new Banane(0.5,"france");
        b1.setOrigine("BananeLand");
        assertEquals("BananeLand", b1.pays_origine);
        assertFalse("france".equals(b1.getOrigine()));

    }

    public void testTestToString() {
        Banane b = new Banane();
        assertEquals("Banane de Cameroun a 0.5 euros", b.toString());
        b.setOrigine("BananeLand");
        assertFalse("Banane de Cameroun a 0.5 euros".equals(b.toString()));
    }

    public void testTestEquals() {
        Banane b1 = new Banane(0.5,"france");
        Banane b2 = new Banane(0.5,"france");
        Banane b3 = new Banane(1,"BananeLand");
        assertTrue(b1.equals(b2));
        assertFalse(b1.equals(b3));
    }



    public void testEstSansPepin() {
        Banane b = new Banane();
        assertTrue(b.estSansPepin());

    }
}
