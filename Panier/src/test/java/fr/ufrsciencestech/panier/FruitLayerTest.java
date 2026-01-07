package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.Model.cake.*;
import fr.ufrsciencestech.panier.Model.fruit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * 
 * @author kelian
 */

class FruitLayerTest {

    private Cake cakeMock;
    private Fruit fruitMock;
    private FruitLayer fruitLayer;

    @BeforeEach
    void setUp() {
        cakeMock = mock(Cake.class);
        fruitMock = mock(Fruit.class);
        fruitLayer = new FruitLayer(cakeMock, fruitMock);
    }

    @Test
    @DisplayName("getPrice() doit retourner la somme du prix du gâteau décoré et du fruit")
    void testGetPrice() {
        when(cakeMock.getPrice()).thenReturn(10.0);
        when(fruitMock.getPrice()).thenReturn(2.5);

        double result = fruitLayer.getPrice();

        assertEquals(12.5, result, 0.001, "Total price is incorrect");

        verify(cakeMock).getPrice();
        verify(fruitMock).getPrice();
    }

    @Test
    @DisplayName("toString() must formate the string with the fruit")
    void testToString() {
        when(cakeMock.toString()).thenReturn("SimpleCake");
        when(fruitMock.toString()).thenReturn("Banana");

        String result = fruitLayer.toString();

        String expected = "SimpleCake, FruitLayer [Banana]";
        
        assertEquals(expected, result, "Incorect toString() format");
    }
}