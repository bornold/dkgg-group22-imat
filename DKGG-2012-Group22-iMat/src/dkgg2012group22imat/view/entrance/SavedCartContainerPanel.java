/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SavedCartContainer.java
 *
 * Created on Feb 23, 2012, 3:35:14 PM
 */
package dkgg2012group22imat.view.entrance;

import dkgg2012group22imat.controller.entrance.SavedCartContainerController;
import dkgg2012group22imat.controller.entrance.SavedCartInterface;
import java.util.List;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author jonas
 */
public class SavedCartContainerPanel extends javax.swing.JPanel {

    SavedCartContainerController controller;

    /** Creates new form SavedCartContainer */
    public SavedCartContainerPanel(SavedCartInterface parent, List<ShoppingItem> _items, String name) {
        initComponents();
        controller = new SavedCartContainerController(parent, _items, name, this);
        setPreferredSize(controller.getSize());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cartNameLabel = new javax.swing.JLabel();
        cartPriceLabel = new javax.swing.JLabel();
        hideButton = new javax.swing.JButton();
        addAllButton = new javax.swing.JButton();
        itemsListScrollPane = new javax.swing.JScrollPane();
        innerPanel = new javax.swing.JPanel();

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(dkgg2012group22imat.view.DKGG2012Group22iMatApp.class).getContext().getResourceMap(SavedCartContainerPanel.class);
        cartNameLabel.setText(resourceMap.getString("cartNameLabel.text")); // NOI18N
        cartNameLabel.setName("cartNameLabel"); // NOI18N

        cartPriceLabel.setText(resourceMap.getString("cartPriceLabel.text")); // NOI18N
        cartPriceLabel.setName("cartPriceLabel"); // NOI18N

        hideButton.setText(resourceMap.getString("hideButton.text")); // NOI18N
        hideButton.setName("hideButton"); // NOI18N
        hideButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideButtonActionPerformed(evt);
            }
        });

        addAllButton.setText(resourceMap.getString("addAllButton.text")); // NOI18N
        addAllButton.setName("addAllButton"); // NOI18N
        addAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAllButtonActionPerformed(evt);
            }
        });

        itemsListScrollPane.setName("itemsListScrollPane"); // NOI18N

        innerPanel.setName("innerPanel"); // NOI18N
        innerPanel.setLayout(new java.awt.GridLayout(0, 1));
        itemsListScrollPane.setViewportView(innerPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cartNameLabel)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cartPriceLabel))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hideButton)
                .addGap(18, 18, 18)
                .addComponent(addAllButton))
            .addComponent(itemsListScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cartNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartPriceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hideButton)
                    .addComponent(addAllButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemsListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void hideButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hideButtonActionPerformed
    controller.hide();
}//GEN-LAST:event_hideButtonActionPerformed

private void addAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAllButtonActionPerformed
    controller.addAll();
}//GEN-LAST:event_addAllButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAllButton;
    public javax.swing.JLabel cartNameLabel;
    public javax.swing.JLabel cartPriceLabel;
    private javax.swing.JButton hideButton;
    public javax.swing.JPanel innerPanel;
    private javax.swing.JScrollPane itemsListScrollPane;
    // End of variables declaration//GEN-END:variables
}
