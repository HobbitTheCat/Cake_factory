package fr.ufrsciencestech.panier.Model.strategy;

import fr.ufrsciencestech.panier.Model.fruit.Fruit;
import fr.ufrsciencestech.panier.Model.fruit.SimpleFruit;

import java.util.ArrayList;

public class Macedoine implements Fruit {
    private final ArrayList<SimpleFruit> fruits;
    private String origin;

    @Override
    public String getOriginCountry() {return this.origin;}

    @Override
    public boolean isSeedless() {
        for (Fruit fruit : this.fruits) if (!fruit.isSeedless()) return false;
        return true;
    }

    @Override
    public double getPrice() {
        double price = 0;
        for (Fruit fruit : this.fruits) price+=fruit.getPrice();
        return price;
    }

    public void addFruit(SimpleFruit fruit) {
        this.fruits.add(fruit);
    }

    public Macedoine(SimpleFruit fruit) {
        this.fruits = new ArrayList<>();
        this.fruits.add(fruit);
    }

    @Override
    public String toString(){
        StringBuilder macedoine = new StringBuilder();
        macedoine.append("Macedoine de:\n");
        for (Fruit fruit : this.fruits) {
            macedoine.append(" ").append(fruit.toString()).append("\n");
        }
        return macedoine.toString();
    }
    
    @Override
    public String getName(){return "Macedoine";}
}
