package fr.ufrsciencestech.panier.Model.strategy;
import fr.ufrsciencestech.panier.Model.fruit.Fruit;
import fr.ufrsciencestech.panier.Model.fruit.SimpleFruit;

import java.util.ArrayList;

public class FruitSaladStrategy implements FruitStrategy{
    @Override
    public Fruit process(ArrayList<Fruit> fruits) {
        if (fruits == null || fruits.isEmpty()) {
            throw new IllegalArgumentException("Empty fruit list");
        }

        ArrayList<SimpleFruit> flatList = new ArrayList<>();
        for (Fruit fruit : fruits) {
            flatList.addAll(fruit.getIngredients());
        }

        Macedoine macedoine = new Macedoine(flatList.get(0));
        for (int i = 1; i < fruits.size(); i++) {
            macedoine.addFruit(flatList.get(i));
        }
        return macedoine;
    }
}
