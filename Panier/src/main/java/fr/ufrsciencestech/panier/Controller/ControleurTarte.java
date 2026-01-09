/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.Controller;

import fr.ufrsciencestech.panier.Model.Basket;
import fr.ufrsciencestech.panier.Model.cake.CakeBuilder;
import fr.ufrsciencestech.panier.Model.fruit.Fruit;
import fr.ufrsciencestech.panier.Model.fruit.SimpleFruit;
import fr.ufrsciencestech.panier.View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ostronix
 */
public class ControleurTarte implements ActionListener {

    private CakeBuilder cb;
    private ViewTarte vt;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String baseLayer = vt.getTFbaselayer().getText();
        String creamLayer = vt.getTFcreamlayer().getText();
        Fruit fruitLayer = ViewMenu.lst_instance.get(vt.getComboBox().getSelectedIndex());
        String toppingLayer = vt.getTFtoppinglayer().getText();
        int prixbaseLayer = (int)vt.getSbaselayer().getValue();
        int prixcreamLayer = (int)vt.getScreamlayer().getValue();
        int prixfruitLayer = (int)vt.getSfruitlayer().getValue();
        int prixtoppingLayer = (int)vt.getStoppinglayer().getValue();
        
        cb.addBaseLayer(baseLayer, prixbaseLayer);
        cb.addCreamLayer(creamLayer, prixcreamLayer);
        cb.addFruitLayer(fruitLayer);
        cb.addToppingLayer(toppingLayer, prixtoppingLayer);
        
        
        }
    public void setVue(ViewG vg){
        this.vt = (ViewTarte) vg;
    }
    public void setTarte(CakeBuilder cb){
        this.cb = cb;
    }
    
}
