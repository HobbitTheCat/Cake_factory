package fr.ufrsciencestech.panier.Model.cake;

public class ToppingLayer extends LayerDecorator{
    private final String topping_type;
    private final double price;

    public ToppingLayer(Cake cake, String topping_type,double price){
        super(cake, LayerType.TOPPING);
        this.price = price;
        this.topping_type = topping_type;
    }

    @Override
    public double getPrice(){
        return super.getPrice() + this.price;
    }

    @Override
    public String toString(){
        return super.toString() + ", toppingLayer["+ this.topping_type + "]" ;
    }
}
