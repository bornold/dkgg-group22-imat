/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EntranceTestFrame.java
 *
 * Created on Feb 21, 2012, 9:10:10 AM
 */
package dkgg2012group22imat.view;

import dkgg2012group22imat.model.Model;

/**
 *
 * @author jonas
 */
public class EntranceTestFrame extends javax.swing.JFrame {

    /** Creates new form EntranceTestFrame */
    public EntranceTestFrame() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        favoriteProductsPanel1 = new dkgg2012group22imat.view.entrance.FavoriteProductsPanel();
        spotlightProductsPanel1 = new dkgg2012group22imat.view.entrance.SpotlightProductsPanel();
        favoriteProductsPanel2 = new dkgg2012group22imat.view.entrance.FavoriteProductsPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        historyCartsPanel1 = new dkgg2012group22imat.view.entrance.HistoryCartsPanel();

        favoriteProductsPanel1.setName("favoriteProductsPanel1"); // NOI18N

        setDefaultCloseOperation(Model.getInstance().shutDown());
        setName("Form"); // NOI18N

        spotlightProductsPanel1.setName("spotlightProductsPanel1"); // NOI18N

        favoriteProductsPanel2.setName("favoriteProductsPanel2"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        historyCartsPanel1.setName("historyCartsPanel1"); // NOI18N
        jScrollPane1.setViewportView(historyCartsPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(favoriteProductsPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spotlightProductsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(373, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(spotlightProductsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1598, 1598, 1598)
                        .addComponent(favoriteProductsPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EntranceTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EntranceTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EntranceTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntranceTestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new EntranceTestFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private dkgg2012group22imat.view.entrance.FavoriteProductsPanel favoriteProductsPanel1;
    private dkgg2012group22imat.view.entrance.FavoriteProductsPanel favoriteProductsPanel2;
    private dkgg2012group22imat.view.entrance.HistoryCartsPanel historyCartsPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private dkgg2012group22imat.view.entrance.SpotlightProductsPanel spotlightProductsPanel1;
    // End of variables declaration//GEN-END:variables
}
