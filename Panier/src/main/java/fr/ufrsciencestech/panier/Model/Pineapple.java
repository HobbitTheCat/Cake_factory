package fr.ufrsciencestech.panier.Model;

public class Pineapple extends SimpleFruit {
    @Override
    protected String getDefaultOrigin() {return "Bresil";}
    @Override
    protected double getDefaultPrice() {return 2.0;}

    @Override
    public String toString(){
        return "Pineapple from " + this.getOriginCountry() + " cost " + this.getPricePerKilogram() + " euros/kg";
    }

    @Override
    public boolean isSeedless() {return true;}
    
    public Pineapple() {
        super();
    }

    public Pineapple(double price, String origin) {
        super(price, origin);
    }
}

