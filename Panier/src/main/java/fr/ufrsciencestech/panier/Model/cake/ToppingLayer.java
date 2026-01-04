package fr.ufrsciencestech.panier.Model.cake;

public class ToppingLayer extends LayerDecorator{
    private final String topping_type;
    private final double price;

    public ToppingLayer(Cake cake, String topping_type,double price){
        super(cake);
        this.price = price;
        this.topping_type = topping_type;
    }

    @Override
    public double getPrice(){
        return super.getPrice() + this.price;
    }

    @Override
    public LayerType getLastType() {return LayerType.TOPPING;}

    @Override
    public String toString(){
        String s = super.toString();
        return  s.isEmpty() ? "ToppingLayer["+ this.topping_type + "]" : s + ", ToppingLayer["+ this.topping_type + "]" ;
    }
}
