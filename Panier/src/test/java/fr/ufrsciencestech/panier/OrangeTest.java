package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.Model.Orange;
import junit.framework.TestCase;

import org.junit.Test;


/*
* @author Enzo P
*/
public class OrangeTest extends TestCase {

    /*
    * test of setOrigine method of class Orange
    */
    @Test
    public void testSetOrigine() {
        Orange o1 = new Orange(0.30, "Espagne");
        o1.setOrigine("France");
        assertEquals("France", o1.getOrigine());
    }

    /*
     * test of toString method of class Orange
     */
    @Test
    public void testToString() {
        Orange o = new Orange();
        String s = o.toString();
        assertTrue(s.contains("Espagne"));
        assertTrue(s.contains("0.5"));
        assertTrue(s.contains("Orange"));
    }

    /*
     * test of equals method of class Orange
     */
    @Test
    public void testEquals_True() {
        Orange o = new Orange(0.2, "Portugal");
        Orange o1 = new Orange(0.2, "Portugal");
        assertTrue(o.equals(o1));
    }
    @Test
    public void testEquals_PrixDiff() {
        Orange o = new Orange(0.2, "Portugal");
        Orange o1 = new Orange(0.3, "Portugal");
        assertFalse(o.equals(o1));
    }
    @Test
    public void testEquals_NomDiff() {
        Orange o = new Orange(0.2, "Portugal");
        Orange o1 = new Orange(0.2, "France");
        assertFalse(o.equals(o1));
    }
    @Test
    public void testEquals_Null() {
        Orange o = new Orange(0.2, "Portugal");
        assertFalse(o.equals(null));
    }
    @Test
    public void testEquals_LuiMeme() {
        Orange o = new Orange(0.2, "Portugal");
        assertTrue(o.equals(o));
    }

    /*
     * test of estSansPepin method of class Orange
     */
    @Test
    public void testEstSansPepin() {
        Orange o = new Orange();
        assertFalse(o.estSansPepin());
    }
}