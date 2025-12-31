package fr.ufrsciencestech.panier.Model;

public class Pineapple extends SimpleFruit {
    public Pineapple(double price, String origin) {
        super(price, origin);
    }
    public Pineapple() {
        super();
    }

    @Override
    protected String getDefaultOrigin() {return "Bresil";}
    @Override
    protected double getDefaultPrice() {return 2.0;}

    @Override
    public String toString(){
        return "Pineapple from " + this.getOriginCountry() + " cost " + this.getPrice() + " euros/kg";
    }

    @Override
    public boolean isSeedless() {return true;}
}

