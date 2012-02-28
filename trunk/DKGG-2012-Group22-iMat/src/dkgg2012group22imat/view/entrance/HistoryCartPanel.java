/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * HistoryCartPanel.java
 *
 * Created on Feb 21, 2012, 11:56:54 AM
 */
package dkgg2012group22imat.view.entrance;

import dkgg2012group22imat.controller.entrance.HistoryCartController;
import dkgg2012group22imat.controller.entrance.HistoryCartsController;
import se.chalmers.ait.dat215.project.Order;

/**
 *
 * @author jonas
 */
public class HistoryCartPanel extends javax.swing.JPanel {

    private HistoryCartController controller;

    /** Creates new form HistoryCartPanel */
    public HistoryCartPanel(Order o, HistoryCartsController parent) {
        initComponents();
        controller = new HistoryCartController(o, parent, this);
        showButton.setVisible(false);
        addAllButton.setVisible(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateLabel = new javax.swing.JLabel();
        informationLabel = new javax.swing.JLabel();
        showButton = new javax.swing.JButton();
        addAllButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        icon1 = new javax.swing.JLabel();
        icon2 = new javax.swing.JLabel();
        icon3 = new javax.swing.JLabel();
        icon4 = new javax.swing.JLabel();

        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(250, 90));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(dkgg2012group22imat.view.DKGG2012Group22iMatApp.class).getContext().getResourceMap(HistoryCartPanel.class);
        dateLabel.setText(resourceMap.getString("dateLabel.text")); // NOI18N
        dateLabel.setName("dateLabel"); // NOI18N
        add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        informationLabel.setText(resourceMap.getString("informationLabel.text")); // NOI18N
        informationLabel.setName("informationLabel"); // NOI18N
        add(informationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        showButton.setText(resourceMap.getString("showButton.text")); // NOI18N
        showButton.setName("showButton"); // NOI18N
        showButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                showButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                showButtonMouseEntered(evt);
            }
        });
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });
        add(showButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        addAllButton.setText(resourceMap.getString("addAllButton.text")); // NOI18N
        addAllButton.setName("addAllButton"); // NOI18N
        addAllButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addAllButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addAllButtonMouseEntered(evt);
            }
        });
        addAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAllButtonActionPerformed(evt);
            }
        });
        add(addAllButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        icon1.setText(resourceMap.getString("icon1.text")); // NOI18N
        icon1.setName("icon1"); // NOI18N
        jPanel1.add(icon1);

        icon2.setText(resourceMap.getString("icon2.text")); // NOI18N
        icon2.setName("icon2"); // NOI18N
        jPanel1.add(icon2);

        icon3.setText(resourceMap.getString("icon3.text")); // NOI18N
        icon3.setName("icon3"); // NOI18N
        jPanel1.add(icon3);

        icon4.setText(resourceMap.getString("icon4.text")); // NOI18N
        icon4.setName("icon4"); // NOI18N
        jPanel1.add(icon4);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 100, 30));
    }// </editor-fold>//GEN-END:initComponents

private void addAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAllButtonActionPerformed
    controller.addAll();
}//GEN-LAST:event_addAllButtonActionPerformed

private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
    showButton.setVisible(true);
    addAllButton.setVisible(true);
}//GEN-LAST:event_formMouseEntered

private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
    showButton.setVisible(false);
    addAllButton.setVisible(false);
}//GEN-LAST:event_formMouseExited

private void showButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showButtonMouseEntered
    showButton.setVisible(true);
    addAllButton.setVisible(true);
}//GEN-LAST:event_showButtonMouseEntered

private void showButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showButtonMouseExited
    showButton.setVisible(false);
    addAllButton.setVisible(false);
}//GEN-LAST:event_showButtonMouseExited

private void addAllButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addAllButtonMouseEntered
    showButton.setVisible(true);
    addAllButton.setVisible(true);
}//GEN-LAST:event_addAllButtonMouseEntered

private void addAllButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addAllButtonMouseExited
    showButton.setVisible(false);
    addAllButton.setVisible(false);
}//GEN-LAST:event_addAllButtonMouseExited

private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
    controller.show();
}//GEN-LAST:event_showButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAllButton;
    public javax.swing.JLabel dateLabel;
    public javax.swing.JLabel icon1;
    public javax.swing.JLabel icon2;
    public javax.swing.JLabel icon3;
    public javax.swing.JLabel icon4;
    public javax.swing.JLabel informationLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton showButton;
    // End of variables declaration//GEN-END:variables
}