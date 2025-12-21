package fr.ufrsciencestech.panier.Model;

public class Banana extends SimpleFruit {
    @Override
    protected String getDefaultOrigin() {return "Cameroun";}
    @Override
    protected double getDefaultPrice() {return 0.5;}

    @Override
    public String toString(){
        return "Banana from " + this.getOriginCountry() + " cost " + this.getPricePerKilogram() + " euros/kg";
    }

    @Override
    public boolean isSeedless() {return true;}
    
    public Banana() {
        super();
    }

    public Banana(double price, String origin) {
        super(price, origin);
    }
}
