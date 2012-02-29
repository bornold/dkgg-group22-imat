/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CartWithProductsPanel.java
 *
 * Created on 2012-feb-22, 13:54:38
 */
package dkgg2012group22imat.view;

import dkgg2012group22imat.controller.CartWithProductsPanelController;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author magnushuttu
 */
public class CartWithProductsPanel extends javax.swing.JPanel {

    CartWithProductsPanelController controller;
    /** Creates new form CartWithProductsPanel */
    public CartWithProductsPanel() {
        initComponents();
        controller = new CartWithProductsPanelController(this);
    }
    
    public JPanel getProductListPanel() {
        return jPanel1;
    }
    public JScrollPane getScrollPane() {
        return jScrollPane1;
    }
    
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(dkgg2012group22imat.view.DKGG2012Group22iMatApp.class).getContext().getResourceMap(CartWithProductsPanel.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(270, 500));
        setSize(new java.awt.Dimension(270, 500));
        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jPanel1.setBackground(resourceMap.getColor("jPanel1.background")); // NOI18N
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
