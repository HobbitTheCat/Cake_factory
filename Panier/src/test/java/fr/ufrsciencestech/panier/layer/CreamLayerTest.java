package fr.ufrsciencestech.panier.layer;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetDesc() {
        // Arrange
        when(mockCake.toString()).thenReturn("Tarte aux fruits");
        CreamLayer creamLayer = new CreamLayer(mockCake, "crème pâtissière", 1.5);

        // Act
        String desc = creamLayer.toString();

        // Assert
        assertEquals("Tarte aux fruits, crème pâtissière", desc);
    }

    @Test
    void testGetCost() {
        // Arrange
        when(mockCake.getPrice()).thenReturn(10.0);
        CreamLayer creamLayer = new CreamLayer(mockCake, "crème pâtissière", 1.5);

        // Act
        double cost = creamLayer.getPrice();

        // Assert
        assertEquals(11.5, cost, 0.001);
    }
}