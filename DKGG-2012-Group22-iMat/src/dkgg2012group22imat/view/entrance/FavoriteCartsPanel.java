/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FavoriteCartPanel.java
 *
 * Created on Feb 17, 2012, 1:15:48 PM
 */
package dkgg2012group22imat.view.entrance;

import dkgg2012group22imat.controller.entrance.FavoriteCartsController;
import dkgg2012group22imat.controller.entrance.SavedCartSuperController;

/**
 *
 * @author jonas
 */
public class FavoriteCartsPanel extends javax.swing.JPanel {

    /** Creates new form FavoriteCartPanel */
    private FavoriteCartsController controller;
    public FavoriteCartsPanel(SavedCartSuperController parent) {
        initComponents();
        controller = new FavoriteCartsController(parent, this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setName("Form"); // NOI18N
        setLayout(new java.awt.GridLayout(0, 1));
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
