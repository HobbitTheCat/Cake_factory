package fr.ufrsciencestech.panier.Model;

import java.util.ArrayList;

public interface FruitStrategy {
    Fruit process(ArrayList<SimpleFruit> fruits);
}
