/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SavedCartSuperPanel.java
 *
 * Created on Feb 24, 2012, 10:43:55 AM
 */
package dkgg2012group22imat.view.entrance;

import dkgg2012group22imat.controller.entrance.SavedCartSuperController;

/**
 *
 * @author jonas
 */
public class SavedCartSuperPanel extends javax.swing.JPanel {

    private SavedCartSuperController controller; 
    /** Creates new form SavedCartSuperPanel */
    public SavedCartSuperPanel() {
        initComponents();
        controller = new SavedCartSuperController(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        favoriteScrollPane = new javax.swing.JScrollPane();
        favoritePanel = new javax.swing.JPanel();
        historyScrollPane = new javax.swing.JScrollPane();
        historyPanel = new javax.swing.JPanel();

        setMinimumSize(new java.awt.Dimension(250, 0));
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(270, 0));
        setLayout(new java.awt.GridLayout(2, 0));

        favoriteScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        favoriteScrollPane.setName("favoriteScrollPane"); // NOI18N
        favoriteScrollPane.setPreferredSize(new java.awt.Dimension(270, 0));

        favoritePanel.setName("favoritePanel"); // NOI18N
        favoriteScrollPane.setViewportView(favoritePanel);

        add(favoriteScrollPane);

        historyScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        historyScrollPane.setName("historyScrollPane"); // NOI18N
        historyScrollPane.setPreferredSize(new java.awt.Dimension(270, 0));

        historyPanel.setName("historyPanel"); // NOI18N
        historyScrollPane.setViewportView(historyPanel);

        add(historyScrollPane);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel favoritePanel;
    public javax.swing.JScrollPane favoriteScrollPane;
    public javax.swing.JPanel historyPanel;
    public javax.swing.JScrollPane historyScrollPane;
    // End of variables declaration//GEN-END:variables
}
