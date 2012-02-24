/*
 * ItemPanel.java
 *
 * Created on Feb 17, 2012, 2:26:49 PM
 */
package dkgg2012group22imat.view;

import dkgg2012group22imat.controller.ProductController;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import org.jdesktop.swingx.graphics.GraphicsUtilities;
import org.jdesktop.swingx.graphics.ShadowRenderer;
import org.netbeans.lib.awtextra.AbsoluteLayout;
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
    Dimension small = new Dimension(150, 150);
    Dimension big = new Dimension(200, 200);
    

    /** Creates new form ItemPanel */
    public ProductPanel(Product p) {
        initComponents();
        controller = new ProductController(p, this);

        this.resetShadow();
        
    }

    @Override
    protected void paintComponent(Graphics g) {

        //Padding:
        int x = 10;
        int y = 10;

        int w = getWidth() - x * 2;
        int h = getHeight() - y * 2;
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

        priceLabel = new dkgg2012group22imat.view.PriceLabel();
        productNameLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        favoriteToggleButton = new javax.swing.JToggleButton();
        quantitySpinner = new javax.swing.JSpinner();
        productImageLabel = new dkgg2012group22imat.view.ProductImageLabel();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(dkgg2012group22imat.view.DKGG2012Group22iMatApp.class).getContext().getResourceMap(ProductPanel.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setMinimumSize(new java.awt.Dimension(180, 180));
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(180, 190));
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

        priceLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        priceLabel.setText(resourceMap.getString("priceLabel.text")); // NOI18N
        priceLabel.setFont(resourceMap.getFont("priceLabel.font")); // NOI18N
        priceLabel.setName("priceLabel"); // NOI18N
        add(priceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));
        remove(priceLabel);
        add(priceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70+priceLabel.getPreferredSize().width-85, 90, -1, -1));

        productNameLabel.setFont(resourceMap.getFont("productNameLabel.font")); // NOI18N
        productNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        productNameLabel.setText(resourceMap.getString("productNameLabel.text")); // NOI18N
        productNameLabel.setName("productNameLabel"); // NOI18N
        add(productNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 150, -1));

        addButton.setIcon(resourceMap.getIcon("addButton.icon")); // NOI18N
        addButton.setText(resourceMap.getString("addButton.text")); // NOI18N
        addButton.setBorderPainted(false);
        addButton.setName("addButton"); // NOI18N
        addButton.setPressedIcon(resourceMap.getIcon("addButton.pressedIcon")); // NOI18N
        addButton.setRolloverIcon(resourceMap.getIcon("addButton.rolloverIcon")); // NOI18N
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 148, 80, 30));

        favoriteToggleButton.setIcon(resourceMap.getIcon("favoriteToggleButton.icon")); // NOI18N
        favoriteToggleButton.setText(resourceMap.getString("favoriteToggleButton.text")); // NOI18N
        favoriteToggleButton.setBorderPainted(false);
        favoriteToggleButton.setDisabledIcon(resourceMap.getIcon("favoriteToggleButton.disabledIcon")); // NOI18N
        favoriteToggleButton.setName("favoriteToggleButton"); // NOI18N
        favoriteToggleButton.setPressedIcon(resourceMap.getIcon("favoriteToggleButton.pressedIcon")); // NOI18N
        favoriteToggleButton.setRolloverIcon(resourceMap.getIcon("favoriteToggleButton.rolloverIcon")); // NOI18N
        favoriteToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                favoriteToggleButtonActionPerformed(evt);
            }
        });
        add(favoriteToggleButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 80, 30));

        quantitySpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        quantitySpinner.setMinimumSize(new java.awt.Dimension(37, 26));
        quantitySpinner.setName("quantitySpinner"); // NOI18N
        quantitySpinner.setPreferredSize(new java.awt.Dimension(70, 26));
        add(quantitySpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 150, -1, -1));
        quantitySpinner.setUI(new StyledSpinnerUI());

        productImageLabel.setText(resourceMap.getString("productImageLabel.text")); // NOI18N
        productImageLabel.setName("productImageLabel"); // NOI18N
        add(productImageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 150, 80));
    }// </editor-fold>//GEN-END:initComponents

private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
    if (this.contains(evt.getPoint())) {
        controller.enhance();
    }

}//GEN-LAST:event_formMouseEntered

private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
    if (!this.contains(evt.getPoint())) {
        controller.defile();
    }
}//GEN-LAST:event_formMouseExited

private void favoriteToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_favoriteToggleButtonActionPerformed
    controller.favorize();
}//GEN-LAST:event_favoriteToggleButtonActionPerformed

private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    controller.addToCart();
}//GEN-LAST:event_addButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton addButton;
    public javax.swing.JToggleButton favoriteToggleButton;
    public dkgg2012group22imat.view.PriceLabel priceLabel;
    public dkgg2012group22imat.view.ProductImageLabel productImageLabel;
    public javax.swing.JLabel productNameLabel;
    public javax.swing.JSpinner quantitySpinner;
    // End of variables declaration//GEN-END:variables

    public int getAmount() {
        return Integer.parseInt(quantitySpinner.getValue().toString());
    }
    
    public void setAmount(double amount) {
        //TODO WARNING: double->int typecast
        quantitySpinner.setValue(new Integer((int)amount));
    }

    public void expandShadow() {
        this.shadowSize = 10;

    }

    public void resetShadow() {
        this.shadowSize = 2;

    }
}
