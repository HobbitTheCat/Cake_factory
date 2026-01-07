package fr.ufrsciencestech.panier.layer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import fr.ufrsciencestech.panier.Model.cake.BaseLayer;
import fr.ufrsciencestech.panier.Model.cake.Cake;

class BaseLayerTest {

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
        BaseLayer baseLayer = new BaseLayer(mockCake, "pâte sablée", 2.5);

        // Act
        String description = baseLayer.toString();

        // Assert
        assertEquals("Tarte aux fruits, base pâte sablée", description);
    }

    @Test
    void testgetPrice() {
        // Arrange
        when(mockCake.getPrice()).thenReturn(10.0);
        BaseLayer baseLayer = new BaseLayer(mockCake, "pâte sablée", 2.5);

        // Act
        double cost = baseLayer.getPrice();

        // Assert
        assertEquals(12.5, cost, 0.001);
    }

    @Test
    void testIntegrationWithCakeMultipleLayers() {
        // Arrange
        when(mockCake.toString()).thenReturn("Tarte aux fruits");
        when(mockCake.getPrice()).thenReturn(10.0);

        BaseLayer baseLayer = new BaseLayer(mockCake, "pâte sablée", 2.5);

        // Act
        String desc = baseLayer.toString();
        double cost = baseLayer.getPrice();

        // Assert
        assertEquals("Tarte aux fruits, base pâte sablée", desc);
        assertEquals(12.5, cost, 0.001);
    }
}