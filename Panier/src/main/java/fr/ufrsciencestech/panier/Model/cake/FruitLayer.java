package fr.ufrsciencestech.panier.Model.cake;
import fr.ufrsciencestech.panier.Model.fruit.Fruit;

public class FruitLayer extends LayerDecorator {
    private final Fruit processedFruit;

    public FruitLayer(Cake cake, Fruit fruit) {
        super(cake);
        this.processedFruit = fruit;
    }

    @Override
    public double getPrice() {
        return super.getPrice() + this.processedFruit.getPrice();
    }

    @Override
    public LayerType getLastType() {return LayerType.FRUIT;}

    @Override
    public String toString() {
        String s = super.toString();
        return s.isEmpty() ? "FruitLayer [" + this.processedFruit + "]" : s + ", FruitLayer [" + this.processedFruit + "]";
    }
}
