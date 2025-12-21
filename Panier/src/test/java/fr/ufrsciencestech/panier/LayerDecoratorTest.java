package fr.ufrsciencestech.panier;
import fr.ufrsciencestech.panier.Model;

public class LayerDecoratorTest extends LayerDecorator {

    private double cost;

    public LayerDecoratorTest(Cake pie, double cost) {
        super(pie);
        this.cost = cost;
    }

    @Override
    public String toString {
        return super.toString + ", avec test ";
    }

    @Override
    public double getCost() {
        return super.getCost() + this.cost;
    }
}