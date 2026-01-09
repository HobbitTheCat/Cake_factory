package fr.ufrsciencestech.panier.layer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import fr.ufrsciencestech.panier.Model.cake.BaseLayer;
import fr.ufrsciencestech.panier.Model.cake.LayerType;
import fr.ufrsciencestech.panier.Model.cake.Cake;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BaseLayerTest {

    @Mock
    private Cake mockCake;

    @Test
    void testToStringWithParent() {
        // Arrange
        when(mockCake.toString()).thenReturn("PreviousLayer");
        BaseLayer baseLayer = new BaseLayer(mockCake, "pâte sablée", 2.5);

        // Act
        String description = baseLayer.toString();

        // Assert
        assertEquals("PreviousLayer, BaseLayer [pâte sablée]", description);
    }

    @Test
    void testGetPrice() {
        // Arrange
        when(mockCake.getPrice()).thenReturn(10.0);
        BaseLayer baseLayer = new BaseLayer(mockCake, "pâte sablée", 2.5);

        // Act
        double cost = baseLayer.getPrice();

        // Assert
        assertEquals(12.5, cost, 0.001);
    }

    @Test
    void testGetLastType() {
        // Arrange
        BaseLayer baseLayer = new BaseLayer(mockCake, "pâte sablée", 2.5);

        // Act & Assert
        assertEquals(LayerType.BASE, baseLayer.getLastType());
    }

    @Test
    void testToStringAsFirstLayer() {
        BaseLayer baseLayer = new BaseLayer(null, "pâte sablée", 2.5);
        assertEquals("BaseLayer [pâte sablée]", baseLayer.toString());
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