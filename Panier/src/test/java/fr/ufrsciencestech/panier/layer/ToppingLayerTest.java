package fr.ufrsciencestech.panier.layer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import fr.ufrsciencestech.panier.Model.cake.LayerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import fr.ufrsciencestech.panier.Model.cake.Cake;
import fr.ufrsciencestech.panier.Model.cake.ToppingLayer;

//@ExtendWith(MockitoExtension.class)
class ToppingLayerTest {

    @Mock
    private Cake mockCake;

    @Test
    void testToStringWithParent() {
        // Arrange
        when(mockCake.toString()).thenReturn("CakeWithBase");
        ToppingLayer toppingLayer = new ToppingLayer(mockCake, "caramel", 0.8);

        // Act
        String desc = toppingLayer.toString();

        // Assert
        assertEquals("CakeWithBase, ToppingLayer[caramel]", desc);
    }

    @Test
    void testToStringAsFirstLayer() {
        ToppingLayer toppingLayer = new ToppingLayer(null, "chocolate", 0.5);
        String desc = toppingLayer.toString();
        assertEquals("ToppingLayer[chocolate]", desc);
    }

    @Test
    void testGetPrice() {
        // Arrange
        when(mockCake.getPrice()).thenReturn(10.0);
        ToppingLayer toppingLayer = new ToppingLayer(mockCake, "caramel", 0.8);

        // Act
        double cost = toppingLayer.getPrice();

        // Assert
        assertEquals(10.8, cost, 0.001);
    }

    @Test
    void testGetLastType() {
        ToppingLayer toppingLayer = new ToppingLayer(mockCake, "any", 0.0);
        assertEquals(LayerType.TOPPING, toppingLayer.getLastType());
    }
}