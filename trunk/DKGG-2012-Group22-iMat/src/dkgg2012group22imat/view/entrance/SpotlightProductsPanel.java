/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SpotlightProductPanel.java
 *
 * Created on Feb 17, 2012, 1:19:09 PM
 */
package dkgg2012group22imat.view.entrance;

import dkgg2012group22imat.controller.entrance.SpotlightProductPanelController;

/**
 *
 * @author jonas
 */
public class SpotlightProductsPanel extends javax.swing.JPanel {

    SpotlightProductPanelController controller;
    /** Creates new form SpotlightProductPanel */
    public SpotlightProductsPanel() {
        initComponents();
        //((java.awt.GridLayout)this.getLayout());
        controller = new SpotlightProductPanelController(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(dkgg2012group22imat.view.DKGG2012Group22iMatApp.class).getContext().getResourceMap(SpotlightProductsPanel.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setMaximumSize(new java.awt.Dimension(200, 200));
        setName("Form"); // NOI18N
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
