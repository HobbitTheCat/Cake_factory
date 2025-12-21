/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.Model;


public class Raspberry extends SimpleFruit {
    @Override
    protected String getDefaultOrigin() {return "France";}
    @Override
    protected double getDefaultPrice() {return 1.0;}

    @Override
    public String toString(){
        return "Raspberry from " + this.getOriginCountry() + " cost " + this.getPricePerKilogram() + " euros/kg";
    }

    @Override
    public boolean isSeedless() {return true;}
    
    public Raspberry() {
        super();
    }

    public Raspberry(double price, String origin) {
        super(price, origin);
    }
}