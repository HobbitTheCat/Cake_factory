package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.Model.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Disabled;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PanierTest {
    private Basket basket;
    private final int DEFAULT_CAPACITY = 5;

    @BeforeEach
    void setUp() {basket = new Basket(DEFAULT_CAPACITY);}

    @Test
    @DisplayName("Constructor must correctly set capacity")
    void testSetCapacityCorrectly() {
        Basket b = new Basket(10);
        assertEquals(10, b.getCapacity());
    }

    @Test
    @DisplayName("Exception for negative capacity")
    public void testThrowsOnNegativeCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new Basket(-10));
    }

    @Test
    @DisplayName("Adding fruit")
    void testAddFruit() throws PanierPleinException {
        Fruit f = mock(Fruit.class);
        basket.add(f);

        assertEquals(1, basket.getNbFruits());
        assertFalse(basket.isEmpty());
        assertSame(f, basket.getFruit(0));
    }

    @Test
    @DisplayName("Throw when full")
    void testThrowsWhenFull() throws PanierPleinException {
        Basket smallBasket = new Basket(1);
        smallBasket.add(mock(Fruit.class));
        assertThrows(PanierPleinException.class, () -> smallBasket.add(mock(Fruit.class)));
    }

    @Test
    @DisplayName("Remove last fruit")
    void testRemoveLastFruit() throws PanierPleinException, PanierVideException {
        Fruit f1 = mock(Fruit.class);
        Fruit f2 = mock(Fruit.class);
        basket.add(f1);
        basket.add(f2);

        basket.remove();

        assertEquals(1, basket.getNbFruits());
        assertSame(f1, basket.getFruit(0));
    }

    @Test
    @DisplayName("Exception when deleting from an empty trash can")
    void testRemoveWhenEmpty() {
        assertThrows(PanierVideException.class,  () -> basket.remove());
    }

    @Test
    @DisplayName("Boycott origin")
    void testBoycottOrigin() throws PanierPleinException {
        Fruit france = mock(Fruit.class);
        when(france.getOriginCountry()).thenReturn("France");

        Fruit spain = mock(Fruit.class);
        when(spain.getOriginCountry()).thenReturn("Spain");

        basket.add(france);
        basket.add(spain);
        basket.add(france);

        basket.boycottOrigin("France");

        assertEquals(1, basket.getNbFruits());
        assertSame(spain, basket.getFruit(0));
    }

    @Test
    @DisplayName("Calculating the total cost of the basket")
    void testCalculateTotalCostOfBasket() throws PanierPleinException {
        Fruit f1 = mock(Fruit.class);
        when(f1.getPrice()).thenReturn(1.5);

        Fruit f2 = mock(Fruit.class);
        when(f2.getPrice()).thenReturn(2.5);

        basket.add(f1);
        basket.add(f2);

        assertEquals(4.0, basket.getPrice(), 0.001);
    }

    @Test
    @DisplayName("Invalid index exception")
    void testInvalidIndexException() throws PanierPleinException {
        basket.add(mock(Fruit.class));

        assertAll(
                () -> assertThrows(IndexOutOfBoundsException.class, () -> basket.getFruit(-1)),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> basket.getFruit(5))
        );
    }

    @Test
    @DisplayName("Replacing the fruit list via setFruits")
    void testReplacingFruitList() throws PanierPleinException {
        ArrayList<Fruit> list = new ArrayList<>();
        list.add(mock(Fruit.class));
        list.add(mock(Fruit.class));

        basket.setFruits(list);
        assertEquals(2, basket.getNbFruits());
    }

    @Test
    @DisplayName("Exception if the list exceeds capacity")
    void testExceptionIfTheListExceedsCapacity() {
        Basket small = new Basket(1);
        ArrayList<Fruit> list = new ArrayList<>();
        list.add(mock(Fruit.class));
        list.add(mock(Fruit.class));

        assertThrows(PanierPleinException.class, () -> small.setFruits(list));
    }

    @Disabled("Réaliser equals par contrat - comparaison des compositions des paniers")
    @Test
    void testEquals() throws PanierPleinException {
        Basket b1 =  new Basket(2);
        Basket b2 = new Basket(2);
        Fruit f1 = mock(Fruit.class);

        b1.add(f1);
        b1.add(f1);

        assertEquals(b1, b2);
    }
}
