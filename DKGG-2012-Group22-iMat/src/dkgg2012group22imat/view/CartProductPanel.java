/*
 * ItemPanel.java
 *
 * Created on Feb 17, 2012, 2:26:49 PM
 */
package dkgg2012group22imat.view;

import dkgg2012group22imat.controller.CartProductController;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author jonas
 */
public class CartProductPanel extends javax.swing.JPanel {

    CartProductController controller;

    /** Creates new form ItemPanel */
    public CartProductPanel(Product p) {
        initComponents();
        controller = new CartProductController(p, this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        productNameLabel = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        iconLabel = new javax.swing.JLabel();
        quantityComboBox = new javax.swing.JComboBox();
        priceLabel = new javax.swing.JLabel();
        favoriteToggleButton = new javax.swing.JToggleButton();

        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMaximumSize(new java.awt.Dimension(200, 200));
        setMinimumSize(new java.awt.Dimension(100, 100));
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(150, 150));
        setRequestFocusEnabled(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(dkgg2012group22imat.view.DKGG2012Group22iMatApp.class).getContext().getResourceMap(CartProductPanel.class);
        productNameLabel.setText(resourceMap.getString("productNameLabel.text")); // NOI18N
        productNameLabel.setName("productNameLabel"); // NOI18N

        deleteButton.setText(resourceMap.getString("deleteButton.text")); // NOI18N
        deleteButton.setName("deleteButton"); // NOI18N
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        iconLabel.setText(resourceMap.getString("iconLabel.text")); // NOI18N
        iconLabel.setName("iconLabel"); // NOI18N

        quantityComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" }));
        quantityComboBox.setName("quantityComboBox"); // NOI18N

        priceLabel.setText(resourceMap.getString("priceLabel.text")); // NOI18N
        priceLabel.setName("priceLabel"); // NOI18N

        favoriteToggleButton.setText(resourceMap.getString("favoriteToggleButton.text")); // NOI18N
        favoriteToggleButton.setName("favoriteToggleButton"); // NOI18N
        favoriteToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                favoriteToggleButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(quantityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(productNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                    .addComponent(iconLabel))
                                .addGap(54, 54, 54))
                            .addComponent(priceLabel))
                        .addContainerGap())
                    .addComponent(favoriteToggleButton, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(productNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteButton)))
                    .addComponent(favoriteToggleButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
    controller.removeFromCart();
}//GEN-LAST:event_deleteButtonActionPerformed

private void favoriteToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_favoriteToggleButtonActionPerformed
    controller.favorize();
}//GEN-LAST:event_favoriteToggleButtonActionPerformed

private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
    controller.hooverd();
}//GEN-LAST:event_formMouseEntered

private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
    controller.dehoover();
}//GEN-LAST:event_formMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    public javax.swing.JToggleButton favoriteToggleButton;
    public javax.swing.JLabel iconLabel;
    public javax.swing.JLabel priceLabel;
    public javax.swing.JLabel productNameLabel;
    private javax.swing.JComboBox quantityComboBox;
    // End of variables declaration//GEN-END:variables

    public int getAmount() {
        return quantityComboBox.getSelectedIndex();
    }
}