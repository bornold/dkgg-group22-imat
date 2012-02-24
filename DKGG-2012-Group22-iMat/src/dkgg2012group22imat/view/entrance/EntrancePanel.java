/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EntrancePanel.java
 *
 * Created on Feb 19, 2012, 9:29:52 PM
 */
package dkgg2012group22imat.view.entrance;

import dkgg2012group22imat.controller.entrance.EntrancePanelController;

/**
 *
 * @author jonas
 */
public class EntrancePanel extends javax.swing.JPanel {
EntrancePanelController controller;

    /** Creates new form EntrancePanel */
    public EntrancePanel() {
        initComponents();
        controller = new EntrancePanelController(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spotlightProductsPanel1 = new dkgg2012group22imat.view.entrance.SpotlightProductsPanel();
        favoriteProductsPanel1 = new dkgg2012group22imat.view.entrance.FavoriteProductsPanel();
        savedCartSuperPanel1 = new dkgg2012group22imat.view.entrance.SavedCartSuperPanel();

        setName("Form"); // NOI18N

        spotlightProductsPanel1.setName("spotlightProductsPanel1"); // NOI18N

        favoriteProductsPanel1.setName("favoriteProductsPanel1"); // NOI18N

        savedCartSuperPanel1.setName("savedCartSuperPanel1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(savedCartSuperPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(favoriteProductsPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                    .addComponent(spotlightProductsPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(savedCartSuperPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(spotlightProductsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(favoriteProductsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private dkgg2012group22imat.view.entrance.FavoriteProductsPanel favoriteProductsPanel1;
    private dkgg2012group22imat.view.entrance.SavedCartSuperPanel savedCartSuperPanel1;
    private dkgg2012group22imat.view.entrance.SpotlightProductsPanel spotlightProductsPanel1;
    // End of variables declaration//GEN-END:variables
}
