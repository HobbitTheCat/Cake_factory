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
import org.junit.*;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;



/**
 *
 * @author Léo P
 */
public class FruitSimpleTest {

    /**
     * Test of setPrix method, of class FruitSimple.
     */
    @Test
    public void testSetPrix() {
        double prix = -1.0;
        FruitSimple a = mock(FruitSimple.class);
        a.setPrix(prix);
        assertEquals(1,a.getPrix());
    }

    /**
     * Test of initAttributs method, of class FruitSimple.
     */
    @Test
    public void testInitAttributs() {
        double prix = -1.0;
        String origine = "Espagne";
        FruitSimple a = mock(FruitSimple.class);
        a.initAttributs(prix,origine);
        assertEquals(1,a.getPrix());
    }
    /**
     * Test of equals method, of class FruitSimple.
     */
    @Test
    public void testEquals() {
        FruitSimple a = mock(FruitSimple.class);when(a.getOrigine()).thenReturn("Espagne");when(a.getPrix()).thenReturn(1.0);
        FruitSimple b = mock(FruitSimple.class);when(b.getOrigine()).thenReturn("Espagne");when(b.getPrix()).thenReturn(2.0);
        FruitSimple c = mock(FruitSimple.class);when(c.getOrigine()).thenReturn("France");when(c.getPrix()).thenReturn(1.0);
        FruitSimple d = mock(FruitSimple.class);when(d.getOrigine()).thenReturn("Espagne");when(d.getPrix()).thenReturn(1.0);

        assertFalse(a.equals(b));
        assertFalse(a.equals(c));
        assertTrue(a.equals(d));
        assertTrue(a.equals(a));
    }

    /**
     * Test of toString method, of class FruitSimple.
     */
    
}
