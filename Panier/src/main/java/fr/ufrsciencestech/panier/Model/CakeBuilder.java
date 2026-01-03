package fr.ufrsciencestech.panier.Model;

public class CakeBuilder {
    private Cake cake;

    public CakeBuilder(String base_type, double base_layer_price) {
        this.cake = new BaseLayer(null, base_type, base_layer_price);
    }

    public CakeBuilder addCreamLayer(String cream_type, double price) {
        this.cake = new CreamLayer(this.cake, cream_type, price);
        return this;
    }


}
