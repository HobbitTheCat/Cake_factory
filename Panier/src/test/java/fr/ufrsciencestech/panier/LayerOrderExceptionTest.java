package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.Model.cake.LayerOrderException;
import org.junit.Test;
import static org.junit.Assert.*;

public class LayerOrderExceptionTest {

    @Test
    public void testExceptionMessage() {
        String inputMessage = "Erreur spécifique";
        LayerOrderException exception = new LayerOrderException(inputMessage);
        assertEquals("Erreur spécifique Wrong LayerOrder.", exception.getMessage());
    }
}