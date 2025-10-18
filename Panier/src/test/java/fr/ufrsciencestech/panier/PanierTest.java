package fr.ufrsciencestech.panier;
import org.junit.*;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PanierTest {
    @Test
    public void allowsZeroCapacity_andStartEmpty() {
        Panier p = new Panier(0);
        assertTrue(p.estVide());
        assertEquals(0, p.getContenanceMax());
        assertEquals(0, p.getNbFruits());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsOnNegativeCapacity() {
        Panier p = new Panier(-1);
    }

    @Test
    public void ajout_addsWhenNotFull() throws Exception {
        Panier p = new Panier(2);
        Fruit f1 = mock(Fruit.class);

        p.ajoute(f1);

        assertFalse(p.estVide());
        assertEquals(1, p.getNbFruits());
        assertSame(f1, p.getFruit(0));

        Fruit f2 = mock(Fruit.class);
        p.ajoute(f2);
        assertTrue(p.estPlein());
    }

    @Test(expected = PanierPleinException.class)
    public void ajout_throwsWhenFull() throws Exception {
        Panier p = new Panier(1);
        p.ajoute(mock(Fruit.class));
        p.ajoute(mock(Fruit.class));
    }

    @Test
    public void retrait_removesLast_whenNotEmpty() throws Exception {
        Panier p = new Panier(3);
        Fruit a = mock(Fruit.class);
        Fruit b = mock(Fruit.class);
        p.ajoute(a);
        p.ajoute(b);

        p.retrait();

        assertEquals(1, p.getNbFruits());
        assertSame(a, p.getFruit(0));
    }

    @Test(expected = PanierVideException.class)
    public void retrait_throwsWhenEmpty() throws Exception {
        Panier p = new Panier(1);
        p.retrait();
    }

    @Test
    public void setFruits_replaces_whenFirstCapacity() throws Exception {
        Panier p = new Panier(2);
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(mock(Fruit.class));
        p.setFruits(fruits);
        assertEquals(1, p.getNbFruits());
    }

    @Test(expected = PanierPleinException.class)
    public void setFruits_throws_whenExceedsCapacity() throws Exception {
        Panier p = new Panier(1);
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(mock(Fruit.class));
        fruits.add(mock(Fruit.class));
        p.setFruits(fruits);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getFruits_throws_onNegativeIndex() throws Exception {
        Panier p = new Panier(1);
        p.getFruit(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getFruits_throws_onIndexExceedsElementsNumber() throws Exception {
        Panier p = new Panier(2);
        p.ajoute(mock(Fruit.class));
        p.getFruit(1);
    }

    @Test
    public void setFruit_replace_whenFirstCapacity() throws Exception {
        Panier p = new Panier(2);
        Fruit a = mock(Fruit.class);
        p.ajoute(a);
        Fruit b = mock(Fruit.class);
        p.setFruit(0, b);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void setFruit_throws_whenTryToReplaceNonExistingFruit() throws Exception {
        Panier p = new Panier(2);
        Fruit a = mock(Fruit.class);
        p.ajoute(a);
        Fruit b = mock(Fruit.class);
        p.setFruit(1, b);
    }

    @Test
    public void boycotteOrigine_removeMatching_only() throws Exception {
        Panier p = new Panier(3);

        Fruit es1 = mock(Fruit.class); when(es1.getOrigine()).thenReturn("ES");
        Fruit fr = mock(Fruit.class); when(fr.getOrigine()).thenReturn("FR");
        Fruit es2 = mock(Fruit.class); when(es2.getOrigine()).thenReturn("ES");

        p.ajoute(es1);p.ajoute(fr);p.ajoute(es2);

        p.boycotteOrigine("ES");

        assertEquals(1, p.getNbFruits());
        assertSame(fr, p.getFruit(0));
    }

    @Test
    public void boycotteOrgine_noop_whenNoMatch() throws Exception {
        Panier p = new Panier(2);
        Fruit de = mock(Fruit.class);  when(de.getOrigine()).thenReturn("DE");
        p.ajoute(de);

        p.boycotteOrigine("DE");
        assertEquals(1, p.getNbFruits());
        assertSame(de, p.getFruit(0));
    }

    @Ignore("A inclure lorsque vous implémentez getPrix() : sum Fruit.getPrix()")
    @Test
    public void getPrix_sumsAllFruitPrices() throws Exception {
        Panier p = new Panier(3);
        Fruit a = mock(Fruit.class); when(a.getPrix()).thenReturn(1.2);
        Fruit b = mock(Fruit.class); when(b.getPrix()).thenReturn(0.8);
        p.ajoute(a); p.ajoute(b);

        assertEquals(2.0, p.getPrix(), 1e-9);
    }

    @Ignore("Réaliser equals par contrat - comparaison des compositions des paniers")
    @Test
    public void equals_true_whenSameFruitsInSameOrder_orDefineYourRule() throws Exception {
        Panier p1 = new Panier(2);
        Panier p2 = new Panier(2);
        Fruit a = mock(Fruit.class);
        Fruit b = mock(Fruit.class);
        p1.ajoute(a); p1.ajoute(b);
        p2.ajoute(a); p2.ajoute(b);

        assertTrue(p1.equals(p2));
        assertTrue(p1.equals(p1));
        assertFalse(p1.equals(null));
        assertFalse(p1.equals(new Object()));
    }
}
