/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CartsPanel.java
 *
 * Created on Feb 26, 2012, 7:51:00 PM
 */
package dkgg2012group22imat.view.entrance.carts;

import dkgg2012group22imat.controller.entrance.CartsPanelController;
import dkgg2012group22imat.controller.entrance.SuperCartsPanelController;
import dkgg2012group22imat.model.SavedCart;
import java.util.List;

/**
 *
 * @author jonas
 */
public class CartsPanel extends javax.swing.JPanel {

    CartsPanelController controller;

    /** Creates new form CartsPanel */
    public CartsPanel(List<SavedCart> carts, SuperCartsPanelController parent) {
        initComponents();
        controller = new CartsPanelController(carts, parent, this);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(dkgg2012group22imat.view.DKGG2012Group22iMatApp.class).getContext().getResourceMap(CartsPanel.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setName("Form"); // NOI18N
        setOpaque(false);
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
