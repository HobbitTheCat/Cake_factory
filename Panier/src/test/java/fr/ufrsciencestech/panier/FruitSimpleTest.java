/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package fr.ufrsciencestech.panier;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Léo P
 */
public class FruitSimpleTest {
    
    public FruitSimpleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPrix method, of class FruitSimple.
     */
    @Test
    public void testGetPrix() {
        System.out.println("getPrix");
        FruitSimple instance = new FruitSimpleImpl();
        double expResult = 0.0;
        double result = instance.getPrix();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrigine method, of class FruitSimple.
     */
    @Test
    public void testGetOrigine() {
        System.out.println("getOrigine");
        FruitSimple instance = new FruitSimpleImpl();
        String expResult = "";
        String result = instance.getOrigine();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrix method, of class FruitSimple.
     */
    @Test
    public void testSetPrix() {
        System.out.println("setPrix");
        double prix = 0.0;
        FruitSimple instance = new FruitSimpleImpl();
        instance.setPrix(prix);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrigine method, of class FruitSimple.
     */
    @Test
    public void testSetOrigine() {
        System.out.println("setOrigine");
        String origine = "";
        FruitSimple instance = new FruitSimpleImpl();
        instance.setOrigine(origine);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initAttributs method, of class FruitSimple.
     */
    @Test
    public void testInitAttributs() {
        System.out.println("initAttributs");
        double prix = 0.0;
        String origine = "";
        FruitSimple instance = new FruitSimpleImpl();
        instance.initAttributs(prix, origine);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class FruitSimple.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        FruitSimple instance = new FruitSimpleImpl();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class FruitSimple.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        FruitSimple instance = new FruitSimpleImpl();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of estSansPepin method, of class FruitSimple.
     */
    @Test
    public void testEstSansPepin() {
        System.out.println("estSansPepin");
        FruitSimple instance = new FruitSimpleImpl();
        boolean expResult = false;
        boolean result = instance.estSansPepin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class FruitSimpleImpl extends FruitSimple {

        public boolean estSansPepin() {
            return false;
        }
    }
    
}
