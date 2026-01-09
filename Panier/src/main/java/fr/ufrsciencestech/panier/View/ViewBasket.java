package fr.ufrsciencestech.panier.View;

import fr.ufrsciencestech.panier.Controller.Controleur;
import fr.ufrsciencestech.panier.Model.Basket;
import fr.ufrsciencestech.panier.Model.fruit.Fruit;
import java.beans.PropertyChangeEvent;

public class ViewBasket extends javax.swing.JFrame implements ViewG {

    
    public ViewBasket() {
        initComponents();
        FillComboBoxPlus();
        Bplus.setName("Plus");
        Bmoins.setName("Moins");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TApanier = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        Bexit = new javax.swing.JButton();
        Bmoins = new javax.swing.JButton();
        CBmoins = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        Bplus = new javax.swing.JButton();
        CBplus = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        Brefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(800, 0));
        setPreferredSize(new java.awt.Dimension(600, 500));

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setHorizontalScrollBar(null);

        TApanier.setColumns(20);
        TApanier.setRows(5);
        jScrollPane1.setViewportView(TApanier);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Voici le panier : ");

        Bexit.setBackground(new java.awt.Color(255, 0, 0));
        Bexit.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        Bexit.setForeground(new java.awt.Color(255, 255, 255));
        Bexit.setText("X");
        Bexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BexitActionPerformed(evt);
            }
        });

        Bmoins.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Bmoins.setText("-");
        Bmoins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BmoinsActionPerformed(evt);
            }
        });

        CBmoins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBmoinsActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Retirer un fruit");

        Bplus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Bplus.setText("+");
        Bplus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BplusActionPerformed(evt);
            }
        });

        CBplus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBplusActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Ajouter un fruit");

        Brefresh.setBackground(new java.awt.Color(0, 51, 153));
        Brefresh.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        Brefresh.setForeground(new java.awt.Color(255, 255, 255));
        Brefresh.setText("⟳");
        Brefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CBmoins, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(Bmoins)))
                        .addContainerGap(59, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(Bplus))
                            .addComponent(jLabel3)
                            .addComponent(CBplus, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Brefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Bexit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Bexit)
                    .addComponent(Brefresh))
                .addGap(58, 58, 58)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(CBplus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Bplus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CBmoins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Bmoins)
                .addGap(103, 103, 103))
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
	/*System.out.println("Change " + evt.getPropertyName());
	System.out.println("\t(" + evt.getOldValue() + 
							" -> " + evt.getNewValue() + ")");
	System.out.println("Property in object " + evt.getSource());
        */
        Basket b = (Basket) evt.getSource();
        if(b.isEmpty())
            TApanier.setText("Panier de 0 fruits\n");
        else
            TApanier.setText(b.toString());
        FillComboBoxPlus();
        FillComboBoxMoins(b);
    }

    
    private void BexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BexitActionPerformed
        setVisible(false);
    }//GEN-LAST:event_BexitActionPerformed

    private void BplusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BplusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BplusActionPerformed

    private void CBmoinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBmoinsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBmoinsActionPerformed

    private void CBplusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBplusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBplusActionPerformed

    private void BrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrefreshActionPerformed
        FillComboBoxPlus();
    }//GEN-LAST:event_BrefreshActionPerformed

    private void BmoinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BmoinsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BmoinsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bexit;
    private javax.swing.JButton Bmoins;
    private javax.swing.JButton Bplus;
    private javax.swing.JButton Brefresh;
    private javax.swing.JComboBox<String> CBmoins;
    private javax.swing.JComboBox<String> CBplus;
    private javax.swing.JTextArea TApanier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void addControleur(Controleur c) {
       Bmoins.addActionListener(c);
       Bplus.addActionListener(c);

    }
    public javax.swing.JComboBox getCBplus(){
        return CBplus;
    }
    public javax.swing.JComboBox getCBmoins(){
        return CBmoins;
    }

    private void FillComboBoxPlus() {
        CBplus.removeAllItems();
        int n = ViewMenu.lst_instance.size();
        for(int i=0;i<n;i++){
            String o = ViewMenu.lst_instance.get(i).getName();
            CBplus.addItem(o);
        }
    }

    private void FillComboBoxMoins(Basket b) {
        CBmoins.removeAllItems();
        int n = b.getNbFruits();
        for(int i=0;i<n;i++){
            String o = b.getFruit(i).getName();
            CBmoins.addItem(o);
        }
    }
}
