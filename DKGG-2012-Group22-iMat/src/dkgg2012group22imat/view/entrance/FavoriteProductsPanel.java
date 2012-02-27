/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FavoriteProductPanel.java
 *
 * Created on Feb 17, 2012, 1:18:04 PM
 */
package dkgg2012group22imat.view.entrance;

import dkgg2012group22imat.model.FavoriteListener;
import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.ProductsPanel;
import java.awt.BorderLayout;
import java.util.EventObject;

/**
 *
 * @author jonas
 */
public class FavoriteProductsPanel extends javax.swing.JPanel implements FavoriteListener {

    private ProductsPanel pp;

    public FavoriteProductsPanel() {
        initComponents();
        Model m = Model.getInstance();
        pp = new ProductsPanel(m.getFavorites(), 3);
        m.addEventListener(this);
        add(pp, BorderLayout.CENTER);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(dkgg2012group22imat.view.DKGG2012Group22iMatApp.class).getContext().getResourceMap(FavoriteProductsPanel.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setName("Form"); // NOI18N
        setOpaque(false);
        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void handleFavoriteEvent(EventObject e) {
        pp.setList(Model.getInstance().getFavorites());
    }
}
