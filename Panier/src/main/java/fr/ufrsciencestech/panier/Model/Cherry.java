package fr.ufrsciencestech.panier.Model;

public class Cherry extends SimpleFruit{
    @Override
    protected String getDefaultOrigin() {return "France";}
    @Override
    protected double getDefaultPrice() {return 1.0;}

    @Override
    public String toString(){
        return "Cherry from " + this.getOriginCountry() + " cost " + this.getPricePerKilogram() + " euros/kg";
    }

    @Override
    public boolean isSeedless() {return false;}
    
    
    public Cherry() {
        super();
    }

    public Cherry(double price, String origin) {
        super(price, origin);
    }
}
