package fr.ufrsciencestech.panier.Model;

public abstract class LayerDecorator implements Cake{
    protected Cake cake;

    public LayerDecorator(Cake cake) {
        this.cake = cake;
    }

    @Override
    public String toString() {
        return this.cake == null ? "" : this.cake.toString();
    }

    @Override
    public double getCost() {
        return this.cake == null ? 0 : this.cake.getCost();
    }
}
