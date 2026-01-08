package fr.ufrsciencestech.panier.Controller;

import fr.ufrsciencestech.panier.Model.Basket;
import java.awt.event.ActionListener;


/**
 *
 * @author Nicolas
 */


public abstract class Controleur implements ActionListener{
    protected Basket b;
    
    public void setPanier(Basket b){
        this.b = b;
    }
}
