package fr.ufrsciencestech.panier.Model.cake;

public abstract class LayerDecorator implements Cake{
    protected Cake cake;
    private LayerType type;

    public LayerDecorator(Cake cake,LayerType type) {
        this.cake = cake;
        this.type = type;
    }

    @Override
    public String toString() {
        return this.cake == null ? "" : this.cake.toString();
    }

    @Override
    public double getPrice() {
        return this.cake == null ? 0 : this.cake.getPrice();
    }

    @Override
    public LayerType getLastType(){
        return this.type;
    }
}
