package fr.ufrsciencestech.panier.Model.strategy;

import fr.ufrsciencestech.panier.Model.fruit.Fruit;
import fr.ufrsciencestech.panier.Model.fruit.SimpleFruit;

import java.util.ArrayList;

public interface FruitStrategy {
    Fruit process(ArrayList<SimpleFruit> fruits);
}
