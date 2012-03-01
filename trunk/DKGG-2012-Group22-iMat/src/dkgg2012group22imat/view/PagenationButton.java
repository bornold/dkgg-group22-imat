/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.view;

import dkgg2012group22imat.controller.ProductsPanelController;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author jonas
 */
public class PagenationButton extends JButton implements ActionListener {

    private int page;
    private ProductsPanelController parent;
    private ImageIcon img;

    public PagenationButton(int aPage, ProductsPanelController aParent) {
        super("" + (aPage + 1));
        this.page = aPage;
        this.parent = aParent;
        img = new ImageIcon(this.getClass().getResource("/dkgg2012group22imat/resources/plupp.png"));
        this.setText("<html><font color=black>"+(page+1)+"</font></html>");
        this.setDisabledIcon(img);
        this.setHorizontalTextPosition(CENTER);
        this.setBorderPainted(false);
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(60, 30));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setToolTipText("Gå till sida " + (page+1));
        super.addActionListener(this);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        if(!this.isEnabled()) {
            g.drawImage(img.getImage(),18,2,null,null);
            this.setText("<html><font color=white>"+(page+1)+"</font></html>");
        }
        super.paintComponent(g);
    }

    public void actionPerformed(ActionEvent ae) {
        parent.goToPage(page);
    }
}
