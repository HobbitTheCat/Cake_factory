package fr.ufrsciencestech.panier.Model.fruit;
/**
 *
 * @author kelian
 */
public class Apple extends SimpleFruit {
    
    public Apple(double price, String origin) {super(price, origin);}
    public Apple() {super();}

    @Override
    protected String getDefaultOrigin() {return "Spain";}
    @Override
    protected double getDefaultPrice() {return 0.5;}

    @Override
    public String toString(){
        return "Apple from " + this.getOriginCountry() + " cost " + this.getPrice() + " euros/kg";
    }

    @Override
    public boolean isSeedless() {return false;}
    
    @Override
    public String getName(){return "Apple";}
}
