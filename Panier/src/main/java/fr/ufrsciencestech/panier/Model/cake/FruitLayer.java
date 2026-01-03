package fr.ufrsciencestech.panier.Model.cake;
import fr.ufrsciencestech.panier.Model.fruit.Fruit;

public class FruitLayer extends LayerDecorator {
    private final Fruit processedFruit;

    public FruitLayer(Cake cake, Fruit fruit) {
        super(cake,LayerType.FRUIT);
        this.processedFruit = fruit;
    }

    @Override
    public double getPrice() {
        return super.getPrice() + this.processedFruit.getPrice();
    }

    @Override
    public String toString() {
        return super.toString() + ", FruitLayer [" + this.processedFruit + "]";
    }
}
