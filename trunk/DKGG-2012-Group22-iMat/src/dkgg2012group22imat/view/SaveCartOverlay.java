/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SaveCartOverlay.java
 *
 * Created on 2012-feb-27, 21:02:57
 */
package dkgg2012group22imat.view;

import dkgg2012group22imat.controller.CartPanelController;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Simon
 */
public class SaveCartOverlay extends javax.swing.JPanel {

    CartPanelController controller;

    /** Creates new form SaveCartOverlay */
    public SaveCartOverlay(CartPanelController controller) {
        initComponents();
        this.controller = controller;
        this.contract();
        this.jPanel3.setVisible(false);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Image img = new ImageIcon(this.getClass().getResource("/dkgg2012group22imat/resources/overlay_1.png")).getImage();
        Graphics2D g2d = (Graphics2D)g.create();
        g2d.drawImage(img, 0, 0, null, null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        errorLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        yesButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(240, 200));
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(240, 70));
        setSize(new java.awt.Dimension(240, 70));

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(250, 60));
        jPanel1.setLayout(null);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(dkgg2012group22imat.view.DKGG2012Group22iMatApp.class).getContext().getResourceMap(SaveCartOverlay.class);
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(150, 30, 78, 29);

        jTextField1.setText(resourceMap.getString("jTextField1.text")); // NOI18N
        jTextField1.setName("jTextField1"); // NOI18N
        jPanel1.add(jTextField1);
        jTextField1.setBounds(20, 30, 120, 28);

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 10, 131, 16);

        add(jPanel1);

        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(250, 25));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        errorLabel.setForeground(resourceMap.getColor("errorLabel.foreground")); // NOI18N
        errorLabel.setText(resourceMap.getString("errorLabel.text")); // NOI18N
        errorLabel.setName("errorLabel"); // NOI18N
        jPanel3.add(errorLabel);

        add(jPanel3);

        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 60));
        jPanel2.setLayout(null);

        yesButton.setText(resourceMap.getString("yesButton.text")); // NOI18N
        yesButton.setName("yesButton"); // NOI18N
        yesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesButtonActionPerformed(evt);
            }
        });
        jPanel2.add(yesButton);
        yesButton.setBounds(180, 30, 70, 29);

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 0, 180, 16);

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 15, 160, 16);

        add(jPanel2);

        jPanel4.setName("jPanel4"); // NOI18N
        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(250, 40));
        jPanel4.setSize(new java.awt.Dimension(250, 40));

        cancelButton.setText(resourceMap.getString("cancelButton.text")); // NOI18N
        cancelButton.setName("cancelButton"); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(165, Short.MAX_VALUE)
                .add(cancelButton))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(8, 8, 8)
                .add(cancelButton)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel4);
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    if (jTextField1.getText() != "" && jTextField1.getText() != null) {
        if (controller.saveCart(jTextField1.getText(), false) == -1) {
            this.expand();
        } else {
            controller.closeSaveCartDialog();
        }
    } else {
        this.showError("Du måste skriva in ett namn");
    }
}//GEN-LAST:event_jButton1ActionPerformed

private void yesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesButtonActionPerformed
    if (jTextField1.getText() != "" && jTextField1.getText() != null) {
        controller.saveCart(jTextField1.getText(), true);
        controller.closeSaveCartDialog();
    } else {
        this.showError("Du måste skriva in ett namn");
    }
}//GEN-LAST:event_yesButtonActionPerformed

private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
    controller.closeSaveCartDialog();
}//GEN-LAST:event_cancelButtonActionPerformed

private void showError(String error) {
    this.jPanel3.setVisible(true);
    this.errorLabel.setText(error);
}

    private void expand() {
        this.jPanel2.setVisible(true);
        setMaximumSize(new Dimension(250, 200));
        setPreferredSize(new Dimension(250, 200));
        setSize(new Dimension(250, 200));
    }

    private void contract() {
        this.jPanel2.setVisible(false);

        setMaximumSize(new Dimension(250, 110));
        setPreferredSize(new Dimension(250, 110));
        setSize(new Dimension(250, 110));
    }
    
    public void setName(String name) {
        this.jTextField1.setText(name);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton yesButton;
    // End of variables declaration//GEN-END:variables
}
