package fr.ufrsciencestech.panier.Model;

public class BaseLayer extends LayerDecorator{
    private final String base_type;
    private final double price;

    public BaseLayer(Cake cake, String base_type, double price) {
        super(cake);
        this.base_type = base_type;
        this.price = price;
    }

    @Override
    public double getPrice() {return super.getPrice() + this.price;}

    @Override
    public String toString() {return super.toString() + ", BaseLayer [" + this.base_type + "]";}
}
