package fr.ufrsciencestech.panier.Model.cake;

public class CreamLayer extends LayerDecorator{
    private final String cream_type;
    private final double price;

    public CreamLayer(Cake cake, String cream_type, double price) {
        super(cake);
        this.price = price;
        this.cream_type = cream_type;
    }

    @Override
    public double getPrice() {return super.getPrice() + this.price;}

    @Override
    public LayerType getLastType() {return LayerType.CREAM;}

    @Override
    public String toString() {
        String s = super.toString();
        return s.isEmpty() ? "CreamLayer [" + this.cream_type + "]" : s + ", CreamLayer [" + this.cream_type + "]";
    }
}
