package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.Model.cake.Cake;
import fr.ufrsciencestech.panier.Model.cake.LayerDecorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class CakeDecoratorTest {
    @Test
    public void testDecorator() {

        Cake mockCake = mock(Cake.class);

        when(mockCake.toString()).thenReturn("Tarte test");
        when(mockCake.getPrice()).thenReturn(2.0);

        LayerDecorator layer = new LayerDecoratorTest(mockCake, 2.3);

        assertEquals("Tarte test, avec test", layer.toString());
        assertEquals(4.3, layer.getPrice());

        verify(mockCake, times(1)).toString();
        verify(mockCake, times(1)).getPrice();
    }

    @Test
    public void testEmpilementDecorator() {
        Cake mockCake = mock(Cake.class);

        when(mockCake.toString()).thenReturn("Tarte test");
        when(mockCake.getPrice()).thenReturn(2.0);

        Cake firstLayer = new LayerDecoratorTest(mockCake, 2.3);

        Cake secondLayer = new LayerDecoratorTest(firstLayer, 3.0);

        assertEquals("Tarte test, avec test , avec test", secondLayer.toString());
        assertEquals(7.3, secondLayer.getPrice());

        verify(mockCake, times(1)).toString();
        verify(mockCake, times(1)).getPrice();
    }
}