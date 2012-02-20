/*
 * ItemPanel.java
 *
 * Created on Feb 17, 2012, 2:26:49 PM
 */
package dkgg2012group22imat.view;

import dkgg2012group22imat.controller.ProductController;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import org.jdesktop.swingx.graphics.GraphicsUtilities;
import org.jdesktop.swingx.graphics.ShadowRenderer;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author jonas
 */
public class ProductPanel extends javax.swing.JPanel {

    ProductController controller;
    boolean inside;
    private BufferedImage shadow;
    private int shadowSize;

    /** Creates new form ItemPanel */
    public ProductPanel(Product p) {
        initComponents();
        controller = new ProductController(p, this);
        System.out.println("product panel inni");
        
        this.resetShadow();
    }

    @Override
    protected void paintComponent(Graphics g) {
        
        //Padding:
        int x = 10;
        int y = 10;
        
        int w = getWidth() - x*2;
        int h = getHeight() - y*2;
        int arc = 15;

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);


        if (shadow != null) {
            int xOffset = (shadow.getWidth() - w) / 2;
            int yOffset = (shadow.getHeight() - h) / 2;
            g2.drawImage(shadow, x - xOffset, y - yOffset, null);
        }
        
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(x, y, w, h, arc, arc);

        g2.dispose();
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);

        int w = getWidth() - 20;
        int h = getHeight() - 20;
        int arc = 20;

        shadow = GraphicsUtilities.createCompatibleTranslucentImage(w, h);
        Graphics2D g2 = shadow.createGraphics();
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(0, 1, w, h, arc, arc);
        g2.dispose();

        ShadowRenderer renderer = new ShadowRenderer(shadowSize, 0.5f, Color.BLACK);
        shadow = renderer.createShadow(shadow);
        
        //Removes the shadow from the content (in case the background is transparent, which is isnt, ah well who knows what happens in the furure, it makes it good to copy, unless someone writes a stupidly long comment on one line so you need to scroll horizontally to see what stupid things he tries to say, thats very frustrating...
        g2 = shadow.createGraphics();
        g2.setColor(Color.RED);
        g2.setComposite(AlphaComposite.Clear);
        g2.fillRoundRect(shadowSize, shadowSize, w, h, arc, arc);
        g2.dispose();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        productNameLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        iconLabel = new javax.swing.JLabel();
        quantityComboBox = new javax.swing.JComboBox();
        priceLabel = new javax.swing.JLabel();
        favoriteToggleButton = new javax.swing.JToggleButton();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(dkgg2012group22imat.view.DKGG2012Group22iMatApp.class).getContext().getResourceMap(ProductPanel.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setMaximumSize(new java.awt.Dimension(200, 200));
        setMinimumSize(new java.awt.Dimension(100, 100));
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(150, 150));
        setRequestFocusEnabled(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        productNameLabel.setText(resourceMap.getString("productNameLabel.text")); // NOI18N
        productNameLabel.setName("productNameLabel"); // NOI18N
        add(productNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 113, -1));

        addButton.setIcon(resourceMap.getIcon("addButton.icon")); // NOI18N
        addButton.setText(resourceMap.getString("addButton.text")); // NOI18N
        addButton.setBorderPainted(false);
        addButton.setName("addButton"); // NOI18N
        addButton.setPressedIcon(resourceMap.getIcon("addButton.pressedIcon")); // NOI18N
        addButton.setRolloverIcon(resourceMap.getIcon("addButton.rolloverIcon")); // NOI18N
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addButtonMouseEntered(evt);
            }
        });
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        iconLabel.setText(resourceMap.getString("iconLabel.text")); // NOI18N
        iconLabel.setName("iconLabel"); // NOI18N
        add(iconLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 44, -1, -1));

        quantityComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" }));
        quantityComboBox.setName("quantityComboBox"); // NOI18N
        quantityComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                quantityComboBoxMouseEntered(evt);
            }
        });
        add(quantityComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));
        quantityComboBox.setUI(new StyledComboBoxUI());

        priceLabel.setText(resourceMap.getString("priceLabel.text")); // NOI18N
        priceLabel.setName("priceLabel"); // NOI18N
        add(priceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        favoriteToggleButton.setText(resourceMap.getString("favoriteToggleButton.text")); // NOI18N
        favoriteToggleButton.setName("favoriteToggleButton"); // NOI18N
        favoriteToggleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                favoriteToggleButtonMouseEntered(evt);
            }
        });
        favoriteToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                favoriteToggleButtonActionPerformed(evt);
            }
        });
        add(favoriteToggleButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    controller.addToCart();
}//GEN-LAST:event_addButtonActionPerformed

private void favoriteToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_favoriteToggleButtonActionPerformed
    controller.favorize();
}//GEN-LAST:event_favoriteToggleButtonActionPerformed

private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
    if (!inside) {
        inside = true;
        controller.enhance();
    }

}//GEN-LAST:event_formMouseEntered

private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
    if (!this.contains(evt.getPoint())) {
        inside = false;
        controller.defile(((java.awt.event.MouseEvent) evt).getLocationOnScreen());
    }

}//GEN-LAST:event_formMouseExited

private void favoriteToggleButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_favoriteToggleButtonMouseEntered
// controller.enhance();
}//GEN-LAST:event_favoriteToggleButtonMouseEntered

private void addButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseEntered
//controller.enhance();
}//GEN-LAST:event_addButtonMouseEntered

private void quantityComboBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quantityComboBoxMouseEntered
// controller.enhance();
}//GEN-LAST:event_quantityComboBoxMouseEntered
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    public javax.swing.JToggleButton favoriteToggleButton;
    public javax.swing.JLabel iconLabel;
    public javax.swing.JLabel priceLabel;
    public javax.swing.JLabel productNameLabel;
    private javax.swing.JComboBox quantityComboBox;
    // End of variables declaration//GEN-END:variables

    public int getAmount() {
        return quantityComboBox.getSelectedIndex();
    }
    
    public void expandShadow() {
        this.shadowSize = 10;
        
    }   
    
    public void resetShadow() {
        this.shadowSize = 3;
        
    }
}
