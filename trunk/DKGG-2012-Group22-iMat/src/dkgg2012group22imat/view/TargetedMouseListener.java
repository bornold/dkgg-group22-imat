/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.view;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author Simon
 */
public class TargetedMouseListener implements AWTEventListener {

    private Component innerBound;
    private MouseListener mouseListener;
    private boolean hasExited = true;

    public TargetedMouseListener(Component innerBound, MouseListener mouseListener) {
        this.innerBound = innerBound;
        this.mouseListener = mouseListener;
    }

    @Override
    public void eventDispatched(AWTEvent e) {
        if (e instanceof MouseEvent) {
            if (innerBound.isDisplayable()) {
                MouseEvent m = (MouseEvent) e;
                Point p = SwingUtilities.convertPoint(
                        (Component) e.getSource(),
                        m.getPoint(),
                        innerBound);
                
                Rectangle bounds = innerBound.getBounds();
                bounds.setLocation(0,0);
                
                if (hasExited && bounds.contains(p)) {
                    mouseListener.mouseEntered(m);
                    hasExited = false;
                } else if (!bounds.contains(p) && !hasExited) {
                    mouseListener.mouseExited(m);
                    hasExited = true;
                }
            } else {
                this.innerBound = null; //Since the object is no longer visible, we assume it to be deleted and this will eventually send it to garbage colleciton.
                Toolkit.getDefaultToolkit().removeAWTEventListener(this); //Also remove this as listener.
            }
        }
    }
}