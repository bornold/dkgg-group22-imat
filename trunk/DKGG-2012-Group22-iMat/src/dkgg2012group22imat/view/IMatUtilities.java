/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.view;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

/**
 *
 * @author Simon
 */
public class IMatUtilities {

    public static void drawTiled(Graphics g, Dimension d, ImageIcon icon) {

        Image image = icon.getImage();

        int width = image.getWidth(null);
        int height = image.getHeight(null);

        for (int x = 0; x < d.width; x += width) {
            for (int y = 0; y < d.height; y += height) {
                g.drawImage(image, x, y, null, null);
            }
        }
    }

    public static void addHoverListener(Component c, MouseListener ml) {
        Toolkit.getDefaultToolkit().addAWTEventListener(new TargetedMouseListener(c, ml), AWTEvent.MOUSE_MOTION_EVENT_MASK);
    }
}
