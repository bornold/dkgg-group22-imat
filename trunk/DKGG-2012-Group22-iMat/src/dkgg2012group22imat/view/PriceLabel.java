/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JLabel;

/**
 *
 * @author Simon
 */
public class PriceLabel extends JLabel {

    private FontMetrics fontMetrics;

    @Override
    protected void paintComponent(Graphics g) {
        //Padding:
        int x = 0;
        int y = 0;

        if (this.getWidth() > 20) {
            int w = getWidth() - x * 2;
            int h = getHeight() - y * 2;
            int arc = 10;

            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(new Color(255, 228, 0));
            g2.fillRoundRect(x, y, w, h, arc, arc);


        }

        super.paintComponent(g);

        //g2.dispose();
    }
    
    public Dimension getPreferredSize() {
        Dimension stringDimension = IMatUtilities.getStringDimension(this.getFont(),this.getText());
        
        return new Dimension(stringDimension.width+this.getIconTextGap()+4,stringDimension.height+this.getIconTextGap());
    }
    /*@Override
    public Dimension getSize() {
    
    return new Dimension(50,30);
    }*/
}
