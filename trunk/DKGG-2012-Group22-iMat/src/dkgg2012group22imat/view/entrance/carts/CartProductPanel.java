/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SavedCartPanel.java
 *
 * Created on Feb 22, 2012, 1:55:50 PM
 */
package dkgg2012group22imat.view.entrance.carts;

import dkgg2012group22imat.controller.entrance.CartProductController;
import dkgg2012group22imat.model.IMatUtilities;
import dkgg2012group22imat.view.DKGG2012Group22iMatApp;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import org.jdesktop.application.ResourceMap;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author jonas
 */
public class CartProductPanel extends javax.swing.JPanel {

    private CartProductController controller;
    private ShoppingItem shoppingItem;

    /** Creates new form SavedCartPanel */
    public CartProductPanel(ShoppingItem si) {
        initComponents();
        controller = new CartProductController(si, this);
        addButton.setVisible(false);
        this.shoppingItem=si;
    }
    
    public ShoppingItem getShoppingItem() {
        return this.shoppingItem;
    }

    @Override
    public void paintComponent(Graphics g) {
//        ResourceMap resourceMap = DKGG2012Group22iMatApp.getApplication().getContext().getResourceMap(CartProductPanel.class);

        IMatUtilities.drawTiled(g, this.getSize(), new ImageIcon(this.getClass().getResource("/dkgg2012group22imat/resources/gradient_cartproduct.png")));

        g.setColor(new Color(204, 204, 204));
        g.drawRect(-1, -1, this.getWidth() + 1, this.getHeight());//top and bottom border
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        informationLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        icon = new dkgg2012group22imat.view.ProductImageLabel();

        setMaximumSize(new java.awt.Dimension(250, 80));
        setMinimumSize(new java.awt.Dimension(250, 80));
        setName("Form"); // NOI18N
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(250, 80));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        setLayout(null);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(dkgg2012group22imat.view.DKGG2012Group22iMatApp.class).getContext().getResourceMap(CartProductPanel.class);
        nameLabel.setFont(resourceMap.getFont("nameLabel.font")); // NOI18N
        nameLabel.setText(resourceMap.getString("nameLabel.text")); // NOI18N
        nameLabel.setName("nameLabel"); // NOI18N
        add(nameLabel);
        nameLabel.setBounds(80, 10, 160, 22);

        informationLabel.setText(resourceMap.getString("informationLabel.text")); // NOI18N
        informationLabel.setName("informationLabel"); // NOI18N
        add(informationLabel);
        informationLabel.setBounds(80, 30, 160, 16);

        addButton.setIcon(resourceMap.getIcon("addButton.icon")); // NOI18N
        addButton.setText(resourceMap.getString("addButton.text")); // NOI18N
        addButton.setBorderPainted(false);
        addButton.setName("addButton"); // NOI18N
        addButton.setPressedIcon(resourceMap.getIcon("addButton.pressedIcon")); // NOI18N
        addButton.setRolloverIcon(resourceMap.getIcon("addButton.rolloverIcon")); // NOI18N
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addButtonMouseEntered(evt);
            }
        });
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        add(addButton);
        addButton.setBounds(165, 45, 80, 30);

        icon.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("icon.border.lineColor"))); // NOI18N
        icon.setText(resourceMap.getString("icon.text")); // NOI18N
        icon.setName("icon"); // NOI18N
        add(icon);
        icon.setBounds(10, 10, 60, 53);
    }// </editor-fold>//GEN-END:initComponents

private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
    addButton.setVisible(true);
}//GEN-LAST:event_formMouseEntered

private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
    addButton.setVisible(false);
}//GEN-LAST:event_formMouseExited

private void addButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseEntered
    addButton.setVisible(true);
}//GEN-LAST:event_addButtonMouseEntered

private void addButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseExited
    addButton.setVisible(false);
}//GEN-LAST:event_addButtonMouseExited

private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    controller.addItem();
}//GEN-LAST:event_addButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton addButton;
    public dkgg2012group22imat.view.ProductImageLabel icon;
    public javax.swing.JLabel informationLabel;
    public javax.swing.JLabel nameLabel;
    // End of variables declaration//GEN-END:variables
}
