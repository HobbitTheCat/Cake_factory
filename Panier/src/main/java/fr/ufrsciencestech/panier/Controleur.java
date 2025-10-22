/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier;

import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Nicolas
 */
public class Controleur implements ActionListener {

    private ModelePanier m;
    private VueGSwing vgs;
    
    public Controleur(VueGSwing vgs, ModelePanier m){
        this.m = m;
        this.vgs = vgs;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Fruit f = vgs.getFruitCB();
        if(((Component)e.getSource()).getName().equals("PlusCB")) 
            m.updateP(f);
        else
            m.updateM(); 
    }
    public void setModele(ModelePanier m){
        this.m = m;
    }
    public void setVue(VueGSwing vgs){
        this.vgs = vgs;
    }
}

