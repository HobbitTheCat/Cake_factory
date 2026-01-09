package fr.ufrsciencestech.panier.Model.cake;

import fr.ufrsciencestech.panier.Model.fruit.Fruit;
import fr.ufrsciencestech.panier.Model.fruit.SimpleFruit;
import fr.ufrsciencestech.panier.Model.strategy.FruitStrategy;
import java.beans.*;

import java.util.ArrayList;
import java.util.Arrays;

public class CakeBuilder {
    private Cake cake;
    PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public CakeBuilder(String base_type, double base_layer_price) {
        this.cake = new BaseLayer(null, base_type, base_layer_price);
    }

    public CakeBuilder() {
        this.cake = null;
    }

    public CakeBuilder addCreamLayer(String cream_type, double price) {
        if (this.cake != null && this.cake.getLastType() == LayerType.TOPPING){
            throw new LayerOrderException("Cream layer can't be place after Topping.");
        }
        this.cake = new CreamLayer(this.cake, cream_type, price);
        return this;
    }

    public CakeBuilder addFruitLayer(FruitStrategy strategy, SimpleFruit... fruit){
        if (this.cake != null && this.cake.getLastType() == LayerType.TOPPING){
            throw new LayerOrderException("Fruits layer can't be place after Topping.");
        }
        Fruit fruitprocesse = strategy.process(new ArrayList<>(Arrays.asList(fruit)));
        this.cake = new FruitLayer(this.cake,fruitprocesse);
        return this;
    }

    public CakeBuilder addFruitLayer(Fruit fruit){
        if (this.cake != null && this.cake.getLastType() == LayerType.TOPPING){
            throw new LayerOrderException("Fruit layer can't be place after Topping.");
        }
        this.cake = new FruitLayer(this.cake, fruit);
        return this;
    }

    public CakeBuilder addToppingLayer(String topping_type, double price){
        this.cake = new ToppingLayer(this.cake, topping_type, price);
        
        return this;
    }
    public CakeBuilder addBaseLayer(String base_type, double price){
        if (this.cake != null && this.cake.getLastType() == LayerType.TOPPING){
            throw new LayerOrderException("Base layer can't be place after Topping.");
        }
        this.cake = new BaseLayer(this.cake, base_type, price);
        return this;
    }

    public Cake build(){
        if (this.cake == null) throw new RuntimeException("Cake must have a layer");
        pcs.firePropertyChange("content", cake, cake);
        return this.cake;
    }
    
    public void addObserver(PropertyChangeListener l) {
        pcs.addPropertyChangeListener("content", l);
    }
    
    @Override
    public String toString(){return this.cake.toString();}
}
