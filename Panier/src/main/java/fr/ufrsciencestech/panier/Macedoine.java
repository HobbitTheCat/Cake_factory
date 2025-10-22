package fr.ufrsciencestech.panier;

import java.util.ArrayList;

public class Macedoine implements Fruit{
    private final ArrayList<Fruit> fruits;
    private String origin;
    private boolean isSeedless;

    public String getOrigine() {return this.origin;}

    public Macedoine(Fruit fruit) {
        this.fruits = new ArrayList<>();
        this.fruits.add(fruit);
        this.isSeedless = fruit.estSansPepin();
    }

    public void addFruit(Fruit fruit) {
        this.fruits.add(fruit);
        if (!fruit.estSansPepin()) this.isSeedless = false;
    }

    public boolean estSansPepin() {
        return this.isSeedless;
    }

    public double getPrix() {
        double price = 0;
        for (Fruit fruit : this.fruits) {
            price+=fruit.getPrix();
        }
        return price;
    }

    public String toString(){
        StringBuilder macedoine = new StringBuilder();
        macedoine.append("Macedoine de:\n");
        for (Fruit fruit : this.fruits) {
            macedoine.append(" ").append(fruit.toString()).append("\n");
        }
        return macedoine.toString();
    }
}
