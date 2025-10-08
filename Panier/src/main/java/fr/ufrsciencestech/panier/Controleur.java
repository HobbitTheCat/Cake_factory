/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier;


import fr.ufrsciencestech.panier.VueGSwing;
import fr.ufrsciencestech.panier.Panier;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Ostronix
 */
public class Controleur implements ActionListener {
    
    private Panier p;
    private VueGSwing vgs;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(((Component)e.getSource()).getName().equals("Plus"))
            try {
                p.ajoute();
        } catch (PanierPleinException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
        else
               try {
                   p.retrait();
        } catch (PanierVideException ex) {
            //Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        
        
    }
    
    public void setPanier(Panier p){
        this.p = p;
    }
    public void setVue(VueGSwing vgs){
        this.vgs = vgs;
    }
    
}
