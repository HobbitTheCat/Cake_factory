/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fr.ufrsciencestech.panier.View;


import fr.ufrsciencestech.panier.Model.fruit.Fruit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 *
 * @author Ostronix
 */
public class ViewBoycott extends javax.swing.JFrame {

    private Set<String> origineF;
    private Set<String> origineB;
    private List<Fruit> BoycottF;
    
    public ViewBoycott() {
        initComponents();
        origineF = new HashSet<>();
        origineB = new HashSet<>();
        BoycottF = new ArrayList<>();
        FillOrigineF();
        FillOrigineB();
        FillTextArea();
    }

    public void FillOrigineF(){
        CBboyplus.removeAllItems();
        int n = ViewMenu.lst_instance.size();
        for(int i=0;i<n;i++){
            String o = ViewMenu.lst_instance.get(i).getOriginCountry();
            origineF.add(o);
        }
        for(String o : origineF){
            CBboyplus.addItem(o);
        }
    }
    
    public void FillOrigineB(){
        CBboymoins.removeAllItems();
        for(String o : origineB){
            CBboymoins.addItem(o);
        }
    }
    
    public void FillTextArea(){
        jTextArea1.setText("Voici les origines Boycott\n");
        for(String o : origineB){
            jTextArea1.append("- "+o+"\n");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Brefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        CBboyplus = new javax.swing.JComboBox<>();
        BvaliderPlus = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        CBboymoins = new javax.swing.JComboBox<>();
        Bexit = new javax.swing.JButton();
        BvaliderMoins = new javax.swing.JButton();
        Brefresh1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(1400, 0));
        setPreferredSize(new java.awt.Dimension(500, 350));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Origines Boycottées");

        Brefresh.setBackground(new java.awt.Color(0, 51, 153));
        Brefresh.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        Brefresh.setForeground(new java.awt.Color(255, 255, 255));
        Brefresh.setText("⟳");

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setHorizontalScrollBar(null);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Boycotter");

        BvaliderPlus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BvaliderPlus.setText("Valider");
        BvaliderPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BvaliderPlusActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Arrêter le boycott");

        Bexit.setBackground(new java.awt.Color(255, 0, 0));
        Bexit.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        Bexit.setForeground(new java.awt.Color(255, 255, 255));
        Bexit.setText("X");
        Bexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BexitActionPerformed(evt);
            }
        });

        BvaliderMoins.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BvaliderMoins.setText("Valider");
        BvaliderMoins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BvaliderMoinsActionPerformed(evt);
            }
        });

        Brefresh1.setBackground(new java.awt.Color(0, 51, 153));
        Brefresh1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        Brefresh1.setForeground(new java.awt.Color(255, 255, 255));
        Brefresh1.setText("⟳");
        Brefresh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Brefresh1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Brefresh1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Bexit))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(CBboymoins, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBboyplus, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(BvaliderMoins, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(BvaliderPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Brefresh)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Bexit)
                    .addComponent(Brefresh1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CBboyplus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BvaliderPlus)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CBboymoins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BvaliderMoins)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Brefresh)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BexitActionPerformed
        setVisible(false);
    }//GEN-LAST:event_BexitActionPerformed

    private void BvaliderPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BvaliderPlusActionPerformed
        String o = (String)CBboyplus.getSelectedItem();
        int n = ViewMenu.lst_instance.size();
        for(int i=0;i<n;i++){
            Fruit f = ViewMenu.lst_instance.get(i);
            if(f.getOriginCountry().equals(o)){
                BoycottF.add(f);
            }
        }
        for(int i=0;i<BoycottF.size();i++){
            ViewMenu.lst_instance.remove(BoycottF.get(i));
        }
        origineB.add(o);
        origineF.remove(o);
        FillTextArea();
        FillOrigineF();
        FillOrigineB();
    }//GEN-LAST:event_BvaliderPlusActionPerformed

    private void BvaliderMoinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BvaliderMoinsActionPerformed
        String o = (String)CBboymoins.getSelectedItem();
        List<Fruit> temp = new ArrayList<>();
        int n = BoycottF.size();
        for(int i=0;i<n;i++){
            Fruit f = BoycottF.get(i);
            if(f.getOriginCountry().equals(o)){
                ViewMenu.lst_instance.add(f);
                temp.add(f);
            }
        }
        for(int i=0;i<temp.size();i++){
            BoycottF.remove(temp.get(i));
        }
        origineB.remove(o);
        origineF.add(o);
        FillTextArea();
        FillOrigineF();
        FillOrigineB();
    }//GEN-LAST:event_BvaliderMoinsActionPerformed

    private void Brefresh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Brefresh1ActionPerformed
        FillOrigineF();
    }//GEN-LAST:event_Brefresh1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewBoycott.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBoycott.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBoycott.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBoycott.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBoycott().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bexit;
    private javax.swing.JButton Brefresh;
    private javax.swing.JButton Brefresh1;
    private javax.swing.JButton BvaliderMoins;
    private javax.swing.JButton BvaliderPlus;
    private javax.swing.JComboBox<String> CBboymoins;
    private javax.swing.JComboBox<String> CBboyplus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
