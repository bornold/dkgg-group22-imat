/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CategoryPanel.java
 *
 * Created on 2012-feb-26, 12:54:15
 */
package dkgg2012group22imat.view.shop;

import dkgg2012group22imat.controller.shop.Category;
import dkgg2012group22imat.controller.shop.CategoryPanelController;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Simon
 */
public class CategoryPanel extends javax.swing.JPanel {
    
    private CategoryPanelController controller;
    private Category category;
    private int level;

    /** Creates new form CategoryPanel */
    public CategoryPanel(Category category) {
        this(category, 1);
    }
    
    public CategoryPanel(Category category, int level) {
        initComponents();
        this.category = category;
        this.controller = new CategoryPanelController(this);
        
        this.setLevel(level);
    }
    
    public Category getCategory() {
        return this.category;
    }
    
    public JButton getCategoryButton() {
        return this.categoryButton;
    }
    
    public JPanel getSubCategoriesPanel() {
        return this.subCategoriesPanel;
    }
    
    public void setLevel(int level) {
        this.level = level;
        this.categoryButton.setPreferredSize(new Dimension(250 - (30*(level-1)), 30));
    }
    
    public int getLevel() {
        return level;
    }
    
    public void hideSubCategories() {
        this.jPanel1.setVisible(false);
    }
    
    public void showSubCategories() {
        this.jPanel1.setVisible(true);
        this.revalidate();
        this.repaint();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        categoryButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        subCategoriesPanel = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(30, 0), new java.awt.Dimension(32767, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 32767));

        setName("Form"); // NOI18N
        setLayout(new java.awt.BorderLayout());

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(dkgg2012group22imat.view.DKGG2012Group22iMatApp.class).getContext().getResourceMap(CategoryPanel.class);
        categoryButton.setBackground(resourceMap.getColor("categoryButton.background")); // NOI18N
        categoryButton.setFont(resourceMap.getFont("categoryButton.font")); // NOI18N
        categoryButton.setForeground(resourceMap.getColor("categoryButton.foreground")); // NOI18N
        categoryButton.setIcon(resourceMap.getIcon("categoryButton.icon")); // NOI18N
        categoryButton.setText(resourceMap.getString("categoryButton.text")); // NOI18N
        categoryButton.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("categoryButton.border.lineColor"))); // NOI18N
        categoryButton.setDisabledIcon(resourceMap.getIcon("categoryButton.disabledIcon")); // NOI18N
        categoryButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        categoryButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        categoryButton.setMaximumSize(new java.awt.Dimension(250, 30));
        categoryButton.setMinimumSize(new java.awt.Dimension(0, 30));
        categoryButton.setName("categoryButton"); // NOI18N
        categoryButton.setOpaque(true);
        categoryButton.setPressedIcon(resourceMap.getIcon("categoryButton.pressedIcon")); // NOI18N
        categoryButton.setRolloverIcon(resourceMap.getIcon("categoryButton.rolloverIcon")); // NOI18N
        categoryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                categoryButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                categoryButtonMouseEntered(evt);
            }
        });
        categoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryButtonActionPerformed(evt);
            }
        });
        add(categoryButton, java.awt.BorderLayout.NORTH);

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        subCategoriesPanel.setName("subCategoriesPanel"); // NOI18N
        subCategoriesPanel.setLayout(new javax.swing.BoxLayout(subCategoriesPanel, javax.swing.BoxLayout.Y_AXIS));
        jPanel1.add(subCategoriesPanel, java.awt.BorderLayout.CENTER);

        filler1.setName("filler1"); // NOI18N
        jPanel1.add(filler1, java.awt.BorderLayout.WEST);

        filler2.setName("filler2"); // NOI18N
        jPanel1.add(filler2, java.awt.BorderLayout.SOUTH);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

private void categoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryButtonActionPerformed
    controller.open();
}//GEN-LAST:event_categoryButtonActionPerformed
    
private void categoryButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoryButtonMouseEntered
    categoryButton.setForeground(Color.WHITE);
}//GEN-LAST:event_categoryButtonMouseEntered
    
private void categoryButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoryButtonMouseExited
    if (this.isEnabled()) {
        categoryButton.setForeground(new Color(51, 51, 51));
    }
}//GEN-LAST:event_categoryButtonMouseExited
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton categoryButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel subCategoriesPanel;
    // End of variables declaration//GEN-END:variables
}
