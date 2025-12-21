package fr.ufrsciencestech.panier.Model;

public class Orange extends SimpleFruit {
    public Orange(double price, String origin) {super(price, origin);}
    public Orange() {super();}
    @Override
    protected String getDefaultOrigin() {return "Spain";}
    @Override
    protected double getDefaultPrice() {return 0.5;}

    @Override
    public String toString(){
        return "Orange from " + this.getOriginCountry() + " cost " + this.getPricePerKilogram() + " euros/kg";
    }

    @Override
    public boolean isSeedless() {return false;}
    
    public Orange() {
        super();
    }

    public Orange(double price, String origin) {
        super(price, origin);
    }
}
