package fr.ufrsciencestech.panier.layer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import fr.ufrsciencestech.panier.Model.cake.Cake;
import fr.ufrsciencestech.panier.Model.cake.ToppingLayer;

class ToppingLayerTest {

    @Mock
    private Cake mockCake;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testtoString() {
        // Arrange
        when(mockCake.toString()).thenReturn("Tarte aux fruits");
        ToppingLayer toppingLayer = new ToppingLayer(mockCake, "caramel", 0.8);

        // Act
        String desc = toppingLayer.toString();

        // Assert
        assertEquals("Tarte aux fruits, topping caramel", desc);
    }

    @Test
    void testgetPrice() {
        // Arrange
        when(mockCake.getPrice()).thenReturn(10.0);
        ToppingLayer toppingLayer = new ToppingLayer(mockCake, "caramel", 0.8);

        // Act
        double cost = toppingLayer.getPrice();

        // Assert
        assertEquals(10.8, cost, 0.001);
    }
}