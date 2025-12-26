package fr.ufrsciencestech.panier.View;

import fr.ufrsciencestech.panier.Controller.Controleur;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public interface ViewG extends PropertyChangeListener{
    @Override
    public void propertyChange(PropertyChangeEvent evt);
    //public void update(Observable m, Object o);
    
    public void addControleur(Controleur c);

}
