package fr.ufrsciencestech.panier.Model;

import java.util.ArrayList;

public class FruitSaladStrategy implements FruitStrategy{
    @Override
    public Fruit process(ArrayList<SimpleFruit> fruits) {
        if (fruits == null || fruits.isEmpty()) {
            throw new IllegalArgumentException("Empty fruit list");
        }
        Macedoine macedoine = new Macedoine(fruits.get(0));
        for (int i = 1; i < fruits.size(); i++) {
            macedoine.addFruit(fruits.get(i));
        }
        return macedoine;
    }
}
