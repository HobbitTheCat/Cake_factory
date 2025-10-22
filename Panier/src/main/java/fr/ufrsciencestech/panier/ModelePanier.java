/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolas
 */
public class ModelePanier {

    
    private Panier p;
    
    private PropertyChangeSupport pcs;
    
    public ModelePanier(Panier p1){
        p = p1;
        pcs = new  PropertyChangeSupport(this);
    }
    
    public void addObserver(PropertyChangeListener l) {
	pcs.addPropertyChangeListener("value", l);
    }

    public void updateP(Fruit f) {
        int old = this.p.getNbFruits();
        try {
            p.ajoute(f);
        } catch (PanierPleinException ex) {
            Logger.getLogger(ModelePanier.class.getName()).log(Level.SEVERE, null, ex);
        }        
        pcs.firePropertyChange("value", old, this.p.getNbFruits());
        }
    
    public void updateM() {
        int old = this.p.getNbFruits();
        try {        
            p.retrait();
        } catch (PanierVideException ex) {
            Logger.getLogger(ModelePanier.class.getName()).log(Level.SEVERE, null, ex);
        }
        pcs.firePropertyChange("value", old, this.p.getNbFruits());
        }
    
    public Panier getPanier() {
        return this.p;
    }
    
    public void setPanier(Panier panier) {
        int old = this.p.getNbFruits();
        this.p = panier;
        pcs.firePropertyChange("value", old, this.p.getNbFruits());
        }


    
}
