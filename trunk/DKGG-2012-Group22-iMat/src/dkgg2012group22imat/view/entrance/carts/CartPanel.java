/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CartPanel.java
 *
 * Created on Feb 26, 2012, 7:51:26 PM
 */
package dkgg2012group22imat.view.entrance.carts;

import dkgg2012group22imat.model.SavedCart;
import dkgg2012group22imat.view.DKGG2012Group22iMatApp;
import dkgg2012group22imat.view.IMatUtilities;
import java.awt.Color;
import java.awt.Graphics;
import org.jdesktop.application.ResourceMap;

/**
 *
 * @author jonas
 */
public class CartPanel extends javax.swing.JPanel {

    CartPanelController controller;

    /** Creates new form CartPanel */
    public CartPanel(SavedCart sv, CartsPanelController parent) {
        initComponents();
        controller = new CartPanelController(sv, parent, this);
        showButton.setVisible(false);
        addAllButton.setVisible(false);
    }

    private void buttonVisible() {
        showButton.setVisible(!showButton.isVisible());
        addAllButton.setVisible(!addAllButton.isVisible());
    }
    
    @Override
    public void paintComponent(Graphics g) {
        ResourceMap resourceMap = DKGG2012Group22iMatApp.getApplication().getContext().getResourceMap(CartPanel.class);

        IMatUtilities.drawTiled(g, this.getSize(), resourceMap.getImageIcon("CartPanel.background"));

        g.setColor(new Color(204, 204, 204));
        g.drawRect(-1, -1, this.getWidth() + 1, this.getHeight());//top and bottom border
        super.paintComponent(g);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cartName = new javax.swing.JLabel();
        informationLabel = new javax.swing.JLabel();
        showButton = new javax.swing.JButton();
        addAllButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        icon1 = new dkgg2012group22imat.view.ProductImageLabel();
        icon2 = new dkgg2012group22imat.view.ProductImageLabel();
        icon3 = new dkgg2012group22imat.view.ProductImageLabel();
        icon4 = new dkgg2012group22imat.view.ProductImageLabel();

        setMaximumSize(new java.awt.Dimension(250, 85));
        setMinimumSize(new java.awt.Dimension(250, 85));
        setName("Form"); // NOI18N
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(250, 85));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(dkgg2012group22imat.view.DKGG2012Group22iMatApp.class).getContext().getResourceMap(CartPanel.class);
        cartName.setFont(resourceMap.getFont("cartName.font")); // NOI18N
        cartName.setForeground(resourceMap.getColor("cartName.foreground")); // NOI18N
        cartName.setText(resourceMap.getString("cartName.text")); // NOI18N
        cartName.setName("cartName"); // NOI18N
        add(cartName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        informationLabel.setFont(resourceMap.getFont("informationLabel.font")); // NOI18N
        informationLabel.setForeground(resourceMap.getColor("informationLabel.foreground")); // NOI18N
        informationLabel.setText(resourceMap.getString("informationLabel.text")); // NOI18N
        informationLabel.setName("informationLabel"); // NOI18N
        add(informationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        showButton.setIcon(resourceMap.getIcon("showButton.icon")); // NOI18N
        showButton.setText(resourceMap.getString("showButton.text")); // NOI18N
        showButton.setBorderPainted(false);
        showButton.setName("showButton"); // NOI18N
        showButton.setPressedIcon(resourceMap.getIcon("showButton.pressedIcon")); // NOI18N
        showButton.setRolloverIcon(resourceMap.getIcon("showButton.rolloverIcon")); // NOI18N
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
        add(showButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 10, 50, 30));

        addAllButton.setIcon(resourceMap.getIcon("addAllButton.icon")); // NOI18N
        addAllButton.setText(resourceMap.getString("addAllButton.text")); // NOI18N
        addAllButton.setBorderPainted(false);
        addAllButton.setName("addAllButton"); // NOI18N
        addAllButton.setPressedIcon(resourceMap.getIcon("addAllButton.pressedIcon")); // NOI18N
        addAllButton.setRolloverIcon(resourceMap.getIcon("addAllButton.rolloverIcon")); // NOI18N
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
        add(addAllButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 48, 110, 30));

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(1, 4, 2, 0));

        icon1.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("icon1.border.lineColor"))); // NOI18N
        icon1.setText(resourceMap.getString("icon1.text")); // NOI18N
        icon1.setName("icon1"); // NOI18N
        jPanel1.add(icon1);

        icon2.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("icon2.border.lineColor"))); // NOI18N
        icon2.setText(resourceMap.getString("icon2.text")); // NOI18N
        icon2.setName("icon2"); // NOI18N
        jPanel1.add(icon2);

        icon3.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("icon3.border.lineColor"))); // NOI18N
        icon3.setText(resourceMap.getString("icon3.text")); // NOI18N
        icon3.setName("icon3"); // NOI18N
        jPanel1.add(icon3);

        icon4.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("icon4.border.lineColor"))); // NOI18N
        icon4.setText(resourceMap.getString("icon4.text")); // NOI18N
        icon4.setName("icon4"); // NOI18N
        jPanel1.add(icon4);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 52, 125, 23));
    }// </editor-fold>//GEN-END:initComponents

private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
    buttonVisible();
}//GEN-LAST:event_formMouseEntered

private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
    buttonVisible();
}//GEN-LAST:event_formMouseExited

private void showButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showButtonMouseEntered
    buttonVisible();
}//GEN-LAST:event_showButtonMouseEntered

private void addAllButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addAllButtonMouseEntered
    buttonVisible();
}//GEN-LAST:event_addAllButtonMouseEntered

private void addAllButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addAllButtonMouseExited
    buttonVisible();
}//GEN-LAST:event_addAllButtonMouseExited

private void showButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showButtonMouseExited
    buttonVisible();
}//GEN-LAST:event_showButtonMouseExited

private void addAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAllButtonActionPerformed
controller.addAll();
}//GEN-LAST:event_addAllButtonActionPerformed

private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
controller.showThis();
}//GEN-LAST:event_showButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAllButton;
    public javax.swing.JLabel cartName;
    public dkgg2012group22imat.view.ProductImageLabel icon1;
    public dkgg2012group22imat.view.ProductImageLabel icon2;
    public dkgg2012group22imat.view.ProductImageLabel icon3;
    public dkgg2012group22imat.view.ProductImageLabel icon4;
    public javax.swing.JLabel informationLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton showButton;
    // End of variables declaration//GEN-END:variables
}