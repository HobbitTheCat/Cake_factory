package fr.ufrsciencestech.panier.Model;

import fr.ufrsciencestech.panier.Model.fruit.Fruit;
import fr.ufrsciencestech.panier.Model.fruit.Orange;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Classe Panier stockant et gérant un ensemble de fruits (oranges, bananes, ...). Chaque panier possède une contenance maximale. 
 * @author roudet
 *  
 */

public class Basket {
    private ArrayList<Fruit> fruits;
    private final int capacity;
    PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    



    public boolean isEmpty() {return fruits.isEmpty();}
    public boolean isFull() {return fruits.size() == capacity;}
    public int getNbFruits() {return this.fruits.size();}
    public int getCapacity() {return this.capacity;}
    public ArrayList<Fruit> getFruits() {return this.fruits;}
    public Fruit getFruit(int i) {
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
            total += this.getFruit(i).getPrice(); // TODO Je ne comprends pas comment calculer le prix. Nous ne pouvons mettre qu'un kilo de chaque fruit dans le panier.
        }
        return total;
    }
    
    public void addObserver(PropertyChangeListener l) {
        pcs.addPropertyChangeListener("content", l);
    }

    public void add(Fruit fruit) throws PanierPleinException {
        if (this.isFull()) throw new PanierPleinException();
        this.fruits.add(fruit);
        pcs.firePropertyChange("content", getNbFruits() - 1, getFruits().size());
    }
    public void add() throws PanierPleinException {
        if (this.isFull()) throw new PanierPleinException();
        this.fruits.add(new Orange());
        pcs.firePropertyChange("content", getNbFruits() - 1, getFruits().size());
    }

    public void remove() throws PanierVideException {
        if (this.isEmpty()) throw new PanierVideException();
        this.getFruits().remove(this.getNbFruits()-1);
        // TODO Observer goes here
        pcs.firePropertyChange("content", getNbFruits() +1, getFruits().size());
    }
    public void remove(int i)throws PanierVideException {
        if (this.isEmpty()) throw new PanierVideException();
        if (i < 0 || i >= this.getNbFruits()) throw new IndexOutOfBoundsException();
        this.fruits.remove(i);
        pcs.firePropertyChange("content", getNbFruits() + 1, getFruits().size());
    }

    public void boycottOrigin(String country) {
        for (int i = this.getNbFruits()-1; i >= 0; i--) {
            if (this.getFruit(i).getOriginCountry().equals(country)) {
                try {
                    this.remove(i);
                } catch (PanierVideException ex) {
                    Logger.getLogger(Basket.class.getName()).log(Level.SEVERE, null, ex);
                }
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
