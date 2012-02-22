/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.view;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.SpinnerUI;
import javax.swing.plaf.basic.BasicSpinnerUI;

/**
 *
 * @author Simon
 */
class StyledSpinnerUI extends BasicSpinnerUI {

    public static SpinnerUI createUI(JComponent c) {

        return new StyledSpinnerUI();

    }

    @Override
    protected Component createPreviousButton() {
        Component c = createIncDecButton(-1);
        installPreviousButtonListeners(c);
        return c;
    }
    
    @Override
    protected Component createNextButton() {
        Component c = createIncDecButton(1);
        installNextButtonListeners(c);
        return c;
    }

    private Component createIncDecButton(int direction) {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(dkgg2012group22imat.view.DKGG2012Group22iMatApp.class).getContext().getResourceMap(StyledSpinnerUI.class);

        
        String handler;
        
        if(direction < 0) {
            handler = "decrease";
        } else {
            handler = "increase";
        }
        JButton button = new JButton("");
        button.setIcon(resourceMap.getIcon(handler+".icon"));
        button.setBorderPainted(false);
        button.setName(handler); // NOI18N
        button.setPressedIcon(resourceMap.getIcon(handler+".pressedIcon")); // NOI18N
        button.setRolloverIcon(resourceMap.getIcon(handler+".rolloverIcon")); // NOI18N
        
        return button;
    }

    @Override
    public Dimension getMinimumSize(JComponent jc) {
        return new Dimension(10, 25);
    }
}
