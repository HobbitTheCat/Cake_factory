package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.Model.cake.Cake;
import fr.ufrsciencestech.panier.Model.cake.CakeBuilder;
import fr.ufrsciencestech.panier.Model.cake.LayerOrderException;
import fr.ufrsciencestech.panier.Model.fruit.Fruit;
import fr.ufrsciencestech.panier.Model.fruit.SimpleFruit;
import fr.ufrsciencestech.panier.Model.strategy.FruitStrategy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CakeBuilderTest {

    private CakeBuilder cakeBuilder;

    @Mock
    private FruitStrategy fruitStrategyMock;
    @Mock
    private SimpleFruit simpleFruitMock;
    @Mock
    private Fruit fruitProcessedMock;

    @Before
    public void setUp() {
        cakeBuilder = new CakeBuilder("Genoise", 5.0);
        when(fruitStrategyMock.process(any(ArrayList.class))).thenReturn(fruitProcessedMock);
    }

    @Test
    public void testBuildValidCake() {
        Cake cake = cakeBuilder
                .addCreamLayer("Vanille", 2.0)
                .addFruitLayer(simpleFruitMock)
                .addToppingLayer("Chocolat", 1.5)
                .build();

        assertNotNull(cake,"Le gâteau construit ne devrait pas être null");
    }

    @Test
    public void testAddMultipleBaseLayers() {
        Cake cake = cakeBuilder
                .addBaseLayer("Biscuit", 3.0)
                .build();

        assertNotNull(cake);
    }

    @Test(expected = LayerOrderException.class)
    public void testAddCreamAfterToppingThrowsException() {
        cakeBuilder
                .addToppingLayer("Chantilly", 2.0)
                .addCreamLayer("Vanille", 1.0);
    }

    @Test(expected = LayerOrderException.class)
    public void testAddFruitStrategyAfterToppingThrowsException() {
        cakeBuilder
                .addToppingLayer("Chantilly", 2.0)
                .addFruitLayer(fruitStrategyMock, simpleFruitMock);
    }

    @Test(expected = LayerOrderException.class)
    public void testAddSimpleFruitAfterToppingThrowsException() {
        cakeBuilder
                .addToppingLayer("Chantilly", 2.0)
                .addFruitLayer(simpleFruitMock);
    }

    @Test(expected = LayerOrderException.class)
    public void testAddBaseLayerAfterToppingThrowsException() {
        cakeBuilder
                .addToppingLayer("Chantilly", 2.0)
                .addBaseLayer("Sablé", 3.0);
    }

    @Test
    public void testExceptionMessageContent() {
        try {
            cakeBuilder
                    .addToppingLayer("Chantilly", 2.0)
                    .addBaseLayer("Sablé", 3.0);
            fail("Une LayerOrderException aurait dû être levée");
        } catch (LayerOrderException e) {
            assertTrue(e.getMessage().contains("Base layer can't be place after Topping"));
            assertTrue(e.getMessage().contains("Wrong LayerOrder"));
        }
    }
}