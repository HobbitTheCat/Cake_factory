package fr.ufrsciencestech.panier.Model.cake;

public class CreamLayer extends LayerDecorator{
    private final String cream_type;
    private final double price;

    public CreamLayer(Cake cake, String cream_type, double price) {
        super(cake,LayerType.CREAM);
        this.price = price;
        this.cream_type = cream_type;
    }

    @Override
    public double getPrice() {return super.getPrice() + this.price;}

    @Override
    public String toString() {
        return super.toString() + ", CreamLayer [" + this.cream_type + "]";
    }
}
