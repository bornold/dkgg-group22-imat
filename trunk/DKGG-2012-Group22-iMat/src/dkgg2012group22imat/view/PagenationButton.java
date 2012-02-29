/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.view;

import dkgg2012group22imat.controller.ProductsPanelController;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author jonas
 */
public class PagenationButton extends JButton implements ActionListener {

    private int page;
    private ProductsPanelController parent;

    public PagenationButton(int aPage, ProductsPanelController aParent) {
        super("" + (aPage + 1));
        this.page = aPage;
        this.parent = aParent;
        Icon img = new ImageIcon(this.getClass().getResource("/dkgg2012group22imat/resources/plupp.png"));
        
        this.setDisabledIcon(img);
        this.setHorizontalTextPosition(CENTER);
        this.setBorderPainted(false);
        this.setOpaque(false);
        this.setPreferredSize(new Dimension(60, 60));
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        super.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        parent.goToPage(page);
    }
}
