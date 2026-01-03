package fr.ufrsciencestech.panier;
import fr.ufrsciencestech.panier.Model.cake.Cake;
import fr.ufrsciencestech.panier.Model.cake.LayerDecorator;

public class LayerDecoratorTest extends LayerDecorator {

    private final double cost;

    public LayerDecoratorTest(Cake pie, double cost) {
        super(pie);
        this.cost = cost;
    }

    @Override
    public String toString() {
        return super.toString() + ", with test ";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + this.cost;
    }
}