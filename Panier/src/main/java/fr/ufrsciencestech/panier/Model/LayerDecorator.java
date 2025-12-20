package fr.ufrsciencestech.panier.Model;

public abstract class LayerDecorator implements Cake{
    protected Cake cake;

    public LayerDecorator(Cake cake) {this.cake = cake;}

    @Override
    public String toString() {
        return cake == null ? "" : cake.toString();
    }

    @Override
    public double getCost() {
        return cake == null ? 0 : cake.getCost();
    }
}
