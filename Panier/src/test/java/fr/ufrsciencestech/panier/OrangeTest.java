package fr.ufrsciencestech.panier;

import junit.framework.TestCase;

public class OrangeTest extends TestCase {

    @Test
    public void testSetOrigine() {
        Orange o1 = new Orange(0.30, "Espagne");
        o1.setOrigine("France");
        assertEquals("France", o1.pays_origine);
    }

    public void testTestToString() {
        Orange o = new Orange();
        assertEquals("Orange de Espagne a 0.5 euros", o.toString());
    }

    public void testTestEquals() {
        Orange o = new Orange(0.2, "Portugal");
        Orange o1 = new Orange(0.2, "Portugal");
        assertTrue(o.equals(o1));
    }

    public void testEstSansPepin() {
        Orange o = new Orange();
        assertTrue(o.estSansPepin());
    }

    public void testMain() {
    }
}