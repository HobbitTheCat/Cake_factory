package fr.ufrsciencestech.panier.Model;

public class FruitLayer extends LayerDecorator {
    private final Fruit processedFruit;

    public FruitLayer(Cake cake, Fruit fruit) {
        super(cake);
        this.processedFruit = fruit;
    }

    @Override
    public double getCost() {
        return super.getCost() + this.processedFruit.getPricePerKilogram();
    }

    @Override
    public String toString() {
        return super.toString() + ", FruitLayer [" + this.processedFruit + "]";
    }
}
