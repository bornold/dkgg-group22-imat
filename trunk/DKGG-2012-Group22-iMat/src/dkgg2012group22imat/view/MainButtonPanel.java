/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainButtonPanel.java
 *
 * Created on Feb 19, 2012, 9:03:27 PM
 */
package dkgg2012group22imat.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

/**
 *
 * @author jonas
 */
public class MainButtonPanel extends javax.swing.JPanel {
    
    Image image;

    /** Creates new form MainButtonPanel */
    public MainButtonPanel() {
        initComponents();
        this.setUI(null);
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/dkgg2012group22imat/resources/maintabs_bg.png"));
        } catch(Exception e) {
            
        }
        
    }

    @Override
    protected void paintComponent(Graphics g) {

        this.drawTiled(g);

    }
    /*
	 *  Custom painting code for drawing TILED images as the background
	 */
	private void drawTiled(Graphics g)
	{
		   Dimension d = getSize();
		   int width = image.getWidth( null );
		   int height = image.getHeight( null );

		   for (int x = 0; x < d.width; x += width)
		   {
			   for (int y = 0; y < d.height; y += height)
			   {
				   g.drawImage( image, x, y, null, null );
			   }
		   }
	}

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(30, 30), new java.awt.Dimension(30, 30), new java.awt.Dimension(30, 30));
        jPanel1 = new javax.swing.JPanel();
        mainTabEntranceButton = new dkgg2012group22imat.view.MainTabButton();
        mainTabShopButton = new dkgg2012group22imat.view.MainTabButton();
        mainTabCheckoutButton = new dkgg2012group22imat.view.MainTabButton();

        setName("Form"); // NOI18N
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        filler1.setName("filler1"); // NOI18N
        add(filler1);

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setOpaque(false);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(dkgg2012group22imat.view.DKGG2012Group22iMatApp.class).getContext().getResourceMap(MainButtonPanel.class);
        mainTabEntranceButton.setBackground(resourceMap.getColor("mainTabEntranceButton.background")); // NOI18N
        mainTabEntranceButton.setIcon(resourceMap.getIcon("mainTabEntranceButton.icon")); // NOI18N
        mainTabEntranceButton.setText(resourceMap.getString("mainTabEntranceButton.text")); // NOI18N
        mainTabEntranceButton.setBorderPainted(false);
        mainTabEntranceButton.setName("mainTabEntranceButton"); // NOI18N
        mainTabEntranceButton.setPreferredSize(new java.awt.Dimension(190, 80));
        mainTabEntranceButton.setRolloverIcon(resourceMap.getIcon("mainTabEntranceButton.rolloverIcon")); // NOI18N
        mainTabEntranceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainTabEntranceButtonActionPerformed(evt);
            }
        });
        jPanel1.add(mainTabEntranceButton);

        mainTabShopButton.setIcon(resourceMap.getIcon("mainTabShopButton.icon")); // NOI18N
        mainTabShopButton.setText(resourceMap.getString("mainTabShopButton.text")); // NOI18N
        mainTabShopButton.setName("mainTabShopButton"); // NOI18N
        mainTabShopButton.setPreferredSize(new java.awt.Dimension(190, 80));
        mainTabShopButton.setRolloverIcon(resourceMap.getIcon("mainTabShopButton.rolloverIcon")); // NOI18N
        mainTabShopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainTabShopButtonActionPerformed(evt);
            }
        });
        jPanel1.add(mainTabShopButton);

        mainTabCheckoutButton.setIcon(resourceMap.getIcon("mainTabCheckoutButton.icon")); // NOI18N
        mainTabCheckoutButton.setText(resourceMap.getString("mainTabCheckoutButton.text")); // NOI18N
        mainTabCheckoutButton.setName("mainTabCheckoutButton"); // NOI18N
        mainTabCheckoutButton.setPreferredSize(new java.awt.Dimension(190, 80));
        mainTabCheckoutButton.setRolloverIcon(resourceMap.getIcon("mainTabCheckoutButton.rolloverIcon")); // NOI18N
        mainTabCheckoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainTabCheckoutButtonActionPerformed(evt);
            }
        });
        jPanel1.add(mainTabCheckoutButton);

        add(jPanel1);
        //((FlowLayout)jPanel1.getLayout()).setHgap(20);
        //((FlowLayout)jPanel1.getLayout()).setVgap(20);
    }// </editor-fold>//GEN-END:initComponents

private void mainTabEntranceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainTabEntranceButtonActionPerformed
System.out.println("GO TO ENTRANCE");
}//GEN-LAST:event_mainTabEntranceButtonActionPerformed

private void mainTabShopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainTabShopButtonActionPerformed
System.out.println("GO TO SHOP");
}//GEN-LAST:event_mainTabShopButtonActionPerformed

private void mainTabCheckoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainTabCheckoutButtonActionPerformed
System.out.println("GO TO CHECKOUT");
}//GEN-LAST:event_mainTabCheckoutButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JPanel jPanel1;
    private dkgg2012group22imat.view.MainTabButton mainTabCheckoutButton;
    private dkgg2012group22imat.view.MainTabButton mainTabEntranceButton;
    private dkgg2012group22imat.view.MainTabButton mainTabShopButton;
    // End of variables declaration//GEN-END:variables
}
