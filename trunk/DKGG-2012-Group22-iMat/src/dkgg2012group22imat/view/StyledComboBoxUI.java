/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.view;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 *
 * @author Simon
 */
class StyledComboBoxUI extends BasicComboBoxUI {

    public static ComboBoxUI createUI(JComponent c) {
        return new StyledComboBoxUI();
    }

    @Override protected JButton createArrowButton() {
        
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(dkgg2012group22imat.view.DKGG2012Group22iMatApp.class).getContext().getResourceMap(StyledComboBoxUI.class);
        
        JButton button = new JButton("");
        button.setIcon(resourceMap.getIcon("button.icon"));
        button.setBorderPainted(false);
        button.setName("button"); // NOI18N
        button.setPressedIcon(resourceMap.getIcon("button.pressedIcon")); // NOI18N
        button.setRolloverIcon(resourceMap.getIcon("button.rolloverIcon")); // NOI18N

        return button;
        /*return new BasicArrowButton(
            BasicArrowButton.SOUTH,
            Color.cyan, Color.magenta,
            Color.yellow, Color.blue);*/
    }
    
    @Override public Dimension getMinimumSize(JComponent jc) {
        return new Dimension(75,26);
    }
    
    
    
}
