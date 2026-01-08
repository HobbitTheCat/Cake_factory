/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.Controller;

import fr.ufrsciencestech.panier.Model.*;
import fr.ufrsciencestech.panier.Model.fruit.Fruit;
import fr.ufrsciencestech.panier.View.*;
import java.awt.Component;
import java.awt.event.ActionEvent;

/**
 *
 * @author Ostronix
 */
public class ControleurPanier extends Controleur {

    private ViewBasket vb;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(((Component)e.getSource()).getName().equals("Plus"))
            try {
                b.add(ViewMenu.lst_instance.get(vb.getCBplus().getSelectedIndex()));
        } catch (PanierPleinException ex) {
            //JOptionPane.showMessageDialog(null, "Panier plein", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        else
            try {
                b.remove(vb.getCBmoins().getSelectedIndex());
        } catch (PanierVideException ex) {
            //JOptionPane.showMessageDialog(null, "Panier vide", "Erreur", JOptionPane.ERROR_MESSAGE) ;
        }
    }

public void setVue(ViewG vg){
        this.vb = (ViewBasket) vg;
    }

    
}
