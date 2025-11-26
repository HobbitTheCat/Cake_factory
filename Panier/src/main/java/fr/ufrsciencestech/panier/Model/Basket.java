package fr.ufrsciencestech.panier.Model;

import java.util.*;
/**
 * Classe Panier stockant et gérant un ensemble de fruits (oranges, bananes, ...). Chaque panier possède une contenance maximale. 
 * @author roudet
 *  
 */

public class Basket {
    private ArrayList<Fruit> fruits;
    private final int capacity;

    boolean isEmpty() {return fruits.isEmpty();}
    boolean isFull() {return fruits.size() == capacity;}
    int getNbFruits() {return this.fruits.size();}
    int getCapacity() {return this.capacity;}
    public ArrayList<Fruit> getFruits() {return this.fruits;}
    Fruit getFruit(int i) {
        if (i < 0 || i >= this.getNbFruits()) throw new IndexOutOfBoundsException();
        return this.fruits.get(i);
    }


    public void setFruits(ArrayList<Fruit> fruits) throws PanierPleinException {
        if (this.getCapacity() < fruits.size()) throw new PanierPleinException();
        this.fruits = fruits;
    }
    public void setFruit(int i, Fruit fruit) {
        if (i < 0 || i >= this.getNbFruits()) throw new IndexOutOfBoundsException();
        this.fruits.set(i, fruit);
    }

    public Basket(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException();
        this.capacity = capacity;
        this.fruits = new ArrayList<>(capacity);
    }

    public Basket() {
        this.capacity = 10;
        this.fruits = new ArrayList<>(this.capacity);
    }

    public double getPrice() {
        double total = 0;
        for (int i = 0; i < this.getNbFruits(); i++) {
            total += this.getFruit(i).getPricePerKilogram(); // TODO Je ne comprends pas comment calculer le prix. Nous ne pouvons mettre qu'un kilo de chaque fruit dans le panier.
        }
        return total;
    }

    public void add(Fruit fruit) throws PanierPleinException {
        if (this.isFull()) throw new PanierPleinException();
        this.fruits.add(fruit);
    }
    public void add() throws PanierPleinException {
        if (this.isFull()) throw new PanierPleinException();
        this.fruits.add(new Orange());
    }

    public void remove() throws PanierVideException {
        if (this.isEmpty()) throw new PanierVideException();
        this.getFruits().remove(this.getNbFruits()-1);
        // TODO Observer goes here
    }
    private void remove(int i) {
        if (i < 0 || i >= this.getNbFruits()) throw new IndexOutOfBoundsException();
        this.fruits.remove(i);
    }

    public void boycottOrigin(String country) {
        for (int i = this.getNbFruits()-1; i >= 0; i--) {
            if (this.getFruit(i).getOriginCountry().equals(country)) {
                this.remove(i);
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Basket contains: \n");
        for (Fruit fruit : this.fruits) {
            sb.append(fruit.toString()).append("\n");
        }
        return sb.toString();
    }
}
