/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CategoryPanel.java
 *
 * Created on Feb 17, 2012, 1:19:54 PM
 */
package dkgg2012group22imat.view.shop;

import dkgg2012group22imat.controller.shop.CategoriesController;
import javax.swing.JPanel;

/**
 *
 * @author jonas
 */
public class CategoriesPanel extends javax.swing.JPanel {
    
    CategoriesController controller;

    /** Creates new form CategoryPanel */
    public CategoriesPanel() {
        initComponents();
        this.controller = new CategoriesController(this);
    }
    
    public JPanel getCategoryListPanel() {
        return this;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMaximumSize(new java.awt.Dimension(250, 32767));
        setMinimumSize(new java.awt.Dimension(250, 0));
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(250, 0));
        setSize(new java.awt.Dimension(250, 0));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
