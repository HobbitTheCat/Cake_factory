package fr.ufrsciencestech.panier.layer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import fr.ufrsciencestech.panier.Model.cake.LayerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import fr.ufrsciencestech.panier.Model.cake.Cake;
import fr.ufrsciencestech.panier.Model.cake.CreamLayer;

class CreamLayerTest {

    @Mock
    private Cake mockCake;

    @Test
    void testGetDesc() {
        // Arrange
        when(mockCake.toString()).thenReturn("BaseLayer [pâte]");
        CreamLayer creamLayer = new CreamLayer(mockCake, "crème pâtissière", 1.5);

        // Act
        String desc = creamLayer.toString();

        // Assert
        assertEquals("BaseLayer [pâte], CreamLayer [crème pâtissière]", desc);
    }

    @Test
    void testToStringAsFirstLayer() {
        CreamLayer creamLayer = new CreamLayer(null, "chantilly", 1.0);
        String desc = creamLayer.toString();
        assertEquals("CreamLayer [chantilly]", desc);
    }


    @Test
    void testGetPrice() {
        // Arrange
        when(mockCake.getPrice()).thenReturn(10.0);
        CreamLayer creamLayer = new CreamLayer(mockCake, "crème pâtissière", 1.5);

        // Act
        double cost = creamLayer.getPrice();

        // Assert
        assertEquals(11.5, cost, 0.001);
    }

    @Test
    void testGetLastType() {
        CreamLayer creamLayer = new CreamLayer(mockCake, "any", 0.0);
        assertEquals(LayerType.CREAM, creamLayer.getLastType());
    }
}