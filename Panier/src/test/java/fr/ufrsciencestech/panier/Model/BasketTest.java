package fr.ufrsciencestech.panier.Model;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kelian
 */

public class BasketTest {

    private Basket basket;

    @Before
    public void setUp() {
        // Avant chaque test, on crée un panier vide de capacité 3 pour faciliter les tests
        basket = new Basket(3);
    }

    @Test
    public void testConstructeurDefaut() {
        Basket b = new Basket();
        assertEquals(10, b.getCapacity());
        assertTrue(b.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructeurInvalide() {
        new Basket(-1); // Doit lancer une exception
    }

    @Test
    public void testIsEmpty() throws PanierPleinException {
        assertTrue(basket.isEmpty());
        basket.add(new Orange());
        assertFalse(basket.isEmpty());
    }

    @Test
    public void testIsFull() throws PanierPleinException {
        assertFalse(basket.isFull());
        basket.add(new Orange());
        basket.add(new Banana());
        basket.add(new Cherry());
        assertTrue(basket.isFull()); // Capacité de 3 atteinte
    }

    @Test
    public void testAddFruit() throws PanierPleinException {
        assertEquals(0, basket.getNbFruits());
        basket.add(new Orange());
        assertEquals(1, basket.getNbFruits());
    }

    @Test(expected = PanierPleinException.class)
    public void testAddPanierPlein() throws PanierPleinException {
        basket.add(new Orange());
        basket.add(new Orange());
        basket.add(new Orange());
        basket.add(new Orange()); // Doit lancer PanierPleinException car cap = 3
    }

    @Test
    public void testRemove() throws PanierPleinException, PanierVideException {
        basket.add(new Orange());
        basket.remove();
        assertEquals(0, basket.getNbFruits());
    }

    @Test(expected = PanierVideException.class)
    public void testRemovePanierVide() throws PanierVideException {
        basket.remove(); // Doit lancer PanierVideException
    }

    @Test
    public void testGetPrice() throws PanierPleinException {
        // On ajoute une Orange (0.5) et une Banane (0.5)
        // Note: vérifie les prix par défaut dans tes classes
        basket.add(new Orange(0.5, "France")); 
        basket.add(new Banana(0.5, "Cameroun"));
        
        double attendu = 1.0;
        // Le 3ème paramètre est la tolérance (delta) obligatoire pour les doubles
        assertEquals(attendu, basket.getPrice(), 0.001); 
    }

    @Test
    public void testBoycottOrigin() throws PanierPleinException {
        basket.add(new Orange(1.0, "France"));
        basket.add(new Banana(1.0, "Espagne")); // Celui-ci doit être supprimé
        basket.add(new Cherry(1.0, "France"));

        basket.boycottOrigin("Espagne");

        assertEquals(2, basket.getNbFruits());
        // Vérifie qu'il reste bien les produits français
        assertEquals("France", basket.getFruit(0).getOriginCountry());
        assertEquals("France", basket.getFruit(1).getOriginCountry());
    }
    
    @Test
    public void testSetFruits() throws PanierPleinException {
        ArrayList<Fruit> liste = new ArrayList<>();
        liste.add(new Orange());
        liste.add(new Banana());
        
        basket.setFruits(liste);
        assertEquals(2, basket.getNbFruits());
    }

    @Test(expected = PanierPleinException.class)
    public void testSetFruitsTropGros() throws PanierPleinException {
        ArrayList<Fruit> liste = new ArrayList<>();
        liste.add(new Orange());
        liste.add(new Banana());
        liste.add(new Cherry());
        liste.add(new Pineapple()); // 4 fruits pour un panier de 3
        
        basket.setFruits(liste);
    }
}